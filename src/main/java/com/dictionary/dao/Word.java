package com.dictionary.dao;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Word
{
    private final String id;
    private final String name;
    private final String definition;
    private final String category;

    @JsonCreator
    public Word(@JsonProperty("name") String name, @JsonProperty("definition") String definition, @JsonProperty("category") String category)
    {
        
        this.name = name;
        this.definition = definition;
        this.category = category;
        this.id = UUID.randomUUID().toString();
    }
    
    
    public Word(String name,String definition,String category,String id)
    {
        
        this.name = name;
        this.definition = definition;
        this.category = category;
        this.id = id;
    }


    public String getName()
    {
        return name;
    }
    
    public String getId()
    {
        return id;
    }

    public String getDefinition()
    {
        return definition;
    }

    public String getCategory()
    {
        return category;
    }

}
