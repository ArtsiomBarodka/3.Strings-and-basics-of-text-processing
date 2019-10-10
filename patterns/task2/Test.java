/*
 * 3.Strings and basics of text processing
 * Task 2
 *
 * Напишите анализатор, позволяющий последовательно возвращать содержимое
 * узлов xml-документа и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 *
 * Artsiom Barodka
 *
 */
package strings_and_basics_of_text_processing.patterns.Task2;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        XMLAnalizator analizator = new XMLAnalizator("src/main/resources/text.xml");
        try {
            System.out.println(analizator.parseAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
