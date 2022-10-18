//19105121
/*Write a ConsoleProgram that reads in a number from the user and then displays the
Hailstone sequence for that number (Pick some positive integer and call it n. If n is even,
divide it by two. If n is odd, multiply it by three and add one. Continue this process until n
is equal to one). */
import java.util.*;

public class Ques4Ishita {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number"); // ask user input
        int numInput = sc.nextInt();
        
        while(numInput!=1){ // condition to stop when number id equal to 1

            System.out.println(numInput); // print the list iteratively 
            if(numInput%2 ==0)   numInput /= 2; // even condition
            else{
                numInput *=3; // odd condition
                numInput +=1;
            }
        }
    }

}
