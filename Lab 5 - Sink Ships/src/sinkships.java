import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class sinkships {
    public static void main(String[] args) throws Exception{
        //FileReader in = new FileReader("/Users/joelweidenmark/Dropbox/KTH/java/Lab 5 - Sink Ships/src/samples/ships.2.in");
        //BufferedReader input = new BufferedReader(in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int counter = 0, rows = 0, columns=0, rowCounter = 0, countShip = 0;
        boolean[][] gameField;
        boolean skip = false;
        gameField = new boolean[0][0];


        String line;
        while ((line = input.readLine()) != null) {
            if(!skip){
                //line = line.trim();
                String[] info = line.split(" ");
                rows = Integer.parseInt(info[0]);
                columns = Integer.parseInt(info[1]);
                gameField = new boolean[columns][rows];
                //System.out.println(rows + " " + columns);
                //System.out.println(xSize + " " + ySize);
                skip = true;
            }
            else{
                line = line.trim();
                String[] rowArray = line.split("");
                for(int i = 0 ; i < columns; i++){
                    if(rowArray[i].equals("O")){
                        gameField[i][rowCounter] = true;
                    }
                    else{
                        gameField[i][rowCounter] = false;
                    }
                }
                rowCounter++;
                //System.out.println(line);
            }
        }
        //System.out.println(gameField.length);

        for(int j = 0; j < rows; j++){
            for(int k = 0; k < columns; k++){
                //System.out.println(k + "  K");

                while(gameField[k][j]){
                    counter++;
                    if(!(k == columns-1) ){
                        k++;
                    }
                    else{
                        break;
                    }
                }
                if(counter > 1){
                    countShip++;
                }
                counter = 0;

            }
        }
        //System.out.println(countShip);

        for(int j = 0; j < columns; j++){
            for(int k = 0; k < rows; k++){
                //System.out.println(k + "  K");

                while(gameField[j][k]){
                    counter++;
                    if(!(k == rows-1) ){
                        k++;
                    }
                    else{
                        break;
                    }
                }
                if(counter > 1){
                    countShip++;
                }
                counter = 0;

            }
        }
        System.out.println(countShip);
    }
}
