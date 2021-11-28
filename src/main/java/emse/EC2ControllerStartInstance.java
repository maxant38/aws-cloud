package emse;

import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;

public class EC2ControllerStartInstance {

    public static void main(String[] args) {

        String instanceId = "i-0310f77745933d55d"; // put the id of the instance you want to start

        System.out.println("\n Starting the instance " + instanceId);

        Ec2Client ec2 = Ec2Client.builder()
                .build();

        StartInstancesRequest request = StartInstancesRequest.builder() // Represents a web request for starting EC2 instances.
                .instanceIds(instanceId)
                .build();

        ec2.startInstances(request);

        System.out.println("\nDone ");

    }
}
