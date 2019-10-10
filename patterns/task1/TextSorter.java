/*
 * 3.Strings and basics of text processing
 * Task 1
 *
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять
 * с текстом три различных операции: отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине; отсортировать лексемы в
 * предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.patterns.Task1;

import java.util.*;
import java.util.regex.Pattern;

public class TextSorter {

    private Pattern pattern;
    private StringBuilder result;

    //Отсортировать абзацы по количеству предложений
    public String sortParagraph(String text){
        result = new StringBuilder();
        Map<Integer, Integer> paragraphs = new TreeMap<>((key1,key2) -> {
                int result = key1.compareTo(key2);
                if (result == 0) {
                    result = -1;
                }
                return result;
        });
        pattern = Pattern.compile("\n");
        String arr[] = pattern.split(text);
        pattern = Pattern.compile("[;.!?]");
        for (int i = 0; i < arr.length; i++) {
            paragraphs.put(pattern.split(arr[i]).length,i);
        }
        for(Map.Entry<Integer, Integer> paragraph : paragraphs.entrySet()){
            result.append(arr[paragraph.getValue()].concat("\n"));
        }
        return result.toString();
    }

    //отсортировать слова по длине
    public String sortWords(String text){
        result = new StringBuilder();
        pattern = Pattern.compile("[;.!?]");
        List<String> sentences = Arrays.asList(pattern.split(text));
        for (String sentence: sentences) {
            String [] arr = sentence.split("[,\\s*]");
             Arrays.sort(arr, ( word1, word2) -> {
                    if(word1.length() >= word2.length()){
                        return 1;
                    } else {
                        return -1;
                    }
                }
            );
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].isEmpty()){
                    continue;
                }
                result.append(arr[i]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     *
     * отсортировать лексемы в предложении по убыванию количества
     * вхождений заданного символа, а в случае равенства – по алфавиту.
     *
     */
    public String sortLetters(String text){
        result = new StringBuilder();
        pattern = Pattern.compile("[;.!?]");
        List<String> sentences = Arrays.asList(pattern.split(text));
        pattern = Pattern.compile("[,\\s]");
        for (String sentence : sentences) {
            List<String> words = Arrays.asList(pattern.split(sentence));
            for (String word : words) {
                if(word.isEmpty()) {
                    continue;
                }
                result.append(Arrays.toString(sort(word.toCharArray())));
            }
            result.append("\n");
        }
        return result.toString();
    }

    private static char[] sort(char[] ch){
        char[]result ;
        int index = 0;

        TreeMap<Character,Integer> letters = new TreeMap<>();
        for (int i = 0; i < ch.length; i++) {
            int count = 0;
            for (int j = 0; j < ch.length; j++) {
                if(ch[i] == ch[j]){
                    count++;
                }
            }
                letters.put(ch[i],count);
        }
        result = new char[letters.size()];
        for(Map.Entry<Character, Integer> letter : letters.entrySet()){
            result[index] = letter.getKey();
            index++;
        }

        for (int i = 0; i < result.length-1; i++) {
            int max = i;
            for (int j = i + 1; j < result.length; j++) {
                if(letters.get(result[j]) > letters.get(result[max])){
                    max = j;
                } else if(letters.get(result[j]).equals(letters.get(result[max]))){
                    if(Character.toLowerCase(result[j]) > Character.toLowerCase(result[max])){
                        max = j;
                    }
                }
                char temp = result[max];
                result[max] = result[j];
                result[j] = temp;
            }
        }
        return result;

    }




}
