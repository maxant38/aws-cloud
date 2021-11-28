package emse;


import software.amazon.awssdk.services.sqs.SqsClient;

import static java.lang.Thread.sleep;

public class TaskTwoProgramOne {



    public static void main(String[] args) {

        try {
            S3ControllerCreate.main(new String[]{"bucket3688480748"});

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to create the bucket

            S3ControllerPutObject.main(new String[]{"bucket3688480748", "new_user_credentials.csv", "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud"});

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to add the object

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            String queueName = "queue" + System.currentTimeMillis();

            CreateSQS.createQueue(sqsClient, queueName);

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to create a queue


        }




        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
