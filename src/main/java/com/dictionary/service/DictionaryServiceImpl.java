package com.dictionary.service;

import java.util.List;
import java.util.Objects;

import com.dictionary.dao.User;
import com.dictionary.dao.UserInfo;
import com.dictionary.dao.Word;
import com.dictionary.repo.DictionaryRepository;

public class DictionaryServiceImpl implements DictionaryService
{
    private final DictionaryRepository dictionaryRepository;

    public DictionaryServiceImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = Objects.requireNonNull(dictionaryRepository,
                "The given dictionary repository ca not be null.");
    }

    @Override
    public User login(UserInfo user)
    {
        return dictionaryRepository.login(user);
    }

    @Override
    public List<Word> getWords()
    {
        return dictionaryRepository.getWords();
    }

	@Override
	public List<User> getUser() {
	
		return dictionaryRepository.getUsers();
	}

	@Override
	public void register(UserInfo user) {

		 dictionaryRepository.register(user);
	}
}
