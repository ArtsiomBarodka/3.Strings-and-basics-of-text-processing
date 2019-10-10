/*
 * 3.Strings and basics of text processing
 * Task 6
 *
 * Из заданной строки получить новую,
 * повторив каждый символ дважды.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

public class Task6 {
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

        System.out.println(multiplyLetter(text,2));
    }

    public static String multiplyLetter(String text, int multiplier){
        StringBuilder result = new StringBuilder();
        result.ensureCapacity(text.length()*multiplier);
        for (int i = 0; i < text.length(); i++) {
            for (int j = 1; j <= multiplier; j++) {
                result.append(text.charAt(i));
                if(Character.isWhitespace(text.charAt(i))){
                    break;
                }
            }
        }
        return result.toString();
    }
}
