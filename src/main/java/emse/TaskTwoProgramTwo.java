package emse;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.List;

import static java.lang.Thread.sleep;

/*Classes used in this program : 
[SQSRetrieveMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSRetrieveMessage.java), 

[SQSDeleteMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSDeleteMessage.java), 

[S3ControllerGetObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerGetObject.java),

[S3ControllerAnalyseData](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerAnalyseData.java), 

[S3ControllerDeleteObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerDeleteObject.java)
*/

public class TaskTwoProgramTwo {
    public static void main(String[] args) {


        try {

            String queueURl= "https://sqs.us-west-2.amazonaws.com/528939267914/queue1672262692"; // queue create by TaskTwoProgramOne - Change the string if needed
            String queueName =  "queue1672262692"; // queue create by TaskTwoProgramOne - Change the string if needed
            String nameFile = "";
            String nameBucket = "";
            String pathForCopyObject = "C:\\Users\\caill\\Desktop\\Cours Mines\\Majeure\\cours 2a info\\Cloud\\retrieveObject.csv";




            SqsClient sqsClient = SqsClient.builder()
                    .build();

            //retrieve the message from the queue in the Amazon SQS
            List<Message> messages = SQSRetrieveMessage.retrieveMessages(sqsClient,queueURl,queueName); // retrieve the messages from the queue in the Amazon SQS
            nameBucket = messages.get(0).body(); // assign bucket name send by message to variable
            nameFile = messages.get(1).body(); // assign file name send by message to variable

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to  retrieve the message

            //delete the message in the Amazon SQS
            SQSDeleteMessage.deleteMessages(sqsClient, queueURl,messages); // Delete the messages

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the messages

            //delete the queue in the Amazon SQS
            SQSDeleteQueue.main(new String[]{queueName});

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the queue

            sqsClient.close();

            S3Client s3 = S3Client.builder()
                    .build();


            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to delete the object

            S3ControllerGetObject.main( new String[]{ nameBucket, nameFile, pathForCopyObject} ) ; // We retrieve the file from the Amazon S3 +  We chose in the TaskTwoProgramOne that the KeyName is the nameFile value

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to download the object

            S3ControllerAnalyseData.main(new String[]{pathForCopyObject}); // We calculate and display the min, max, and sum of the values store in the file

            sleep(4000); // We add some delay in order to do not have any error because of the time it takes to calculate and display the min, max, and sum of the values store in the file

            S3ControllerDeleteObject.deleteBucketObjects(s3, nameBucket, nameFile); // Delete the object

            s3.close();

            System.out.println("\n" + "Task Two Program Two done");


        }

        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

}
