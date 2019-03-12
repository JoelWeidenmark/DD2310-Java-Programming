import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

class Appointment implements Comparable<Appointment>{

    int num, day;
    String month, time, desc;
    String[] months = {"jan", "feb", "mar", "apr", "maj", "jun", "jul", "aug", "sep", "okt", "nov", "dec"};
    int[] values = new int[4];
    String printAble;

    public Appointment(int testNum, String inMonth, String inDay, String inTime, String inDesc) {
        num = testNum;
        month = inMonth;
        day = Integer.parseInt(inDay);
        time = inTime;
        desc = inDesc;

        String[] temp = time.split(":");

        values[0] = Arrays.asList(months).indexOf(month);
        values[1] = day;
        values[2] = Integer.parseInt(temp[0]);
        values[3] = Integer.parseInt(temp[1]);
        printAble = inMonth + " " + inDay + " " + inTime + " " + inDesc;

    }

    public int compareTo(Appointment other) {
        if(this.values[0] != other.values[0]){
            return Integer.compare(this.values[0], other.values[0]);
        }
        else if(this.values[1] != other.values[1]){
            return Integer.compare(this.values[1], other.values[1]);
        }
        else if(this.values[2] != other.values[2]){
            return Integer.compare(this.values[2], other.values[2]);
        }
        else if(this.values[3] != other.values[3]){
            return Integer.compare(this.values[3], other.values[3]);
        }
        else{
            return Integer.compare(this.values[0], other.values[0]);
        }
        //int katt = 2;
        //return katt;
        //return Integer.compare(this.year_discovered, other.year_discovered);
    }

    public int test() {
        return num;
    }
}

public class almanacka {
    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/almanacka/src/samples/calendar.1.in");
        BufferedReader input = new BufferedReader(in);
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Variables
        int numOfAppointments = 0, appointmentCounter = 0;

        Appointment test = new Appointment(1, "jan", "1", "00:01", "test");
        Appointment test2 = new Appointment(1, "feb", "2", "00:02", "test2");

        Appointment[] appList = new Appointment[2];
        Appointment[] appointmentList = new Appointment[0];
        appList[0] = test2;
        appList[1] = test;
        Arrays.sort(appList);


        boolean skip = false;


        //System.out.println(test2.compareTo(test));
        String line;
        //System.out.println(test.test());



        while ((line = input.readLine()) != null) {
            if(!skip){
                line = line.trim();
                numOfAppointments = Integer.parseInt(line);
                appointmentList = new Appointment[numOfAppointments];
            }
            else{
                line = line.replaceAll(" +", " ");
                String[] appointmentLine = line.split(" ");

                String appointmentDesc = "";

                for(int i = 0; i < appointmentLine.length; i++){
                    appointmentLine[i] = appointmentLine[i].trim();
                    if(i > 2){
                        appointmentDesc = appointmentDesc + appointmentLine[i] + " ";
                    }
                }


                appointmentList[appointmentCounter - 1] = new Appointment(1, appointmentLine[0], appointmentLine[1], appointmentLine[2], appointmentDesc.trim());

            }
            skip = true;
            appointmentCounter++;
        }

        Arrays.sort(appointmentList);
        for(Appointment hej : appointmentList){
            System.out.println(hej.printAble);

        }

    }
}
