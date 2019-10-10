/*
 * 3.Strings and basics of text processing
 * Task 2
 *
 * Замените в строке все вхождения 'word' на 'letter'.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.array_of_chars;

public class Task2 {
    public static void main(String[] args) {
        String text = "Give me your word. " +
                "May I get a word in? " +
                "He sent us word that he would be late.";
        System.out.println(text);
        String result = changeWords("word","letter", text);
        System.out.println(result);

    }

    public static String changeWords(String findingWord,
                                     String changingWord,
                                     String text){
        String result;
        char[]arrayOfText = text.toCharArray();
        char[]arrayOfFindingWord = findingWord.toCharArray();
        char[]arrayOfChangingWord = changingWord.toCharArray();
        int length = findingWord.length();
        for (int i = arrayOfText.length-1; i >= 0; i--) {
            if(arrayOfFindingWord[0] == arrayOfText[i]) {
                if(isEqualsArr(arrayOfText,arrayOfFindingWord,i,0)){
                    arrayOfText = changeWords(arrayOfText,arrayOfChangingWord,i,length);
                }
            }
        }
        result = String.valueOf(arrayOfText);
        return result;
    }

    public static boolean isEqualsArr(char arr1[], char arr2[],
                                      int key1, int key2){
        if(arr1.length - key1 < arr2.length - key2){
            return false;
        }
        for (int i = key1; i < arr1.length; i++) {
            if (arr1[i] != arr2[key2]){
                return false;
            } else if(arr1[i] == arr2[key2]){
                if(key2 == arr2.length-1){
                    return true;
                } else {
                    key2++;
                }
            }
        }
        return false;
    }

    public static char[] changeWords(char[] text, char[] word,
                                       int key, int length){
        int index = 0;
        char[] result = new char[text.length + word.length - length];
        for (int i = 0; i < key; i++) {
            result[i] = text[i];
        }
        for (int i = key; i < key+word.length; i++) {
            result[i] = word[index];
            index++;
        }
        index = key+length;
        for (int i = key+word.length; i < result.length; i++) {
            result[i] = text[index];
            index++;
        }
        return result;
    }
}
