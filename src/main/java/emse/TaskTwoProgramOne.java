package emse;


import software.amazon.awssdk.services.sqs.SqsClient;

import static java.lang.Thread.sleep;

/*
Classes used in this program :  
[S3COntrollerCreate](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerCreate.java), 

[S3ControllerPutObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerPutObject.java), 

[SQSCreateQueue](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSCreateQueue.java), 

[SQSSendMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSSendMessage.java)
*/

public class TaskTwoProgramOne {


    public static void main(String[] args) {


        try {

            String nameBucket = "bucket3611111111";
            String nameFile = "values.csv";
            String pathFile = "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud\\values.csv";

            // create a bucket in the Amazon S3
            S3ControllerCreate.main(new String[]{nameBucket});

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to create the bucket

            //upload the values.csv file
            S3ControllerPutObject.main(new String[]{nameBucket, nameFile,pathFile });

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to add the object

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            //create an queue in the Amazon SQS
            String queueName = "queue1672262692";

            SQSCreateQueue.createQueue(sqsClient, queueName);

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to create a queue

            //send a message containing the name of the bucket and file to the queue
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
