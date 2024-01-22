package com.example.ymca_fieldproject_backend;

public class SearchResult {
    private String link;
    private String information;

    public SearchResult() {
    }

    public SearchResult(String link, String information) {
        this.link = link;
        this.information = information;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
