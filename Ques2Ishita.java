//19105121
// Write a program to implement counting sort (with input in the range 0 to 20 and input
// can be repeated multiple times)
import java.util.*;
class Ques2Ishita {
    void sort(char arr[])
    {

        int size = arr.length;
        char solution_char[] = new char[size];
        int array_count[] = new int[256];
        for (int i = 0; i < 256; ++i){
            array_count[i] = 0;// initialize with 0
        }
        for (int i = 0; i < size; ++i){
            array_count[arr[i]]++;// count thhe occurence of each letter
        }
        for (int i = 1; i <= 255; ++i){
            array_count[i] += array_count[i - 1];// add the previous in next one
        }
        for (int i = size - 1; i >= 0; i--) {
            solution_char[array_count[arr[i]] - 1] = arr[i];
            array_count[arr[i]]--;
        }
        for (int i = 0; i < size; ++i){
            arr[i] = solution_char[i];
        }

    }
  

    public static void main(String args[])
    {
        Ques2Ishita cs = new Ques2Ishita();
        char arr[] = { 'i', 's', 'h', 'i', 't', 'a', 'm', 'i', 't', 't', 'a', 'l' };
        //sort the array
        cs.sort(arr);
        //print the sorted array
        for (int i = 0; i < arr.length; i++){

            System.out.print(arr[i]);
        
        }
    }
}