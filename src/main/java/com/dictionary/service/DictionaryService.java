package com.dictionary.service;

import java.util.List;

import com.dictionary.dao.User;
import com.dictionary.dao.UserInfo;
import com.dictionary.dao.Word;

public interface DictionaryService
{
    User login (UserInfo user);
    
    List<Word> getWords();
}
