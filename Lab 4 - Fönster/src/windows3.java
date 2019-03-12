import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class windows3 {
    public static void main(String[] args) throws Exception{

        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Variables




        ArrayList<Long> times = new ArrayList<Long>();

        for(int z = 0; z < 100; z++) {

            int  sum = 0, locationCounter = 0,  numOfLocations=0, countIter=0;
            FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/Lab 4 - Fönster/src/samples/windows.3.in");
            BufferedReader input = new BufferedReader(in);

            boolean fill = false;
            Set<Integer> set = new HashSet<Integer>();


            int x1, y1, x2, y2;
            int[][] windowMatrix, locations;
            locations = new int[1000][5];
            windowMatrix = new int[10000][10001];


            String line;
            while ((line = input.readLine()) != null) {
                if (locationCounter == 0) {
                    line = line.trim();
                    String[] info = line.split(" ");
                    numOfLocations = Integer.parseInt(info[0]);
                } else {
                    if (!line.equals("")) {
                        line = line.trim();
                        String[] info = line.split(" ");

                        x1 = Integer.parseInt(info[0]);
                        y1 = Integer.parseInt(info[1]);
                        x2 = Integer.parseInt(info[2]);
                        y2 = Integer.parseInt(info[3]);
                        for (int k = 0; k < numOfLocations; k++) {
                            if (locations[k][0] == 0 && locations[k][0] != 2) {
                                locations[k][0] = 1;
                                locations[k][1] = x1;
                                locations[k][2] = y1;
                                locations[k][3] = x2;
                                locations[k][4] = y2;
                                break;
                            } else if (locations[k][0] == 2) {

                            } else {
                                if (locations[k][1] >= x1 && locations[k][2] >= y1 && locations[k][3] <= x2 && locations[k][4] <= y2) {
                                    if (locations[k][1] == x1 && locations[k][2] == y1 && locations[k][3] == x2 && locations[k][4] == y2) {
                                        //System.out.println("SAME");
                                        break;
                                    } else {
                                        locations[k][0] = 2;
                                    }
                                } else if (locations[k][1] <= x1 && locations[k][2] <= y1 && locations[k][3] >= x2 && locations[k][4] >= y2) {
                                    break;
                                }
                            }

                        }
                    }
                }
                locationCounter++;
            }
            //System.out.println(locations[4][0]);


            for (int i = 0; i < numOfLocations; i++) {
                if (!(locations[i][0] == 2 || locations[i][0] == 0)) {
                    x1 = locations[i][1];
                    y1 = locations[i][2];
                    x2 = locations[i][3];
                    y2 = locations[i][4];

                    while (x1 < x2) {
                        windowMatrix[x1][0] = 1;
                        Arrays.fill(windowMatrix[x1], y1 + 1, y2 + 1, 1);
                        set.add(x1);
                        x1++;
                    }
                    countIter++;
                }
            }


            long startTime = System.nanoTime();
            for (int i : set) {
                for (int number : windowMatrix[i]) {
                    sum += number;
                }
                sum += -1;
            }

            countIter++;
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            times.add(totalTime);
            //System.out.println(sum);
            //System.out.println(countIter);



        }
        int countTimes = 0;
        long superTime = 0;
        for(long time : times){
            superTime += time;
            countTimes +=1;
        }
        System.out.println( (superTime/countTimes)/10000000 + " TIME");
        System.out.println( (superTime/countTimes)/100000 + " TIME");

    }
}
