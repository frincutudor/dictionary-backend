package com.dictionary.dao;

import java.util.UUID;

// TODO: impement equals , hashcode and toString

public class User
{   
    private final String id; 
    
    private final String username;

    private final String password;

    private final String role;

    
    public User(String username, String password, String role ,String id)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRole()
    {
        return role;
    }
    

    public String getId()
    {
        return id;
    }


}
