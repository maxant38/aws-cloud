
package emse;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

/*
The purpose of this class is to describe an instance state, and turn it on/off accordingly
*/
public class StartStopInstance {


    public static void main(String[] args) {
        //Put your instance id here
        String instanceId="i-088d3185e8eb74875";

        Ec2Client ec2 = Ec2Client.builder()
                .build();

        String state=describeEC2Instance( ec2, instanceId);

        if(state.equals("running"))stopInstance( ec2,  instanceId);
        else startInstance(ec2, instanceId);
        ec2.close();
    }

    //returns an instance state (String, "running", or "stop")
    public static String describeEC2Instance( Ec2Client ec2, String instanceId){

        boolean done = false;
        String nextToken = null;

        try {

            do {
                DescribeInstancesRequest request = DescribeInstancesRequest.builder().maxResults(6).nextToken(nextToken).build();
                DescribeInstancesResponse response = ec2.describeInstances(request);

                for (Reservation reservation : response.reservations()) {
                    for (Instance instance : reservation.instances()) {
                        if (instance.instanceId().equals( instanceId)) {
                            System.out.println("Instance state name is "+  instance.state().nameAsString());
                            System.out.println("Changing Instance state...");
                            return instance.state().nameAsString();
                        }
                    }
                }
                nextToken = response.nextToken();
            } while (nextToken != null);

        } catch (Ec2Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }

    public static void startInstance(Ec2Client ec2, String instanceId) {

        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.startInstances(request);
        System.out.printf("Successfully started instance %s", instanceId);
    }

    public static void stopInstance(Ec2Client ec2, String instanceId) {

        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);
        System.out.printf("Successfully stopped instance %s", instanceId);
    }

}
