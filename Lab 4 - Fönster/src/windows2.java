import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class windows2 {
    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/Lab 4 - Fönster/src/samples/ships.1.in");
        BufferedReader input = new BufferedReader(in);
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //Variables
        int counter=0, countLocation = 0, sum = 0, locationCounter = 0, currentLocation=0, numOfLocations=0, countIter=0;
        boolean fill = false;
        Set<Integer> set = new HashSet<Integer>();
        //ArrayList<Integer> activeRows = new ArrayList<Integer>();
        //ArrayList<int[]> approvedLocationsArr = new ArrayList<int[]>();

        int x1, y1, x2, y2, x1Location, x2Location, fillCounter = 0;
        int[][] locations, approvedLocations;
        boolean[][] windowMatrix;
        locations = new int[1000][5];
        windowMatrix = new boolean[10000][10001];


        //System.out.println(windowArray.length);
        //Scanner sc = new Scanner(System.in);

        String line;
        while ((line = input.readLine()) != null) {
            if(locationCounter == 0){
                line = line.trim();
                String[] info = line.split(" ");
                numOfLocations = Integer.parseInt(info[0]);
            }
            else{
                if(!line.equals("")) {
                    line = line.trim();
                    String[] info = line.split(" ");

                    x1 = Integer.parseInt(info[0]);
                    y1 = Integer.parseInt(info[1]);
                    x2 = Integer.parseInt(info[2]);
                    y2 = Integer.parseInt(info[3]);
                    //System.out.println(line);
                    for(int k = 0; k < numOfLocations; k++){
                        if(locations[k][0] == 0 && locations[k][0] != 2){
                            locations[k][0] = 1;
                            locations[k][1] = x1;
                            locations[k][2] = y1;
                            locations[k][3] = x2;
                            locations[k][4] = y2;
                            //System.out.println("KATTMAT");
                            break;
                        }
                        else if(locations[k][0] == 2){

                        }
                        else{
                            if(locations[k][1] >= x1 && locations[k][2] >= y1 && locations[k][3] <= x2 && locations[k][4] <= y2){
                                if(locations[k][1] == x1 && locations[k][2] == y1 && locations[k][3] == x2 && locations[k][4] == y2){
                                    //System.out.println("SAME");
                                    //locations[k][0] = 2;
                                    break;
                                }
                                else{
                                    locations[k][0] = 2;
                                }
                            }
                            else if(locations[k][1] <= x1 && locations[k][2] <= y1 && locations[k][3] >= x2 && locations[k][4] >= y2){
                                break;
                            }
                        }

                    }
                }
            }
            locationCounter++;
        }
        //System.out.println(locations[2][0]);




        for(int i = 0; i < numOfLocations; i++){
            if(!(locations[i][0] == 2 || locations[i][0] == 0)){
                x1 = locations[i][1];
                y1 = locations[i][2];
                x2 = locations[i][3];
                y2 = locations[i][4];

                while(x1 < x2){
                    windowMatrix[x1][0] = true;
                    Arrays.fill(windowMatrix[x1], y1+1, y2+1, true);
                    set.add(x1);
                    x1++;
                }
                countIter++;
            }
        }



        /*
        for(int i : set){
            for(boolean number : windowMatrix[i]){
                sum += 1;
            }
            sum += -1;
            //sum = sum + (IntStream.of(windowMatrix[i]).sum() - 1);
        }*/
        //double startTime = System.nanoTime();

        for(int i : set){
            for(int j = 0; j < windowMatrix[i].length; j++){
                if (windowMatrix[i][j]){
                    sum += 1;
                }
            }
            sum += -1;
            //sum = sum + (IntStream.of(windowMatrix[i]).sum() - 1);
        }
        //double endTime   = System.nanoTime();
        //double totalTime = endTime - startTime;

        //System.out.println(totalTime/100000000 + " TIME");
        System.out.println(sum);
        //System.out.println(countIter);

        //System.out.println(fillCounter);
    }
}
