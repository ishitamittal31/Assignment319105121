//Write a program to sort strings (using library function).
//19105121
import java.util.*;
public class Ques3Ishita {
    public static void main(String args[]){
        String s = "thisisthestringtobesorted"; //string to be sorted
        char []convert = s.toCharArray();//convert to char array
        Arrays.sort(convert);//sort the array
        System.out.println(String.valueOf(convert));//print string


    }
}
