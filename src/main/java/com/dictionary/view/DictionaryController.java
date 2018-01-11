package com.dictionary.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary.dao.User;
import com.dictionary.dao.UserInfo;
import com.dictionary.dao.Word;
import com.dictionary.service.DictionaryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DictionaryController
{   
    @Autowired
    DictionaryService dictionaryService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User login(@RequestBody UserInfo user) {
           
        return dictionaryService.login(user);
    }
    
    @RequestMapping(value = "/words", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getWords() {
      
        return new ResponseEntity<List<Word>>(dictionaryService.getWords(),HttpStatus.OK);
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getUsers() {
      
        return new ResponseEntity<List<User>>(dictionaryService.getUser(),HttpStatus.OK);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> register(@RequestBody UserInfo user) {
    	dictionaryService.register(user);
        return  new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
        
    }
}
