package emse;


import software.amazon.awssdk.services.sqs.SqsClient;

import static java.lang.Thread.sleep;

public class TaskTwoProgramOne {



    public static void main(String[] args) {

        try {

            String nameBucket = "bucket3688480748";
            String nameFile = "\"new_user_credentials.csv\"";
            String pathFile = "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud";
/*
            S3ControllerCreate.main(new String[]{nameBucket});

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to create the bucket

            S3ControllerPutObject.main(new String[]{nameBucket, nameFile,pathFile });

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to add the object */

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            String queueName = "queue" + System.currentTimeMillis();

            CreateSQS.createQueue(sqsClient, queueName);

            sleep(5000); // We add some delay in order to do not have any error because of the time it takes to create a queue */

            SendMessageSQS.sendMessages(sqsClient,queueName,nameBucket,nameFile);

        }



        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
