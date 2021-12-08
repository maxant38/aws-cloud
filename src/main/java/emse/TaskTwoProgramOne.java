package emse;


import software.amazon.awssdk.services.sqs.SqsClient;

import static java.lang.Thread.sleep;

public class TaskTwoProgramOne {


    public static void main(String[] args) {


        try {

            String nameBucket = "bucket3611111111";
            String nameFile = "values.csv";
            String pathFile = "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud";

            S3ControllerCreate.main(new String[]{nameBucket});

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to create the bucket

            S3ControllerPutObject.main(new String[]{nameBucket, nameFile,pathFile });

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to add the object

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            String queueName = "queue" + System.currentTimeMillis();

            SQSCreateQueue.createQueue(sqsClient, queueName);

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to create a queue

            SQSSendMessage.sendMessages(sqsClient,queueName,nameBucket,nameFile);

            sqsClient.close();

            System.out.println("\n"  + "Task Two Program Two done");

        }

        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
