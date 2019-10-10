/*
 * 3.Strings and basics of text processing
 * Task 3
 *
 * Проверить, является ли заданное слово палиндромом.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.strings;

public class Task3 {
    public static void main(String[] args) {
        String words[] = {"Топот", "поход","довод","дед","Борьба","радар"};
        for (int i = 0; i < words.length; i++) {
            if(isPolidrom(words[i])){
                System.out.println(words[i]+" - слово полидром");
            } else {
                System.out.println(words[i]+" - обычное слово");
            }
        }
    }

    public static boolean isPolidrom(String word){
        int len = word.length();
        int index = len/2;
        String firstHalfOfWord;
        String secondHalfOfWord;

        if(len%2 != 0){
            firstHalfOfWord = word.substring(0,len/2).toLowerCase();
            secondHalfOfWord = word.substring((len/2)+1,len).toLowerCase();
        } else {
            firstHalfOfWord = word.substring(0,len/2).toLowerCase();
            secondHalfOfWord = word.substring(len/2,len).toLowerCase();
        }
        for (int i = 0; i < firstHalfOfWord.length(); i++) {
            if(firstHalfOfWord.charAt(i) != secondHalfOfWord.charAt(index-1)){
                return false;
            }
            index--;
        }
        return true;
    }
}
