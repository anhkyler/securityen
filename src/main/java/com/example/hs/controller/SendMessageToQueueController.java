package com.example.hs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hs.service.AWSMessageService;

@Controller
public class SendMessageToQueueController {

	@Autowired
	AWSMessageService awsMessageService;
	
	@GetMapping("/")
    @ResponseBody
	public String sendMessage() {
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-12");
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-32");
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-43");
		System.out.println("asdasdasd"); 
		return "abc";
		 
	 }
}
