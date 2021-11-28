package emse;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

import static java.lang.Thread.sleep;

public class TaskTwoProgramTwo {
    public static void main(String[] args) {


        try {

            String queueURl= "https://sqs.us-west-2.amazonaws.com/528939267914/queue1638102894379"; // queue create by TaskTwoProgramOne - Change the string if needed
            String queueName = "queue1638102894379"; // queue create by TaskTwoProgramOne - Change the string if needed

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            List<Message> messages = SQSRetrieveMessage.retrieveMessages(sqsClient,queueURl,queueName); // retrieve the messages from the queue in the Amazon SQS

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to  retrieve the message

            SQSDeleteMessage.deleteMessages(sqsClient, queueURl,messages);

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to delete the messages

            SQSDeleteQueue.main(new String[]{queueName});

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to delete the queue

            sqsClient.close();



        }

        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
