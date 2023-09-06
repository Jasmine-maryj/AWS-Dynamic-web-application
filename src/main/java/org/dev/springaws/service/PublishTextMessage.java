package org.dev.springaws.service;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SnsException;

@Component("PublishTextMessage")
public class PublishTextMessage {

    public void sendMessage(String id){
        Region region = Region.US_EAST_1;
        SnsClient snsClient = SnsClient.builder()
                .region(region)
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();

        String message = "A new item with ID value "+ id +" was added to the DynamoDB table";
        String phoneNumber = "";

        try{
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .phoneNumber(phoneNumber)
                    .build();

            snsClient.publish(request);
        }catch (SnsException snsException){
            System.err.println(snsException.getMessage());
            System.exit(1);
        }
    }

}
