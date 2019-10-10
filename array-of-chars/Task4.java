/*
 * 3.Strings and basics of text processing
 * Task 4
 *
 * В строке найти количество чисел.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.array_of_chars;

public class Task4 {
    public static void main(String[] args) {
        String text = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, " +
                "making it over 2000 years old. Richard McClintock, " +
                "a Latin professor at Hampden-Sydney College in Virginia, " +
                "looked up one of the more obscure Latin words, consectetur, " +
                "from a Lorem Ipsum passage, and going through the cites of " +
                "the word in classical literature, discovered the undoubtable source. " +
                "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 " +
                "of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) " +
                "by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, " +
                "very popular during the Renaissance. The first line of Lorem Ipsum, " +
                "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

        System.out.println("Количество чисел а тексте состаляет" + countNumbers(text));
    }

    public static int countNumbers(String text){
        int count = 0;
        char [] arrayOfText = text.toCharArray();
        for (int i = 1; i < arrayOfText.length; i++) {
            if(Character.isDigit(arrayOfText[i])&&!Character.isDigit(arrayOfText[i-1])){
                count++;
            }
        }
        return count;
    }
}
