import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String allWords;
        String[] words;
        try (FileReader fr = new FileReader("src/input.txt"))
        {
            BufferedReader reader = new BufferedReader(fr);
            allWords = reader.readLine();

            System.out.println("Полученные данные:");
            System.out.println(allWords);

            words = allWords.split(" ");

            System.out.println("Количество слов: " + wordsCount(words));
            System.out.println("Самое длинное слово: " + longestWord(words));
            System.out.println("Подсчет частоты:");
            wordCounter(words);
        }catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    static int wordsCount(String[] words) {
        return words.length;
    }

    static String longestWord(String[] words) {
        int index = 0;
        int maxLength = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLength) {
                index = i;
                maxLength = words[i].length();
            }
        }

        return words[index];
    }

    static void wordCounter(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                int n = map.get(word);
                n++;
                map.put(word, n);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Number value = entry.getValue();

            System.out.println(key + ": " + value);
        }
    }
}
