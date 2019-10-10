/*
 * 3.Strings and basics of text processing
 * Task 1
 *
 * Дан массив названий переменных в camelCase.
 * Преобразовать названия в snake_case.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.array_of_chars;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        String arr[] = {"oneName","twoMyName","threeNamesOfMyCar"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(changeNameFromCamelCaseToSnakeCase(arr)));
    }

    public static String[] changeNameFromCamelCaseToSnakeCase(String arr[]){
        char[] arrOfWord;
        for (int i = 0; i < arr.length; i++) {
            arrOfWord = arr[i].toCharArray();
            for (int j = arrOfWord.length-1; j >= 0; j--) {
                if(Character.isUpperCase(arrOfWord[j])){
                    arrOfWord[j] = Character.toLowerCase(arrOfWord[j]);
                    arrOfWord = increaseArray(arrOfWord,j);
                }
            }
            arr[i] = String.valueOf(arrOfWord);
        }
        return arr;
    }

    public static char[] increaseArray(char[] arr,int key){
        char[] result = new char[arr.length+1];
        for (int i = 0; i < result.length; i++) {
            if(i == key){
                result[i] = '_';
            } else if (i < key){
                result[i] = arr[i];
            } else if (i > key){
                result[i] = arr[i-1];
            }
        }
        return result;
    }

}
