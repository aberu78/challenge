import java.util.Arrays;
import java.util.Scanner;

/**
 * This Main class is for new hire training Coding Challenge
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
                    System.out.println("check nums :" + checkNum(num1, num2) + "\n");
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

                    int[][] matrix = matrix(str);
                    System.out.println("Maximal Square  :" + maximalSquare(matrix) + "\n");
                    break;
                case 14:
                    System.out.println("Enter number (Pentagonal Number challenge)");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Number of dots: " + pentagonalNumbers(num) + "\n");
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

    /***
     * This functio will read a positive integer and determined how many dots exist in a pentagonal shape
     * around a center dot on the Nth iteration.
     * @param n The integer that is nth iteration
     * @return integer that is Centered pentagonal number : Cpn = (5n^2-5n+2)/2
     */
    public static int pentagonalNumbers(int n){

        return (int)((5*Math.pow(n,2)) - 5*n +2) / 2;
    }
    /***
     * This function will take a string parameter and return 2d array of binary matrix.
     * @param str The string that will change
     * @return newArr The 2d array of the str
     */
    private static int[][] matrix (String str){

        str = str.replaceAll("[\s\"]", "");
        String[] strArr = str.split(",");

        int[][] newArr = new int[strArr.length][strArr[0].length()];

        for(int i = 0; i < strArr.length; i++){
            for(int j= 0; j < newArr[0].length;j++){
                newArr[i][j] = Integer.parseInt(strArr[i].substring(j,j+1));
            }
        }
        return newArr;
    }

    /***
     * This function will take 2d matrix array and return area of largest square sub-matrix that contains all 1's.
     * @param strArray The 2d array of matrix
     * @return maxNewArr*MaxNewArr The area of largest square of sub-matrix
     */
    public static int maximalSquare(int[][] strArray){
        int xLength = strArray.length; //row
        int yLength = strArray[0].length; //column
        int[][] newArr = new int[xLength][yLength];

        for(int i =0;i < xLength; i++ ) {
            newArr[i][0] = strArray[i][0];
        }
        System.arraycopy(strArray[0], 0, newArr[0], 0, yLength);
        int maxNewArr = newArr[0][0];
        for(int i = 1; i < xLength; i++){
            for(int j = 1; j < yLength; j++) {
                if (strArray[i][j] == 1) {
                    newArr[i][j] = Math.min(newArr[i][j - 1], Math.min(newArr[i - 1][j], newArr[i - 1][j - 1])) + 1;

                    if (maxNewArr < newArr[i][j]) {
                        maxNewArr = newArr[i][j];
                    }
                }
                else {
                    newArr[i][j] = 0;
                }
            }
        }
        return maxNewArr*maxNewArr;
    }

    /***
     * This function will take a string consisting of the location of space on a standard 8X8 chess board with
     * no pieces on the board along with another space on the chess board. The structure of a string
     * is "(x,y)(a,b)" where a > x and b > y. This program will return how many ways there are of traveling from (x,y)
     * on the board to (a,b) moving only up and to the right.
     * @param str The string location of spaces in the 8X8 chessboard
     * @return res The integer that counts how many ways to get to from (x,y) to (a,b)
     */
    public static int chessBoardTraveling(String str) {

        int x1 = Character.digit(str.charAt(1),10);
        int x2 = Character.digit(str.charAt(5),10);
        int y1 = Character.digit(str.charAt(2),10);
        int y2 = Character.digit(str.charAt(6),10);

        int m = Math.abs(x2 - x1);
        int n = Math.abs(y2 - y1);
        int res = 1;

        for (int i = 0; i < n; ++i) {
            res *= ((m + n) - i);
            res /= (i + 1);
        }

        return res;
    }

    /***
     * This function will take a number which consists of 4-digits with at least 2 distinct digits and
     * performs following algorithm.
     * 1. Arrange 4-digits numbers in descending and in ascending order(adding zeros to fit to a 4-digits number)
     * 2. Subtract ascending order from descending order until the answer of this subtraction is 6174.
     * 3. return how many times it takes to get the above operation.
     * @param num The number that will be used
     * @return count The integer that will return how many times two operations takes to get 6174
     */
    public static int kapreKarsConstant(int num) {
        int count = 0;

        boolean isValid = false;
        while (!isValid) {

            char[] temp = String.valueOf(num).toCharArray();
            Arrays.sort(temp);
            int num1 = Integer.parseInt(String.valueOf(temp));

            StringBuilder input1 = new StringBuilder();
            input1.append(String.valueOf(temp));
            input1 = input1.reverse();

            int num2 = Integer.parseInt(String.valueOf(input1));
            System.out.println(num2 + " - " + num1 + " = " + (num2 - num1));

            num = num2 - num1;
            if (num == 6174) {  // 6174 required by algorithm number#2
                isValid = true;
            } else {
                if (num < 1000) { // if number is less than 4 digits
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
        char[] aWord = str.toCharArray();
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

    /***
     * This function will take 2 numbers and return "-1" for both number equal, "true" for
     * the second number is greater than the first number entered,and otherwise "false"
     * @param num1 The first number entered by a user
     * @param num2 The second number entered by a user
     * @return str The string will return "-1" if num1=num2, "true" if num1<num2, and "false" if num1 > num2
     * */
    public static String checkNum(int num1, int num2) {
        String str = "";
        if(num1 ==  num2){
            str= "-1";
        }
        else if(num1 < num2){
            str = "true";
        }
        else{
            str = "false";
        }
        return str;
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
            return num + simpleAdding(num - 1);
        }
    }

    /***
     * This function will take a string and modify it using following algorithm below and return the new string
     * 1: replace every letter in the string to next alphabet.(a->b, b->c, z->a)
     * 2: capitalize every vowel in the new string(a,e,i,o,u)
     * @param str The String to modify
     * @return changeVar The replaced to next letters with all vowel capitalized.
     */
    public static String letterChanges(String str) {
        String changedVar = "";
        char[] aWord = str.toCharArray();
        for (int i = 0; i < aWord.length; i++) {
            if (Character.isLetter(aWord[i])) {
                int ascii = aWord[i];

                if (ascii != (int) 'z' && ascii != 'Z') {
                    ascii += 1;
                    char testChar = (char) ascii;
                    if (testChar == 'e' || testChar == 'i' || testChar == 'o' || testChar == 'u') {
                        testChar = Character.toUpperCase(testChar);
                    }
                    aWord[i] = testChar;
                } else {
                    aWord[i] = 'A';
                }
            }
        }
        changedVar = String.valueOf(aWord);
        return changedVar;
    }

    /***
     * This function will take a string and return the string in reversed order.
     * @param str The string to change
     * @return reverse The reverse order of str
     */
    public static String firstReverse(String str) {
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
        String[] var = str.split(" ");
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
        System.out.println("13: Maximal Square");
        System.out.println("14: Pentagonal Number");
        System.out.println("0 : quit");
    }
}
