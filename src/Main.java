import javax.swing.*;
import java.util.*;

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
        System.out.println("Longest word :" + firstReverse(str));

        System.out.println("Enter String (Letter change challenge)");
        String str = scanner.nextLine();
        System.out.println("Letter before " + str + " letter changed word :" + letterChanges(str));

        System.out.println("Enter number (Simple Adding challenge)");
        int num  = scanner.nextInt();
        String bL = scanner.nextLine();
        System.out.println("Simple Adding  :" + simpleAdding(num));

        System.out.println("Enter String (Letter capitalization challenge)");
        String str = scanner.nextLine();
        System.out.println("Letter capitalization :" + letterCapitalize(str));

        System.out.println("Enter String (Simple Symbols challenge)");
        String str = scanner.nextLine();
        System.out.println("Simple Symbols :" + simpleSymbols(str));

        System.out.println("Enter num1 (Check Nums challenge)");
        int num1 =  scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter num2");
        int num2 =  scanner.nextInt();
        scanner.nextLine();
        System.out.println("Simple Symbols :" + checkNum(num1, num2));

        System.out.println("Enter number (Time Convert challenge)");
        int num  = scanner.nextInt();
        scanner.nextLine();
        System.out.println(num + " mins are " + timeConvert(num));

        System.out.println("Enter String (Alphabet Soup challenge)");
        String str = scanner.nextLine();
        System.out.println("Alphabet Soup  :" + alphabetSoup(str)); */


        System.out.println("Enter number (Kaprekars Constant challenge)");
        int num  = scanner.nextInt();
        scanner.nextLine();
        System.out.println(num + " count is  " + kapreKarsConstant(num));

    }

    public static int kapreKarsConstant(int num){
        int count =0;

        boolean isValid = false;
        while(!isValid){

            char temp[] = String.valueOf(num).toCharArray();
            Arrays.sort(temp);
            int num1 = Integer.parseInt(String.valueOf(temp));

            StringBuilder input1 = new StringBuilder();
            // append a string into StringBuilder input1
            input1.append(String.valueOf(temp));
            // reverse StringBuilder input1
            input1 = input1.reverse();

            int num2 = Integer.parseInt(String.valueOf(input1));
            System.out.println(num2 + " - " + num1+ " = " + (num2-num1));

            if(num2 - num1 == 6174){
                isValid = true;
            }
            else{
                num = num2-num1;
                if(num < 1000)
                    num = num*10;
            }
            count++;
     }
        return count;
    }

    public static String alphabetSoup(String str){
        char aWord[]  = str.toCharArray();
        Arrays.sort(aWord);
        return String.valueOf(aWord);
    }

    public static String timeConvert(int num){
        int hour = num / 60;
        int min = num % 60;
        return hour + ":" + min;

    }

    public static boolean checkNum(int num1, int num2){
        return num1 < num2;
    }


    public static boolean simpleSymbols(String str){
        char[] aWord = str.toCharArray();
        if(Character.isLetter(aWord[0]) || Character.isLetter(aWord[aWord.length-1]))
            return false;
        for (int i = 0; i < aWord.length-1; i++) {
            if(Character.isLetter(aWord[i])){
                if(aWord[i-1] != '+' || aWord[i+1] != '+'){
                    return false;
                }
            }
        }
        return true;
    }

    public static String letterCapitalize(String str){
        String word = "";
        String [] var = str.split(" ");
        for(int i = 0; i < var.length; i++){
            String str1 = var[i].substring(0,1).toUpperCase() + var[i].substring(1);
            word += str1 + " ";
        }


        return word;
    }

    public static int simpleAdding(int num){
       if(num  == 1) {
           return 1;
       }
       else{
           int sum = num + simpleAdding(num-1);
           return sum;
       }
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
