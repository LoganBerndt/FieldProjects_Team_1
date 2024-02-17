package com.example.ymca_fieldproject_backend;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchBarTest {

    @Test
    public void testGetLink() {
        SearchResult result = new SearchResult("https://example.com", "Example Information");
        assertEquals("https://example.com", result.getLink());
    }

    @Test
    public void testGetInformation() {
        SearchResult result = new SearchResult("https://example.com", "Example Information");
        assertEquals("Example Information", result.getInformation());
    }

    @Test
    public void testSetLink() {
        SearchResult result = new SearchResult();
        result.setLink("https://newexample.com");
        assertEquals("https://newexample.com", result.getLink());
    }

    @Test
    public void testSetInformation() {
        SearchResult result = new SearchResult();
        result.setInformation("New Example Information");
        assertEquals("New Example Information", result.getInformation());
    }

    @Test
    public void testPerformSearch() throws IOException {
        // Instantiate a Model object for testing
        Model model = new org.springframework.ui.ConcurrentModel();
        SearchEngine.setSearchText("example");
        String result = SearchEngine.performSearch(model);
        assertEquals("search", result);
    }
}
