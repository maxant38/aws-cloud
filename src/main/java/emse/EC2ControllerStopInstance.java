package emse;

import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;

public class EC2ControllerStopInstance {



    public static void main(String[] args) {

        String instanceId = "i-0310f77745933d55d";

        System.out.println("\n Stopping the instance " + instanceId );

        Ec2Client ec2 = Ec2Client.builder()
                .build();

        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);

        System.out.println("\n Done" );


    }
}
