
import java.util.*;
 
public class Ques5Ishita {

    static int dp[][]; // create List which will store all sets of operations
    static ArrayList<ArrayList<String> > array_list = new ArrayList<ArrayList<String> >();
 
    static void print(String s1, String s2, ArrayList<String> change_all)
    {
        int i = s1.length();
        int j = s2.length();
        boolean ff=true;
        while (ff) {
 
            if (i == 0 || j == 0) {
                array_list.add(change_all);
                break;
            }
 
            if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                i--;
                j--;
            }
 
            else {
                boolean if_first = false, if_second = false;
 
                if (dp[i][j] == dp[i - 1][j - 1] + 1) {
 
                    change_all.add("Change " + s1.charAt(i - 1)
                                + " to " + s2.charAt(j - 1));
                    i--;
                    j--;
 
                    if_first = true;
                }
 
                if (dp[i][j] == dp[i - 1][j] + 1) {
                    if (if_first == false) {
                        change_all.add("Delete " + s1.charAt(i - 1));
                        i--;
                    }
                    else {
                       
                        ArrayList<String> change_all2 = new ArrayList<String>();
                        change_all2.addAll(change_all);
 
                        change_all2.remove(change_all.size() - 1);
 
                        change_all2.add("Delete " + s1.charAt(i));
 
                        print(s1.substring(0, i),
                                        s2.substring(0, j + 1), change_all2);
                    }
 
                    if_second = true;
                }
 
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    if (if_first == false && if_second == false) {
                        change_all.add("Add " + s2.charAt(j - 1));
                        j--;
                    }
                    else {
 
                        ArrayList<String> change_all2 = new ArrayList<String>();
                        change_all2.addAll(change_all);
                        change_all2.remove(change_all.size() - 1);
                        change_all2.add("Add " + s2.charAt(j));
 
                        print(s1.substring(0, i + 1),  s2.substring(0, j), change_all2);
                                       
                    }
                }
            }
        }
    }
 
   
    static void edit_dp(String s1, String s2)
    {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] DP = new int[l1 + 1][l2 + 1];
 
        for (int i = 0; i <= l1; i++)
            DP[i][0] = i;
        for (int j = 0; j <= l2; j++)
            DP[0][j] = j;
 
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
 

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    DP[i][j] = DP[i - 1][j - 1];
                else {
 
                    DP[i][j] = min(DP[i - 1][j - 1],
                                   DP[i - 1][j], DP[i][j - 1])
                               + 1;
                }
            }
        }
 
        dp = DP;
    }
 
    static int min(int a, int b, int c)
    {
        int z = Math.min(a, b);
        return Math.min(z, c);
    }
    static void displayAll(String s1, String s2,
                          ArrayList<String> change_all)
    {
 
        // Function to print all the ways
        print(s1, s2, new ArrayList<String>());
 
        int i = 1;
 
        // print all the possible ways
        for (ArrayList<String> ar : array_list) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }
 
    // Driver Code
    public static void main(String[] args) throws Exception
    {
        String s1 = "abcdef";
        String s2 = "axcdfdh";
 
        // calculate the DP matrix
       
        edit_dp(s1, s2);
 
        // Function to print all ways
        displayAll(s1, s2, new ArrayList<String>());
    }
}