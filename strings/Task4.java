/*
 * 3.Strings and basics of text processing
 * Task 4
 *
 * С помощью функции копирования и операции конкатенации
 * составить из частей слова “информатика” слово “торт”.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

public class Task4 {
    public static void main(String[] args) {
        String word = "информатика";
        String result = word.substring(7,8) + word.substring(3,5) + word.substring(7,8);
        System.out.println(result);
    }
}
