/*
 * 3.Strings and basics of text processing
 * Task 10
 *
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
 * восклицательным или вопросительным знаком.
 * Определить количество предложений в строке X.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

public class Task10 {

    public static void main(String[] args) {
        String text = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, " +
                "making it over 2000 years old. Richard McClintock, " +
                "a Latin professor at Hampden-Sydney College in Virginia, " +
                "looked up one of the more obscure Latin words, consectetur, " +
                "from a Lorem Ipsum passage, and going through the cites of " +
                "the word in classical literature, discovered the undoubtable source. ";

        System.out.println("Количество предложений в строке = "+countSentence(text));
    }

    public static int countSentence(String text){
        char ch;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            if(ch == '.' || ch == '?' || ch == '!'){
                count++;
            }
        }
        return count;
    }
}
