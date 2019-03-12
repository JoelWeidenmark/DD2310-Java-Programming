import java.util.Scanner;
import java.util.Arrays;

public class kaprekar {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);

        int newNum = 0, counter = 0;
        String num = input.nextLine();
        String[] strArray;


        while(!(num.equals("6174"))){
            StringBuilder strBuilder = new StringBuilder();

            strArray = num.split("");
            Arrays.sort(strArray);

            for (String number : strArray) {
                strBuilder.append(number);
            }
            strBuilder.reverse();
            //System.out.println(strBuilder);
            int newIntRev = Integer.parseInt(strBuilder.toString());
            strBuilder.reverse();
            int newInt = Integer.parseInt(strBuilder.toString());
            //System.out.println(newInt + " " + newIntRev);

            newNum = newIntRev - newInt;

            num = Integer.toString(newNum);
            while(num.length()<4){
                num = num + "0";
            }
            counter++;
        }
        System.out.println(counter);


    }
}
