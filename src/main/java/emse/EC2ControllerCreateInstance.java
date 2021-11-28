package emse;

import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.InstanceType;
import software.amazon.awssdk.services.ec2.model.Region;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.model.RunInstancesResponse;



public class EC2ControllerCreateInstance {



    public static void main(String[] args) {

        String amiId = "ami-0142f6ace1c558c7d"; // we find the Image Id in the first screen after you Launch Instance in the AWS Management Console

        Ec2Client ec2 = Ec2Client.builder()
                .build();

        RunInstancesRequest runRequest = RunInstancesRequest.builder() // Represents a web request for creating EC2 instances
                .imageId(amiId)
                .instanceType(InstanceType.T2_MICRO) // we select the only model that is free
                .maxCount(1)
                .minCount(1)
                .build();

        RunInstancesResponse response = ec2.runInstances(runRequest); //Represents a web response from the AWS EC2 service after instance creation.
    }








}
