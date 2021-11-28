package emse;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SqsException;

public class SendMessageSQS {

    public static void sendMessages(SqsClient sqsClient, String queueUrl, String nameBucket, String nameFile) {

        System.out.println("\nSend multiple messages about the name of the bucket and file ");

        try {

            SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder()
                    .queueUrl(queueUrl)
                    .entries(SendMessageBatchRequestEntry.builder().id("id1").messageBody(nameBucket).build(),
                            SendMessageBatchRequestEntry.builder().id("id2").messageBody(nameFile).delaySeconds(10).build())
                    .build();
            sqsClient.sendMessageBatch(sendMessageBatchRequest);


        } catch (SqsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

}