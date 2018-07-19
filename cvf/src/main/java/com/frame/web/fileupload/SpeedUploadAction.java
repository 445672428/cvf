package com.frame.web.fileupload;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.base.BaseSaveFile;
import com.frame.service.FileService;
import com.pojo.FileInfo;
import com.utils.ComUtils;

@Controller
@RequestMapping(value="file")
public class SpeedUploadAction extends BaseSaveFile{
	@Autowired
	private FileService fileService;
	
	@ResponseBody
    @RequestMapping(value = "/IsMD5Exist", method = RequestMethod.POST)
    public String bigFileUpload(String fileMd5, String fileName, String fileID) {

        try {
            boolean md5Exist = fileService.isMd5Exist(fileMd5);
            if (md5Exist) {
                return "this file is exist";
            } else {
                return "this file is not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "this file is not exist";
        }
    }
	 /**
     * @param guid             临时文件名
     * @param md5value         客户端生成md5值
     * @param chunks           分块数
     * @param chunk            分块序号
     * @param id               文件id便于区分
     * @param name             上传文件名
     * @param type             文件类型
     * @param lastModifiedDate 上次修改时间
     * @param size             文件大小
     * @param file             文件本身
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bigfileup")
    public String fileUpload(String guid,String md5value,String chunks, String chunk,String id,String name,String type,
    		String lastModifiedDate,int size,MultipartFile file) {
        String fileName;
        try {
            int index;
            String uploadFolderPath = getRealPath();

            String mergePath =uploadFolderPath + guid + "/";
            String ext = name.substring(name.lastIndexOf("."));

            //判断文件是否分块
            if (chunks != null && chunk != null) {
                index = Integer.parseInt(chunk);
                fileName = String.valueOf(index) + ext;
                // 将文件分块保存到临时文件夹里，便于之后的合并文件
                saveFile(mergePath, fileName, file);
                // 验证所有分块是否上传成功，成功的话进行合并
                Uploaded(md5value, guid, chunk, chunks, uploadFolderPath, fileName, ext, fileService);
            } else {
                fileName = guid + ext;
                //上传文件没有分块的话就直接保存
                saveFile(uploadFolderPath, fileName, file);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "{\"error\":true}";
        }

        return "{jsonrpc = \"2.0\",id = id,filePath = \"/Upload/\" + fileFullName}";
    }
	/**
	 * 单文件上传
	 * @param id
	 * @param name
	 * @param type
	 * @param lastModifiedDate
	 * @param size
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/fileup", method = RequestMethod.POST)
	public String refileUpload(@RequestParam("id") String id,
	                         @RequestParam("name") String name,
	                         @RequestParam("type") String type,
	                         @RequestParam("lastModifiedDate") String lastModifiedDate,
	                         @RequestParam("size") int size,
	                         @RequestParam("file") MultipartFile file) {
		String fileName;

		try {
			String ext = name.substring(name.lastIndexOf("."));
			fileName = UUID.randomUUID().toString() + ext;
			saveFile(getRealPath(), fileName, file);
		} catch (Exception ex) {
			return "{\"error\":true}";
		}
		try {
			fileService.save(new FileInfo(fileName, ComUtils.createMd5(file).toString(), new Timestamp(1)));
		} catch (Exception e) {
			return "{\"error\":true}";
		}

		return "{jsonrpc = \"2.0\",id = id,filePath = \"/Upload/\" + fileFullName}";
	}
	@ResponseBody
    @RequestMapping(value = "/imageup", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("type") String type,
                             @RequestParam("lastModifiedDate") String lastModifiedDate,
                             @RequestParam("size") int size,
                             @RequestParam("file") MultipartFile file) {
        String fileName = "";

        MultipartFile saveFile = null;

        try {
            saveFile = (MultipartFile) ComUtils.deepClone(file);
            java.io.File tempFile = new java.io.File(UUID.randomUUID().toString());
            file.transferTo(tempFile);
            if (!ComUtils.isImage(tempFile))
                return "{\"error\":true}";

            String realpath = getRealPath();
            String ext = name.substring(name.lastIndexOf("."));
            fileName = UUID.randomUUID().toString() + ext;
            saveFile(realpath, fileName, saveFile);

            fileService.save(new FileInfo(fileName, ComUtils.createMd5(file).toString(), new Timestamp(1)));

        } catch (Exception ex) {
            return "{\"error\":true}";
        }

        return "{jsonrpc = \"2.0\",id = id,filePath = \"/Upload/\" + fileFullName}";
    }
	/**
	 * 多个文件选择器上传文件，一个选择器对应一个文件
	 * @param type
	 * @param name
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping(value = "/entityUp", method = RequestMethod.POST)
    public ResponseEntity<Void> fileUpload(@RequestParam("type") String type,
                                           @RequestParam("name") String name,
                                           @RequestParam("file") MultipartFile file) throws Exception {

        switch (type) {
            case "researchReport": //研究报告
                //save file
                break;
            case "researchReportStuff": //研究报告支撑材料(限PDF)
                //save file
                break;
            case "applyReport": //应用报告
                //save file
                break;
            case "applyReportStuff": //应用报告支撑材料(限PDF)
                //save file
                break;
            default:
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
