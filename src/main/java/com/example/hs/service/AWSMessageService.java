package com.example.hs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageSystemAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.hs.config.SqsConfig;

@Service
public class AWSMessageService {

	private final SqsConfig sqsConfig;
	
	public AWSMessageService(SqsConfig sqsConfig) {
        this.sqsConfig = sqsConfig;
    }
	
	
//	https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-sqs-messages.html
	public void sendMessageToQueue(String queueUrl, String messageBody) {
		List<SendMessageBatchRequestEntry> messageEntries = new ArrayList<>();
		BasicAWSCredentials credentialsProvider = new BasicAWSCredentials("", "");
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentialsProvider))
                .build();
		
		SendMessageRequest send_msg_request = new SendMessageRequest()
		        .withQueueUrl(queueUrl)
		        .withMessageBody(messageBody).withMessageGroupId("1").withMessageDeduplicationId("1");
		sqs.sendMessage(send_msg_request);
    }
}
