package com.example.backend.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class DynamoDBConfig {

    @Bean
    public DynamoDBMapper mapper(){
        return new DynamoDBMapper(dynamoDBMapper());
    }

    private AmazonDynamoDB dynamoDBMapper() {
        return AmazonDynamoDBAsyncClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder
                .EndpointConfiguration("dynamodb.us-east-2.amazonaws.com","us-east-2"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIARDTT2TQXQC2BOH7G","sd6tdPyDP6DZTaRwvbl7yzHItyWcDyXoNfDEYgEJ")))
                .build();
    }


}
