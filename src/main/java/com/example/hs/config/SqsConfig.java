package com.example.hs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class SqsConfig {
//	@Value("${aws.region}") // Inject AWS region from application.properties or application.yml
//    private String awsRegion;
	
	@Value("${aws.accessKeyId}")
	private String awsKeyID;
	
	@Value("${aws.secretKey}")
	private String awsSecretKey;

    @Bean
    AmazonSQS amazonSQS() {
    	BasicAWSCredentials credentialsProvider = new BasicAWSCredentials(awsKeyID, awsSecretKey);
        return AmazonSQSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentialsProvider))
                .build();
    }
}
