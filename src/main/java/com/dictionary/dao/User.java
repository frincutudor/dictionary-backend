package com.dictionary.dao;



// TODO: impement equals , hashcode and toString

public class User
{   
    private final String id; 
    
    private final String username;

    private final String password;

    private final String role;
    
    private final String pending;

    
    public User(String username, String password, String role ,String id ,String pending)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.pending = pending;
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
    
    public String getPending()
    {
        return pending;
    }


}
