package emse;

import software.amazon.awssdk.services.sqs.SqsClient;

import static java.lang.Thread.sleep;

public class TaskTwoProgramTwo {
    public static void main(String[] args) {


        try {

            String queueURl= "https://sqs.us-west-2.amazonaws.com/528939267914/queue1638102894379"; // queue create by TaskTwoProgramOne
            String queueName = "queue1638102894379"; // queue create by TaskTwoProgramOne



            SqsClient sqsClient = SqsClient.builder()
                    .build();
            RetrieveMessageSQS.retrieveMessages(sqsClient,queueURl,queueName);

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to add the object

            sqsClient.close();

        }

        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
