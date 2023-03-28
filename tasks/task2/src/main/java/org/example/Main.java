package org.example;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> wordsMap = new HashMap<>();
        List<String> outputArray = new ArrayList<>();
        try{
            File file = new File("movie.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                word = word.replace(".","");
                word = word.replace(",","");
                if(wordsMap.containsKey(word)){
                    wordsMap.put(word, wordsMap.get(word)+1);
                }else {
                    wordsMap.put(word, 1);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        wordsMap.entrySet().stream()
                .sorted((one, another) -> - one.getValue().compareTo(another.getValue())) //sort entries to reverse order
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}