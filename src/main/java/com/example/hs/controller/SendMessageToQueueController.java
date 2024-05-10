package com.example.hs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hs.dto.LoginDto;
import com.example.hs.service.AWSMessageService;

@Controller
@RequestMapping("/api")
public class SendMessageToQueueController {

	@Autowired
	AWSMessageService awsMessageService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@GetMapping("/")
    @ResponseBody
	public String sendMessage() {
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-12");
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-32");
//		 awsMessageService.sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/637423560387/hs-queue-processingfiles.fifo", "testing000000-43");
		System.out.println("asdasdasd"); 
		return "abc";
		 
	 }
	
	
	@PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

	public record LoginRequest(String username, String password) {
	}
}
