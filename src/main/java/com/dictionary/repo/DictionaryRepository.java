package com.dictionary.repo;

import java.util.List;

import com.dictionary.dao.User;
import com.dictionary.dao.UserInfo;
import com.dictionary.dao.Word;

public interface DictionaryRepository
{
    User login(UserInfo user);
    
    List<Word> getWords();
    
}
