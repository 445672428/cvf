package com.frame.web.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.frame.service.EmailSenderService;
import com.pojo.ResultMeta;

@Controller
@RequestMapping(value="email")
public class EmailController {
	@Autowired
	private EmailSenderService emailSenderService;
	
	@RequestMapping(value="send",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sendToDesignatedPerson(String cid,String tid,String subject,String content) {
		String[] sendTo = tid.split(",");
		ResultMeta resultMeta = new ResultMeta();
		try {
			emailSenderService.sendSimpleMessage(cid, sendTo, subject, content);
		} catch (Exception e) {
			e.printStackTrace();
			resultMeta.failure("发送失败");
		}
		resultMeta.failure("发送成功");
		return JSONObject.toJSONString(resultMeta);
	}
}
