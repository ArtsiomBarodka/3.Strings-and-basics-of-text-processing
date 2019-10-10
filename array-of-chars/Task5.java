/*
 * 3.Strings and basics of text processing
 * Task 5
 *
 * Удалить в строке все лишние пробелы,
 * то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.array_of_chars;

public class Task5 {
    public static void main(String[] args) {
        String text = " Contrary    to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots    in a piece of classical      Latin literature from 45 BC, " +
                "making it over 2000 years old. Richard McClintock, " +
                "a    Latin     professor at Hampden-Sydney College in Virginia, " +
                "looked up one   of the more obscure Latin words, consectetur, " +
                "from a Lorem Ipsum passage, and going through the cites of " +
                "the word in       classical literature,   discovered the undoubtable source. " +
                "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 " +
                "of \"de    Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) " +
                "by Cicero, written in 45 BC.    This book is a treatise on the theory of ethics, " +
                "very popular during the Renaissance.    The first line of Lorem Ipsum, " +
                "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. ";
        String result = trimOfText(text);
        System.out.println(result);
    }

    public static String trimOfText(String text){
        char [] arrayOfText = text.toCharArray();
        String result;
        for (int i = arrayOfText.length-1; i >= 1; i--) {
            if(Character.isWhitespace(arrayOfText[i])&&Character.isWhitespace(arrayOfText[i-1])){
                arrayOfText = delElement(arrayOfText,i);
            }
        }
        arrayOfText = Character.isWhitespace(arrayOfText[0])?
                delElement(arrayOfText,0) : arrayOfText;
        arrayOfText = Character.isWhitespace(arrayOfText[arrayOfText.length-1])?
                delElement(arrayOfText,arrayOfText.length-1) : arrayOfText;
        result = String.valueOf(arrayOfText);
        return result;
    }

    public static char[] delElement(char[] arr, int key){
        char [] result = new char[arr.length-1];
        for (int i = 0; i < key; i++) {
            result[i] = arr[i];
        }
        if(key == result.length-1){
            return result;
        }
        for (int i = key; i < result.length; i++) {
            result[i] = arr[i+1];
        }
        return result;
    }
}
