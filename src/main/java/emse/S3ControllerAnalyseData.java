package emse;
import java.io.*;

public class S3ControllerAnalyseData {

    public static final String delimiter = ",";

        public static void read(String csvFile) {

            System.out.format("Starting calculate and display the min, max, and sum of the values store in the file");

            int max = 0;
            int min = 1000000000;
            int sum = 0;

            try {
                File file = new File(csvFile);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                String[] values;
                while((line = br.readLine()) != null) {
                    values= line.split(delimiter);
                    for(String value : values) {
                        int valueInt =Integer.parseInt(value);
                        if (valueInt > max) {
                        max = valueInt;
                        }
                        if(valueInt<min){
                            min = valueInt;
                        }
                        sum += valueInt;
                    }
                }
                System.out.println("\n" + "max value = " + max);
                System.out.println("min value = " + min);
                System.out.println("sum of values = " + sum);
                System.out.format("\n" + "Done");
                br.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
        public static void main(String[] args) {
            // csv file to read
            S3ControllerAnalyseData.read(args[0]);
        }
    }
