package emse;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SqsException;

import java.util.List;

public class RetrieveMessageSQS {

    public static List<Message> retrieveMessages(SqsClient sqsClient, String queueUrl, String queueName) {


        try {
            // snippet-start:[sqs.java2.sqs_example.retrieve_messages]
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .maxNumberOfMessages(5)
                    .build();

            List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
            System.out.println("\n"+"Message receive from "+ queueName + " :");
            for (Message m : messages) {
                System.out.println("\n" + m.body());
            }
        } catch (SqsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }
}
