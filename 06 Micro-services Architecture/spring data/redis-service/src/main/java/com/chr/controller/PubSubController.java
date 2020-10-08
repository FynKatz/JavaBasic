package com.chr.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chr.domain.MessageList;
import com.chr.service.impl.PubServiceImpl;
import com.chr.service.impl.SubServiceImpl;

@Controller
@RequestMapping(value = "/pubsub")
public class PubSubController {
	@Resource(name = "pubServiceImpl")
	private PubServiceImpl pubService;

	@Autowired
	private SubServiceImpl subService;

	//获取sub页数据（订阅消息）
	@RequestMapping(value = "/sub")
	public String Subscriber(Model model) {
		MessageList messageList = subService.getMessageList();//获取MessageList对象的实例
		ArrayList<String> arrayList = (ArrayList<String>) messageList.output();//进一步迭代器去读取
		model.addAttribute("arrayList", arrayList);//转发
		return "/WEB-INF/jsp/subResult.jsp";
	}

	//获取pub页面
	@RequestMapping(value = "/pub", method = RequestMethod.GET)
	public String Subscriber() {
		return "/WEB-INF/jsp/pub.jsp";
	}

	//pub页提交数据（发布消息）
	@RequestMapping(value = "/pub", method = RequestMethod.POST)
	public String Publisher(@RequestParam(value = "message", required = true) String message) {
		pubService.Publisher(message);//发布消息到Channel
		return "/WEB-INF/jsp/pubResult.jsp";
	}
}
