package com.frame.intercept;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.utils.FileUtils;

import contant.Contant;
/**
 * 使用servlet 注解 进行文件上传
 * @author bobo
 *
 */
@WebServlet("/file/load")
public class FileUploadServlet extends HttpServlet{
	private static Map<String, Vector<Integer>> LOCKMAP = new ConcurrentHashMap<String, Vector<Integer>>();
	private static Vector<Integer> LOCKList = new Vector<Integer>();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7237461204344487455L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		this.doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setFileSizeMax(100*1024*1024);
		fileUpload.setSizeMax(100*1024*1024);
		int count = 100*1024*1024;
		float precent = 0f;
		String status = "succ";
		String realName = "";
		String REALIP = "";
		String REALUUID = "";
        //根据定义规则 进行传输最后一个文件进行文件合并
        int last_Id = 0;
        int cur_ID = 0;
        try {
            //3.把请求数据转换为FileItem对象的集合
            List<FileItem> list = fileUpload.parseRequest(req);
            //遍历，得到每一个上传项
            int fileCount = 1;
            for (FileItem item : list){
                //判断：是普通表单项，还是文件上传表单项
                //文件上传表单
                String name = item.getName(); //上传的文件名称
                realName = item.getName();
                String filename = item.getFieldName();
                if (filename.indexOf("——")>-1) {
                	//chunkCount+"——"+(index+1)+"——"+REALIP+"_"+uuid 定义唯一规则
                	last_Id = Integer.valueOf(filename.split("——")[0]);
                	cur_ID = Integer.valueOf(filename.split("——")[1]);
                	REALIP = filename.split("——")[2].split("_")[0];
                	REALUUID = filename.split("——")[2].split("_")[1];
                	LOCKList.add(cur_ID);
				}
                //a.随机生成一个唯一标记
                String id = UUID.randomUUID().toString().replace("-", "");
                id = id+"_";
                //【三、上传到指定目录：获取上传目录路径】
                String realPath = Contant.TMP_DIR+REALUUID+"//";
                //创建文件对象
                File file = new File(realPath);
                if(!file.exists() && !file.isDirectory()){
                	file.mkdirs();
    			}
                //获取文件输入流
                InputStream instream = item.getInputStream();
                System.out.println(realPath+id+name);
                FileOutputStream outstream = new FileOutputStream(realPath+id+name);
                byte[] buffer = new byte[1024];
                int r = 0;
                int add = 0;
                while((r = instream.read(buffer)) != -1){
                	outstream.write(buffer,0,r);
                	outstream.flush();
                	add += r;
                	precent = add/Float.valueOf(count);
                	req.getSession().setAttribute(Contant.TMP_PRE, precent);
                }
                instream.close();
                outstream.close();
                item.delete();
                fileCount++;
            }
            int tmp = 0;
            if(last_Id == cur_ID){
            	tmp = last_Id;
            }
            if (tmp==last_Id&&LOCKList.size()==last_Id) {
            	FileUtils.mergeFile(realName,REALUUID);
            	LOCKList.clear();
            	FileUtils.deleteAllFilesOfDir(new File(Contant.TMP_DIR+REALUUID));
			}
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(status);
	}
	
}
