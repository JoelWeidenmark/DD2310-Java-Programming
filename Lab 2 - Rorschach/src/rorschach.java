import java.io.BufferedReader;
import java.math.*;
import java.io.InputStreamReader;
import java.io.*;
import java.lang.String;

public class rorschach {
    public static void main(String[] args) throws Exception {
        //Read input
        //FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/Lab 2 - Rorschach/src/samples/Rorschach.1.in");
        //BufferedReader input = new BufferedReader(in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int counter = 0, rows, columns = 0, index = 0, mid = 0, mid2 = 0;
        double midmid;
        boolean correctLine = true;

        String data;
        while ((data = input.readLine()) != null) {

            if(counter == 0){

                String[] info = data.split("\\s");
                rows = Integer.parseInt(info[0]);
                columns = Integer.parseInt(info[1]);

                mid = columns/2;
                if(columns%2 == 1){
                    mid2 = mid +1;
                }
                else{
                    mid2 = mid;
                }

            }
            else{

                String[] splitLine = {data.substring(0, mid), data.substring(mid2)};
                StringBuilder revString = new StringBuilder(splitLine[1]);
                revString.reverse();
                if(splitLine[0].equals(revString.toString())){
                }
                else{
                    correctLine = false;
                }

            }
            counter++;
        }
        if(correctLine){
            System.out.println("Ja");
        }
        else{
            System.out.println("Nej");
        }

        /*
        String data;
        while ((data = input.readLine()) != null) {
            if(counter == 0){
                //String[] info = data.split("\\s");
                //rows = Integer.parseInt(info[0]);
                //columns = Integer.parseInt(info[1]);
            }
            else{
                String[] readLineArray = data.split("");
                int arrayLength = readLineArray.length;

                for(String symbol : readLineArray){
                    if(symbol.equals("X")) {
                        if (index > arrayLength / 2) {
                            //System.out.println("Funkar");
                            //correctLine = true;
                        }
                        else {

                            if (readLineArray[arrayLength - index - 1].equals("X")) {

                            }
                            else {
                                //System.out.println("FEL");
                                correctLine = false;
                                break;
                            }
                        }
                    }
                    //Allows empty rows
                    index++;
                }
                //correctLine = false;
                index = 0;
            }
            counter++;
        }
        if(correctLine){
            System.out.println("Ja");
        }
        else{
            System.out.println("Nej");
        }*/
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //String data = input.readLine();
        //System.out.println(data);

        /*if(symbol == "X"){
            if(index > arrayLength/2){
                if(readLineArray[arrayLength - index - 1] == "X"){

                }
                else{
                    System.out.println("Nej");
                }
            }
            else{

            }

        }*/

    }
}
