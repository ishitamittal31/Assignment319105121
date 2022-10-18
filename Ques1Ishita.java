 //19105121
 //Write a java program to compare two strings lexicographically (without using library function).
 //the program will return 0 if string 1==string2
 //if string 1>string 2 then 1
 //else -1
 import java.util.*;
public class Ques1Ishita {
    
    public static int compare(String string1, String string2){

        for(int i = 0; i < string1.length() && i < string2.length(); i++){ //iterate in the strings

            if((int)string1.charAt(i) == (int)string2.charAt(i)){
                continue;//if the character is same continue
            }
            else{
                if((int)string1.charAt(i) > (int)string2.charAt(i)) return 1;//return 1 if greater
                 else return -1;//else return -1
            }
        }
        if(string1.length() == string2.length()){
            return 0;//if the length is same
        }if(string1.length() > string2.length()){
            return 1;//if the first string has greater length
        }if(string1.length() < string2.length()){
            return -1;//if the second string is greater length
        }
        return 0;
    }

    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two strings"); //take input from users
        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        
     
        System.out.println(compare(string1, string2)); // call solution function

}
}