import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.Scanner;

public class windows {
    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/Lab 4 - Fönster/src/samples/windows.3.in");
        BufferedReader input = new BufferedReader(in);
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Variables
        int counter=0, countOne = 0;
        int x1, y1, x2, y2, x1Location, x2Location;
        boolean[][] windowMatrix, locations;
        windowMatrix = new boolean[10000][10001];

        //System.out.println(windowArray.length);


        //Scanner sc = new Scanner(System.in);
        //xLed = input.readLine();
        //yLed = sc.nextInt();

        String data;
        while ((data = input.readLine()) != null) {
            if(counter == 0){
            }
            else{
                //System.out.println(data);
                if(!data.equals("")) {
                    data = data.trim();
                    //String[] info = data.replaceAll("\\s+"," ").split(" ");
                    //System.out.println(data);
                    String[] info = data.split(" ");
                    //System.out.println(data.replaceAll("\\s+"," "));
                    x1 = Integer.parseInt(info[0]);
                    y1 = Integer.parseInt(info[1]);
                    x2 = Integer.parseInt(info[2]);
                    y2 = Integer.parseInt(info[3]);

                    while (x1 < x2) {
                        //windowMatrix[x1][] = new int[10000];
                        windowMatrix[x1][0] = true;
                        Arrays.fill(windowMatrix[x1], y1+1, y2+1, true);
                        x1++;
                    }
                }
                //

                /*
                for(String bajs : info){
                    System.out.println(bajs);
                }*/
            }
            counter++;
        }
        //System.out.println(windowMatrix[0][2])

        for(int i = 0; i < 10000; i++){
            if(windowMatrix[i][0]){
                for(int j = 1; j < 10001; j++){
                    if(windowMatrix[i][j]){
                        countOne++;
                    }
                }
            }
        }
        System.out.println(countOne);
    }
}
