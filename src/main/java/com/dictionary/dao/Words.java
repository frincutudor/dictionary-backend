package com.dictionary.dao;

import java.util.List;

public class Words
{
    private final List<Word> words;
    
    public Words(List<Word> words)
    {
        this.words = words;
    }

    public List<Word> getWords()
    {
        return words;
    }
    
    
    
}
