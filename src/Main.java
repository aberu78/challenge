import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Main {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        /*System.out.println("Enter String (Longest Word challenge)");
        String str = scanner.nextLine();
        System.out.println("Longest word :" + LongestWord(str));
        System.out.println("Enter number (First Factorial challenge)");
        int num  = scanner.nextInt();
        String bL = scanner.nextLine();
        System.out.println("Longest word :" + firstFactorial(num));
        System.out.println("Enter String (First Reverse challenge)");
        String str = scanner.nextLine();
        System.out.println("Longest word :" + firstReverse(str));  */

        System.out.println("Enter String (Letter change challenge)");
        String str = scanner.nextLine();
        System.out.println("Letter before " + str + " letter changed word :" + letterChanges(str));
    }

    public static String letterChanges(String str){
        String changedVar="";
        char aWord[] = str.toCharArray();
        for(int i = 0; i < aWord.length; i++ ){
            if(Character.isLetter(aWord[i])){
                int ascii = (int) aWord[i];

                if(ascii != (int) 'z') {
                    ascii += 1;
                    char testChar = (char) ascii;
                    if(testChar == 'a' || testChar == 'e'||testChar == 'i'||testChar == 'o' ||testChar == 'u' ) {
                        testChar = Character.toUpperCase(testChar);
                    }
                    aWord[i] = testChar;
                }
                else {
                    aWord[i] = (char) 'a';
                }
            }
        }
        changedVar = String.valueOf(aWord);
        return changedVar;
    }


    public static String firstReverse(String str){
        String [] var = str.split(" ");
        String reverse = "";
        for(int i = var.length-1; i >= 0;  i--){
            String rev = var[i];
            for(int j = rev.length()-1; j >= 0 ; j--){
                reverse += rev.charAt(j);
            }
            reverse += " ";
        }
        return reverse;
    }

    public static int firstFactorial(int num){
        int var = 1;
        for(int i = 1; i <= num; i++){
            var *= i;
        }
        return var;

    }
    public static String LongestWord(String str){
        String [] var = str.split(" ");
        String longest = var[0].replaceAll("[^A-Za-z0-9]","");
        for(int i=1 ; i < var.length ; i++)
        {
            String word = var[i].replaceAll("[^A-Za-z0-9]","");
            if(word.length() > longest.length()){
                longest = word;
            }
        }
        return longest;
    }
}
