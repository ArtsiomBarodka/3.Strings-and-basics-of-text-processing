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

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLAnalizator {

    private String file;

    public XMLAnalizator(String file) {
        this.file = file;
    }

    private static String readFile(String fileName) throws IOException {
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            StringBuilder sb = new StringBuilder();
            while (bf.ready()) {
                sb.append(bf.readLine());
            }
            return sb.toString().replaceAll("\r\n","");
        }
    }

    public String parseAll() throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList<String> list;
        LinkedHashSet<String> tags = new LinkedHashSet<>();
        String text = readFile(file);

        Pattern tagsPattern = Pattern.compile("<[a-zA-Z]+");
        Matcher tagsMatcher = tagsPattern.matcher(text);

        while (tagsMatcher.find()) {
            tags.add(tagsMatcher.group().replaceAll("<",""));
        }
        for (String tag : tags) {
            list = splitFile(text,tag);
            for (String res:list) {
                result.append(res).append("\n");
            }
        }
        return result.toString();
    }

    public String parse(String tag) throws IOException {
        StringBuilder result = new StringBuilder();
        String text = readFile(file);
        ArrayList<String> list = splitFile(text,tag);
        for (String res:list) {
            result.append(res+"\n");
        }
        return result.toString();
    }

    private static ArrayList<String> splitFile(String someFile, String tag) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayDeque<Integer> startArrayDeque = new ArrayDeque<>();
        TreeMap<Integer, Integer> posTreeMap = new TreeMap<>();
        Pattern tagPattern = Pattern.compile("(<" + tag + ")|(</" + tag + ">)");
        Matcher tagMatcher = tagPattern.matcher(someFile);

        while (tagMatcher.find()) {
            if (("<" + tag).equals(tagMatcher.group())) {
                startArrayDeque.push(tagMatcher.start());
            }
            if (("</" + tag + ">").equals(tagMatcher.group())) {
                posTreeMap.put(startArrayDeque.pop(), tagMatcher.end());
            }
        }
        for (Map.Entry<Integer, Integer> tagString: posTreeMap.entrySet()) {
            stringArrayList.add(someFile.substring(tagString.getKey(), tagString.getValue()));
        }
        return stringArrayList;
    }
}
