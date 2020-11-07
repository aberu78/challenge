import java.util.Arrays;
import java.util.Scanner;

/**
 * This Main class is for New Hire Coding Challenge
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in); // standard input


    public static void main(String[] args) {

        boolean quit = false;
        int num = 0;
        String str = "";
        String bl = "";


        while(!quit) {

            instruction();
            int inputNum = scanner.nextInt();
            scanner.nextLine();

            switch(inputNum){

                case 1:
                    System.out.println("Enter String (Longest Word challenge)");
                    str = scanner.nextLine();
                    System.out.println("Longest word :" + longestWord(str) + "\n");
                    break;

                case 2:
                    System.out.println("Enter number (First Factorial challenge)");
                    num = scanner.nextInt();
                    String bL = scanner.nextLine();
                    System.out.println("First Factorial :" + firstFactorial(num) + "\n");
                    break;

                case 3:
                    System.out.println("Enter String (First Reverse challenge)");
                    str = scanner.nextLine();
                    System.out.println("Longest word :" + firstReverse(str) + "\n");
                    break;

                case 4:
                    System.out.println("Enter String (Letter change challenge)");
                    str = scanner.nextLine();
                    System.out.println("Letter before " + str + " letter changed word :" + letterChanges(str) + "\n");
                    break;

                case 5:
                    System.out.println("Enter number (Simple Adding challenge)");
                    num = scanner.nextInt();
                    bL = scanner.nextLine();
                    System.out.println("Simple Adding  :" + simpleAdding(num) + "\n");
                    break;

                case 6:
                    System.out.println("Enter String (Letter capitalization challenge)");
                    str = scanner.nextLine();
                    System.out.println("Letter capitalization :" + letterCapitalize(str) + "\n");
                    break;

                case 7:
                    System.out.println("Enter String (Simple Symbols challenge)");
                    str = scanner.nextLine();
                    System.out.println("Simple Symbols :" + simpleSymbols(str) + "\n");
                    break;

                case 8:
                    System.out.println("Enter num1 (Check Nums challenge)");
                    int num1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter num2");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Simple Symbols :" + checkNum(num1, num2) + "\n");
                    break;

                case 9:
                    System.out.println("Enter number (Time Convert challenge)");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(num + " mins are " + timeConvert(num) + "\n");
                    break;

                case 10:
                    System.out.println("Enter String (Alphabet Soup challenge)");
                    str = scanner.nextLine();
                    System.out.println("Alphabet Soup  :" + alphabetSoup(str) + "\n");
                    break;

                case 11:
                    System.out.println("Enter number (Kaprekars Constant challenge)");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(num + " count is  " + kapreKarsConstant(num) + "\n");
                    break;

                case 12:
                    System.out.println("Enter String (Chessboard Traveling challenge)");
                    str = scanner.nextLine();
                    System.out.println("Chessboard Traveling  :" + chessBoardTraveling(str) + "\n");
                    break;

                case 13:
                    System.out.println("Enter String (Maximal Square challenge)");
                    str = scanner.nextLine();
                    str = str.replaceAll("[\s\"]", "");
                    System.out.println(str);
                    String[] strArr = str.split(",");
                    int matrix[][] = matrix(strArr);
                    System.out.println("Maximal Square  :" + maximalSquare(matrix) + "\n");
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid number entered, please try again");
                    break;
            }
        }
        scanner.close();
    }

    private static int[][]  matrix (String[] str){

        int[][] newArr = new int[str.length][str[0].length()];
        for(int i = 0; i < str.length; i++){
            for(int j= 0; j < newArr[0].length;j++){
                newArr[i][j] = Integer.parseInt(str[i].substring(j,j+1));
                //System.out.println("["+ i +"]"+ " " + "["+j + "]"+" " + newArr[i][j]);
            }
        }
        return newArr;
    }

    public static int maximalSquare(int[][] strArray){
        int count = 0;
        int xLength = strArray.length; //R
        int yLength = strArray[0].length; //C
        int[][] newArr = new int[xLength][yLength];

        for(int i =0;i < xLength; i++ ) {
            newArr[i][0] = strArray[i][0];
        }
        for(int j = 0; j <yLength; j++){
            newArr[0][j] = strArray[0][j];
        }

        for(int i = 1; i < xLength; i++){
            for(int j = 1; j < yLength; j++){
                if(strArray[i][j] == 1){
                    newArr[i][j] = Math.min(newArr[i][j-1], Math.min(newArr[i-1][j], newArr[i-1][j-1])) + 1;
                }
                else
                    newArr[i][j] = 0;
            }
        }

        int maxNewArr = newArr[0][0];
        int maxX= 0;
        int maxY=0;

        for(int i = 0; i < xLength; i++){
            for(int j= 0; j < yLength; j++){
                if(maxNewArr < newArr[i][j]){
                    maxNewArr = newArr[i][j];
                    maxX= i;
                    maxY = j;
                    count ++;

                  //  System.out.println(i);
                   // System.out.println(j);

                }
            }
        }
        for(int i = 0; i < newArr.length; i ++){
            for(int j = 0; j < newArr[0].length; j ++)
                System.out.println("["+ i +"]"+ " " + "["+j + "]"+" " + newArr[i][j]);

        }


        return count*count;
    }


    public static int chessBoardTraveling(String str) {

        int x1 = Integer.parseInt(str.substring(1, 1 + 1));
        int x2 = Integer.parseInt(str.substring(5, 5 + 1));
        int y1 = Integer.parseInt(str.substring(2, 2 + 1));
        int y2 = Integer.parseInt(str.substring(6, 6 + 1));

        int m = Math.abs(x2 - x1);
        int n = Math.abs(y2 - y1);
        int res = 1;

        for (int i = 0; i < n; ++i) {
            res *= ((m + n) - i);
            res /= (i + 1);
        }

        return res;
    }

    public static int kapreKarsConstant(int num) {
        int count = 0;

        boolean isValid = false;
        while (!isValid) {

            char temp[] = String.valueOf(num).toCharArray();
            Arrays.sort(temp);
            int num1 = Integer.parseInt(String.valueOf(temp));

            StringBuilder input1 = new StringBuilder();

            input1.append(String.valueOf(temp));
            input1 = input1.reverse();

            int num2 = Integer.parseInt(String.valueOf(input1));
            System.out.println(num2 + " - " + num1 + " = " + (num2 - num1));

            if (num2 - num1 == 6174) {
                isValid = true;
            } else {
                num = num2 - num1;
                if (num < 1000) {
                    num = num * 10;
                }
            }
            count++;
        }
        return count;
    }

    /***
     * This function will take string and return the string with letters in alphabetical order
     * @param str The string to change
     * @return aWord The alphabetical order of the str
     */
    public static String alphabetSoup(String str) {
        char aWord[] = str.toCharArray();
        Arrays.sort(aWord);
        return String.valueOf(aWord);
    }

    /***
     * This function will take integer and return hours and minutes separated by colon
     * @param num The number to convert
     * @return hours and mins separated by colon
     */
    public static String timeConvert(int num) {
        int hour = num / 60;
        int min = num % 60;
        return hour + ":" + min;
    }

    public static boolean checkNum(int num1, int num2) {
        return num1 < num2;
    }

    /***
     * This function will take string parameter and determine if it is following sequences
     * by returning true or false.
     * @param str The String to check
     * @return true if each letter is surrounded by a +symbol.
     */
    public static boolean simpleSymbols(String str) {
        char[] aWord = str.toCharArray();
        if (Character.isLetter(aWord[0]) || Character.isLetter(aWord[aWord.length - 1])){
            return false;
        }

        for (int i = 0; i < aWord.length - 1; i++) {
            if (Character.isLetter(aWord[i])) {
                if (aWord[i - 1] != '+' || aWord[i + 1] != '+') {
                    return false;
                }
            }
        }
        return true;
    }

    /***
     * This function will take a string and capitalize the first letter of each word.
     * Words should be separated by only one space.
     * @param str The string to change
     * @return word The new string with each word starting with a capital letter
     */
    public static String letterCapitalize(String str) {
        StringBuilder word = new StringBuilder();
        String[] var = str.split(" ");

        for(String s : var)
        {
            word.append(s.toUpperCase().charAt(0))
                .append(s.substring(1))
                .append(" ");
        }

        return word.toString().trim();
    }

    /***
     * This function will add up all the number from 1 to num parameter.
     * @param num The number to add with
     * @return sum The result of add 1 to num together
     */
    public static int simpleAdding(int num) {
        if (num == 1) {
            return 1;
        } else {
            int sum = num + simpleAdding(num - 1);
            return sum;
        }
    }

    /***
     * This function will take a string and modify it using following algorithm below and return the new string
     * 1: replace every letter in the string to next alphabet.(a->b, b->c, z->a)
     * 2: capitalize every vowel in the new string(a,e,i,o,u)
     * @param str
     * @return changeVar The replaced to next letters with all vowel capitalized.
     */
    public static String letterChanges(String str) {
        String changedVar = "";
        char aWord[] = str.toCharArray();
        for (int i = 0; i < aWord.length; i++) {
            if (Character.isLetter(aWord[i])) {
                int ascii = (int) aWord[i];

                if (ascii != (int) 'z' && ascii != 'Z') {
                    ascii += 1;
                    char testChar = (char) ascii;
                    if (testChar == 'e' || testChar == 'i' || testChar == 'o' || testChar == 'u') {
                        testChar = Character.toUpperCase(testChar);
                    }
                    aWord[i] = testChar;
                } else {
                    aWord[i] = (char) 'A';
                }
            }
        }
        changedVar = String.valueOf(aWord);
        return changedVar;
    }

    /***
     * This function will take a string and return the string in reversed order.
     * @param str
     * @return reverse The reverse order of str
     */
    public static String firstReverse(String str) {
        String[] var = str.split(" ");
        StringBuilder reverse = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }

    /***
     * This function will take integer num and return the factorial of it.
     * @param num The parameter will always be integer
     * @return var The factorial of num
     */
    public static int firstFactorial(int num) {
        int var = 1;

        for (int i = 1; i <= num; i++) {
            var *= i;
        }
        return var;
    }

    /***
     * This function will take a string  and return the largest word in the string.
     * @param str The string will not be empty
     * @return longest The first largest word in the str
     */
    public static String longestWord(String str) {
        String var[] = str.split(" ");
        String longest = "";

        for (String s : var) {
            String word = s.replaceAll("[^A-Za-z0-9]", "");
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    /***
     * print out instructions
     */
    public static void instruction(){
        System.out.println("Enter following number");
        System.out.println("1: Longest Word");
        System.out.println("2: First Factorial");
        System.out.println("3: First Reverse ");
        System.out.println("4: Letter Change");
        System.out.println("5: Simple adding");
        System.out.println("6: Letter Capitalize");
        System.out.println("7: Simple Symbols");
        System.out.println("8: Check Nums");
        System.out.println("9: Time Convert");
        System.out.println("10: AlphabetSoup");
        System.out.println("11: Kaprekars Constant");
        System.out.println("12: Chess Board");
        System.out.println("13 Maximal Square");
        System.out.println("0 : quit");
    }
}
