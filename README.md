<!-- ABOUT THE PROJECT -->
# About The Project

## Objectives:
- Develop Java applications to access individual AWS services
- Create users and groups and assign specific permissions
- Install IntelliJ AWS plugin

## What's in the github repository:

### Task 1: Handling VM Instances

1. Write a Java program that creates an EC2 instance.

=> File : [EC2ControllerCreateInstance.java](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/EC2ControllerStartInstance.java)

2. Write another Java program that starts the EC2 instance if the instance is stopped, and stops the EC2 instance if the instance is started.

=> File : [StartStopInstance.java](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/StartStopInstance.java)

### Task 2: Handling Storage and Messages

Create a Java program that:

- create a bucket in the Amazon S3

- upload the values.csv file

- create an queue in the Amazon SQS

- send a message containing the name of the bucket and file to the queue

=> File: [TaskTwoProgramOne.java](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/TaskTwoProgramOne.java)

 Classes used in this program :  [S3COntrollerCreate](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerCreate.java), [S3ControllerPutObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerPutObject.java), [SQSCreateQueue](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSCreateQueue.java), [SQSSendMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSSendMessage.java)



Create another Java program that:

- retrieve the message from the queue in the Amazon SQS

- delete the message and the queue in the Amazon SQS

- retrieve the file from the Amazon S3

- calculate and display the min, max, and sum of the values store in the file

- delete the file and bucket from the Amazon S3

=> File: [TaskTwoProgramTwo.java](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/TaskTwoProgramTwo.java)

Classes used in this program : [SQSRetrieveMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSRetrieveMessage.java), [SQSDeleteMessage](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/SQSDeleteMessage.java), [S3ControllerGetObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerGetObject.java), [S3ControllerAnalyseData](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerAnalyseData.java), [S3ControllerDeleteObject](https://github.com/maxant38/aws-cloud/blob/main/src/main/java/emse/S3ControllerDeleteObject.java)

## Built With:

* [AWS](https://aws.amazon.com/fr/)
* [Java](https://www.java.com/fr/)

## Project participants:

- Caille Maxence - maxence.caille@etu.emse.fr
- Mathieu Delbos - mathieu.delbos@etu.emse.fr








