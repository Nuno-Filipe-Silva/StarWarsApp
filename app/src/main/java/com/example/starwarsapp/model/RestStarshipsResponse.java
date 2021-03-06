package com.example.starwarsapp.model;

import java.util.List;

public class RestStarshipsResponse {

    private int count;
    private String next;
    private String previous;
    private List<Starships> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Starships> getResults() {
        return results;
    }

    public void setResults(List<Starships> results) {
        this.results = results;
    }
}

