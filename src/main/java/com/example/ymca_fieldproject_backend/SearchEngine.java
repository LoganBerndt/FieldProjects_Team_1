package com.example.ymca_fieldproject_backend;

import org.jsoup.Jsoup;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

// Devin Johnson
// 1/22/2024
// Search Engine
public class SearchEngine {

    private static String searchText;
    private static final String[] ignoreFiles = {"search.html", "fragments"};

    public static String getSearchText() {return searchText;}

    public static void setSearchText(String searchText) {SearchEngine.searchText = searchText;}

    public static String performSearch(Model model) throws IOException {
        // gets names of the all html files
        File filePath = new File("src/main/resources/templates");
        List<String> htmlFilesList = new ArrayList<>(Arrays.asList(filePath.list()));

        // removes the files we don't want to search
        for (String ignoreName : ignoreFiles){
            htmlFilesList.remove(ignoreName);
        }
        String[] htmlFiles = htmlFilesList.toArray(new String[0]);

        Set<String> processedPages = new HashSet<>();
        List<SearchResult> searchResults = new ArrayList<>();
        String searchText = getSearchText().toLowerCase();

        // loops through html files
        for (String fileName : htmlFiles) {
            String filePathStr = "templates/" + fileName;
            ClassPathResource resource = new ClassPathResource(filePathStr);
            InputStream inputStream = resource.getInputStream();
            Scanner sc = new Scanner(inputStream);
            StringBuilder sb = new StringBuilder();

            // loops through text that the scanner got from the html file
            while (sc.hasNext()) {
                sb.append(sc.nextLine()).append("\n");
            }

            inputStream.close();
            // removes the html tags using Jsoup
            String fileContents = Jsoup.parse(sb.toString()).text();
            // removes the ".html" from the html file names. For using as a link on the page
            String linkText = fileName.replaceFirst("[.][^.]+$", "");

            if (fileContents.toLowerCase().contains(searchText) && processedPages.add(linkText)) {
                SearchResult searchResult = new SearchResult();
                searchResult.setLink(linkText);
                searchResult.setInformation(retrieveSurroundingWords(fileContents, searchText));
                searchResults.add(searchResult);
            }
        }

        if (!searchText.trim().isEmpty()) {
            model.addAttribute("searchResults", searchResults);
        }

        return "search";
    }

    // retrieves the 20 words in front and after the searched word
    private static String retrieveSurroundingWords(String sentence, String searchText) {
        String[] words = sentence.split("\\s+");
        int index = indexOfSearchWord(words, searchText);
        int start = Math.max(0, index - 20);
        int end = Math.min(words.length, index + 21);
        return String.join(" ", Arrays.copyOfRange(words, start, end));
    }

    // returns index of search word to use in extractSurroundingContext
    private static int indexOfSearchWord(String[] words, String searchText) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().contains(searchText)) {
                return i;
            }
        }
        return -1;
    }
}
