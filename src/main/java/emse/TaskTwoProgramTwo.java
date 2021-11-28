package emse;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

import static java.lang.Thread.sleep;

public class TaskTwoProgramTwo {
    public static void main(String[] args) {


        try {

            String queueURl= "https://sqs.us-west-2.amazonaws.com/528939267914/queue1638102894379"; // queue create by TaskTwoProgramOne - Change the string if needed
            String queueName = "queue1638102894379"; // queue create by TaskTwoProgramOne - Change the string if needed
            String nameFile = "values.csv";
            String nameBucket = "bucket3688480748";
            String pathForCopyObject = "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud\\retrieveObject.csv";


            /*

            SqsClient sqsClient = SqsClient.builder()
                    .build();

            List<Message> messages = SQSRetrieveMessage.retrieveMessages(sqsClient,queueURl,queueName); // retrieve the messages from the queue in the Amazon SQS

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to  retrieve the message

            SQSDeleteMessage.deleteMessages(sqsClient, queueURl,messages); // Delete the messages

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the messages

            SQSDeleteQueue.main(new String[]{queueName}); // Delete the queue

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the queue

            sqsClient.close(); */

            S3Client s3 = S3Client.builder()
                    .build();


            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the object

            S3ControllerGetObject.main( new String[]{ nameBucket, nameFile, pathForCopyObject} ) ; // We retrieve the file from the Amazon S3 +  We chose in the TaskTwoProgramOne that the KeyName is the nameFile value

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to download the object

            S3ControllerAnalyseData.main(new String[]{pathForCopyObject}); // We calculate and display the min, max, and sum of the values store in the file

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to calculate and display the min, max, and sum of the values store in the file

            //S3ControllerDeleteObject.deleteBucketObjects(s3, nameBucket, nameFile); // Delete the object

            s3.close();

            System.out.println("\n" + "Task Two Program Two done");


        }

        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
