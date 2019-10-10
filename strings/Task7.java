/*
 * 3.Strings and basics of text processing
 * Task 7
 *
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        String text;
        try (Scanner scanner = new Scanner(System.in)){
              text = scanner.nextLine();
        }
        System.out.println(improveText(text));
    }

    public static String improveText(String text){
        StringBuilder result = new StringBuilder();
        result.ensureCapacity(text.length());
        int index = 0;

        while (Character.isWhitespace(text.charAt(index))){
            index++;
        }
        result.insert(0,text.charAt(index));
        for (int i = text.length()-1; i >= 0; i--) {
            if(Character.isWhitespace(text.charAt(i))){
                continue;
            }
            if(text.charAt(i) != result.charAt(0)){
                result.insert(0,text.charAt(i));
            }
        }
        return result.toString();
    }
}
