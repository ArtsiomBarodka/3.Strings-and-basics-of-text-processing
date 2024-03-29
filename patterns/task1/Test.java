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

public class Test {
    public static void main(String[] args) {
        String text = "Душа моя озарена неземной радостью. как эти чудесные весенние утра, " +
                "которыми я наслаждаюсь от всего сердца. Я совсем один и блаженствую в здешнем краю. " +
                "словно созданном для таких, как я." +
                "\n" +
                "Я так счастлив, мой друг, так упоен ощущением покоя, что искусство мое страдает от этого. " +
                "Ни одного штриха не мог бы я сделать, а никогда не был таким большим художником, как в эти минуты." +
                "\n" +
                "Когда от милой моей долины поднимается пар и полдневное солнце стоит над непроницаемой чащей " +
                "темного леса и лишь редкий луч проскальзывает в его святая святых, а я лежу в высокой траве у " +
                "быстрого ручья и, прильнув;";

        TextSorter sorter = new TextSorter();
        System.out.println(sorter.sortParagraph(text));
        System.out.println(sorter.sortWords(text));
        System.out.println(sorter.sortLetters(text));
    }
}
