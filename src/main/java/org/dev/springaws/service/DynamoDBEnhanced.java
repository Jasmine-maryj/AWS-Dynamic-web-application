package org.dev.springaws.service;

import org.dev.springaws.entity.Greeting;
import org.dev.springaws.entity.GreetingItems;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@Component("DynamoDBEnhanced")
public class DynamoDBEnhanced {

    public void injectDynamoItem(Greeting item){
        Region region = Region.US_EAST_1;
        DynamoDbClient dbClient = DynamoDbClient.builder()
                .region(region)
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();

        try{
            DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(dbClient)
                    .build();

            DynamoDbTable<GreetingItems> itemsDynamoDbTable = enhancedClient.table(
                    "Greeting",
                    TableSchema.fromBean(GreetingItems.class));

            GreetingItems greetingItems = new GreetingItems();
            greetingItems.setName(item.getName());
            greetingItems.setMessage(item.getBody());
            greetingItems.setTitle(item.getTitle());
            greetingItems.setId(item.getId());

            PutItemEnhancedRequest<GreetingItems> enhancedRequest = PutItemEnhancedRequest.builder(GreetingItems.class)
                    .item(greetingItems)
                    .build();

            itemsDynamoDbTable.putItem(enhancedRequest);
        }catch (DynamoDbException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
