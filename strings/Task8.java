/*
 * 3.Strings and basics of text processing
 * Task 8
 *
 * Вводится строка слов, разделенных пробелами.
 * Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        String text;
        try (Scanner scanner = new Scanner(System.in)){
            text = scanner.nextLine();
        }
        System.out.println("Самое длинное слово - "+findTheLongestWordInText(text));
    }

    public static String findTheLongestWordInText(String text){
        String arr[] = text.split(" ");
        int maxLen = arr[0].length();
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if(maxLen < arr[i].length()){
                maxLen = arr[i].length();
                index = i;
            }
        }
        return arr[index];
    }

}
