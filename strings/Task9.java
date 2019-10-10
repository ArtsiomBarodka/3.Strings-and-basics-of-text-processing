/*
 * 3.Strings and basics of text processing
 * Task 9
 *
 * Посчитать количество строчных (маленьких)
 * и прописных (больших) букв в введенной строке.
 * Учитывать только английские буквы.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        String text;
        try (Scanner scanner = new Scanner(System.in)){
            text = scanner.nextLine();
        }
        System.out.println("Количество маленьких букв = "+countLowerCaseLetters(text));
        System.out.println("Количество больших букв = "+countUpperCaseLetters(text));

    }

    public static int countUpperCaseLetters(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                count++;
            }
        }
        return count;
    }

    public static int countLowerCaseLetters (String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                count++;
            }
        }
        return count;
    }
}
