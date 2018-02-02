package com.base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.entities.FileInfo;
import com.entities.UploadInfo;
import com.frame.service.FileService;
/**
 * 文件处理基类
 * @author bobo
 *
 */
public class BaseSaveFile {
	private static final File UPLOADDIRECTION = new File(getRealPath());
	private final static Queue<UploadInfo> uploadInfoList = new ConcurrentLinkedQueue<UploadInfo>();

    /**
     * @param chunksNumber
     * @param ext
     * @param guid
     * @param uploadFolderPath
     * @throws Exception
     */
    public static void mergeFile(final int chunksNumber,final String ext,final String guid,final String uploadFolderPath,final String fileName)
            throws Exception {
        /*合并输入流*/
        String mergePath = uploadFolderPath + guid + "/";
        SequenceInputStream s ;
        InputStream s1 = new FileInputStream(mergePath + 0 + ext);
        InputStream s2 = new FileInputStream(mergePath + 1 + ext);
        s = new SequenceInputStream(s1, s2);
        for (int i = 2; i < chunksNumber; i++) {
            InputStream s3 = new FileInputStream(mergePath + i + ext);
            s = new SequenceInputStream(s, s3);
        }

        //通过输出流向文件写入数据
        saveStreamToFile(s, uploadFolderPath + guid + ext);

        //删除保存分块文件的文件夹
        deleteFolder(mergePath);

    }
    /**
     * 删除指定文件夹
     * @param folderPath 文件夹路径
     * @return 是否删除成功
     */
    public static boolean deleteFolder( final String folderPath) {
        File dir = new File(folderPath);
        File[] files = dir.listFiles();
        if(files!=null){
            for (File file : files) {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return dir.delete();
    }
    /**
     * 从stream中保存文件
     *
     * @param inputStream inputStream
     * @param filePath    保存路径
     * @throws Exception 异常 抛异常代表失败了
     */
    public static void saveStreamToFile( final InputStream inputStream,final String filePath)throws Exception {
         /*创建输出流，写入数据，合并分块*/
        OutputStream outputStream = new FileOutputStream(filePath);
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }
	   /**
     * @param md5         MD5
     * @param guid        随机生成的文件名
     * @param chunk       文件分块序号
     * @param chunks      文件分块数
     * @param fileName    文件名
     * @param ext         文件后缀名
     * @param fileService fileService
     */
    public static void Uploaded( final String md5,final String guid,final String chunk,final String chunks,
            final String uploadFolderPath,final String fileName,final String ext,final FileService fileService)throws Exception {
        synchronized (uploadInfoList) {
            uploadInfoList.add(new UploadInfo(md5, chunks, chunk, uploadFolderPath, fileName, ext));
        }
        boolean allUploaded = isAllUploaded(md5, chunks);
        int chunksNumber = Integer.parseInt(chunks);
        if (allUploaded) {
            mergeFile(chunksNumber, ext, guid, uploadFolderPath, fileName);
            fileService.save(new FileInfo(guid + ext, md5, new Timestamp(1)));
            Iterator<UploadInfo> t = uploadInfoList.iterator();
    		while (t.hasNext()) {
    			UploadInfo loadInfo = t.next();
    			if (md5!=null&&md5.equals(loadInfo.getMd5())) {
					t.remove();
				}
    		}
        }
    }
    /**
     * @param md5
     * @param chunks
     * @return
     */
    public static boolean isAllUploaded( final String md5,final String chunks) {
        synchronized (uploadInfoList) {
        	int size = 0;
        	Iterator<UploadInfo> t = uploadInfoList.iterator();
    		while (t.hasNext()) {
    			UploadInfo loadInfo = t.next();
    			if (md5!=null&&md5.equals(loadInfo.getMd5())) {
    				size ++;
				}
    		}
            boolean bool = (size == Integer.parseInt(chunks));
            return bool;
        }
    }
	 /**
     * @param savePath
     * @param fileFullName
     * @param file
     * @return
     * @throws Exception
     */
    public static boolean saveFile(final String savePath,final String fileFullName,final MultipartFile file)
            throws Exception {
        byte[] data = readInputStream(file.getInputStream());
        //new一个文件对象用来保存图片，默认保存当前工程根目录
        File uploadFile = new File(savePath + fileFullName);
        //判断文件夹是否存在，不存在就创建一个
        File fileDirectory = new File(savePath);
        synchronized (UPLOADDIRECTION){
            if(!UPLOADDIRECTION.exists()){
                if(!UPLOADDIRECTION.mkdir()){
                    throw new Exception("保存文件的父文件夹创建失败！路径为：" + savePath);
                }
            }
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new Exception("文件夹创建失败！路径为：" + savePath);
                }
            }
        }
        //创建输出流
        try (FileOutputStream outStream = new FileOutputStream(uploadFile)) {//写入数据
            outStream.write(data);
            outStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return uploadFile.exists();
    }
	
	
	private static byte[] readInputStream(InputStream inStream) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
	}
	   /**
     * 根据文件路径获取File
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static File getFileByPath(String filePath) throws IOException {
        Path path = Paths.get(getRealPath() + filePath);
        if (Files.exists(path)) {
            return new File(path.toUri());
        }
        return null;
    }
    /**
     * 压缩文件
     *
     * @param srcFileList
     * @param zipFile
     * @throws IOException
     */
    public static void zipFiles(List<File> srcFileList, java.io.File zipFile) throws IOException {
        byte[] buf = new byte[1024];
        //ZipOutputStream类：完成文件或文件夹的压缩
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
        for (File aSrcFileList : srcFileList) {
            FileInputStream in = new FileInputStream(aSrcFileList);
            out.putNextEntry(new ZipEntry(aSrcFileList.getName()));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();
        }
        out.close();
    }
	protected static String getRealPath() {
		return "D:\\temp\\";
	}
}
