package com.solvd.hardwarestore.read_write_file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ReadingFile {
    private static final Logger LOGGER = LogManager.getLogger(ReadingFile.class);
    // Input and output file paths

    public static void readWriteFile(String inputFilePath, String outputFilePath) {
        try {
            // Read text from the input file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");


            // Split the content into words
            String[] words = StringUtils.split(content);

            //Delete al punctuation in the array and low case the text
            for (int i = 0; i < words.length - 1; i++) {
                //To lower case
                words[i] = words[i].toLowerCase();
                words[i] = words[i].replaceAll("\\p{Punct}", "");
            }
            Arrays.sort(words);

            //Count the amount of words in the array
            int arrayLength = words.length;

            //System.out.println(Arrays.toString(words));

            // Count the occurrences of each word
            Map<String, Integer> wordCount = new HashMap<>();
            int count = 0;
            for (int i = 0; i <= arrayLength - 1; i++) {
                for (int j = i; j <= arrayLength - 1; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                    }
                }
                wordCount.putIfAbsent(words[i], count);
                count = 0;
            }

            //System.out.println(wordCount);
            // Convert the map to a String representation. First i create an array
            //with wordCount.entrySet() and then i join it
            String result = StringUtils.join(wordCount.entrySet(), '\n');

            // Write the result to the output file
            FileUtils.writeStringToFile(new File(outputFilePath), result, "UTF-8");

            LOGGER.info("Saved into: " + outputFilePath);
        } catch (
                IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


    public static void findUniqueWord(String wordToFind, String inputFilePath) {
        try {
            // Read text from the input file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            //System.out.println(content);

            // Split the content into words
            String[] words = StringUtils.split(content);


            Optional<String> result = Arrays.stream(words)
                    .filter(word -> word.equals(wordToFind))
                    .findAny();

            String message= result.orElseGet(() -> "No word found");
            if (message.equals("No word found")){
                LOGGER.info(message);
            }else {
                LOGGER.info(String.format("The word given: '%s', exist in the input file.",message));
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


    public static void orderWordsByLength(String inputFilePath, String outputFilePath) {
        try {
            // Read text from the input file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            //System.out.println(content);

            // Split the content into words
            String[] words = StringUtils.split(content);
            List<String> listOfWords = new ArrayList<>();
            listOfWords = Arrays.asList(words);

            String result = listOfWords.stream()
                    .sorted((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                    .collect(Collectors.joining("\n"));

            FileUtils.writeStringToFile(new File(outputFilePath), result, "UTF-8");

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


    public static void countCharacters(String inputFilePath) {
        try {
            // Read text from the input file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            //System.out.println(content);

            // Split the content into words
            String[] words = StringUtils.split(content);
            List<String> listOfWords = new ArrayList<>();
            listOfWords = Arrays.asList(words);

            Integer result = listOfWords.stream()
                    .map(word -> word.toLowerCase())
                    .map(word -> word.replaceAll("\\p{Punct}", ""))
                    .mapToInt(word -> word.length())
                    .sum();

            //FileUtils.writeStringToFile(new File(outputFilePath), result.toString(), "UTF-8");
            LOGGER.info(String.format("The amount if characters in the file given without count spaces and punctuation are %s", result));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }


    public static void findAnyNumber(String inputFilePath) {
        try {
            // Read text from the input file
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

            String[] list = StringUtils.split(content);

            List<String> list2 = Arrays.asList(list);

            Optional<String> wordWithNumber = Arrays.stream(list)
                    .filter(word -> word.matches(".*\\d.*"))
                    .findAny();

            String finalMessage = wordWithNumber.orElse("No number found, well done.");

            String finalMessage2 = null;

            if (finalMessage.equals("No number found, well done.")) {
                finalMessage2 = finalMessage;
                LOGGER.info(finalMessage2);
            } else {
                finalMessage2 = String.format("A number was found in the text, the first one is: %s",wordWithNumber.get());
                LOGGER.info(finalMessage2);
            }


            //FileUtils.writeStringToFile(new File(outputFilePath), finalMessage2, "UTF-8");

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

