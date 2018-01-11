package com.dictionary.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dictionary.dao.User;
import com.dictionary.dao.UserInfo;
import com.dictionary.dao.Word;

//TODO: Implement ExceptionHandler

public class DictionaryRepositoryImpl implements DictionaryRepository
{
    private final JdbcTemplate jdbcTemplate;

    public DictionaryRepositoryImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate,
                                                   "The given jdbcTemplate is not allowed to be null.");
    }

    @Override
    public User login(UserInfo user)
    {
        String sql = "SELECT * FROM login WHERE username=\'" + user.getUsername() + "\' AND " + "password=\'" + user.getPassword() + "\'";

        List<User> foundUser = jdbcTemplate.query(sql,
                                                  new RowMapper<User>()
                                                  {

                                                      public User mapRow(ResultSet rs, int rowNum)
                                                          throws SQLException
                                                      {
                                                          User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("id") , rs.getString("pending"));

                                                          return user;
                                                      }

                                                  });

        return foundUser.get(0);
    }

    @Override
    public List<Word> getWords()
    {
        String sql = "SELECT * FROM words";

        List<Word> words = jdbcTemplate.query(sql,
                                                  new RowMapper<Word>()
                                                  {

                                                      public Word mapRow(ResultSet rs, int rowNum)
                                                          throws SQLException
                                                      {
                                                          Word word = new Word(rs.getString("name"), rs.getString("definition"), rs.getString("category"), rs.getString("id"));

                                                          return word;
                                                      }

                                                  });

        return words;
    }

	@Override
	public List<User> getUsers() {
		
		String sql = "SELECT * FROM login";

        List<User> users = jdbcTemplate.query(sql,
                                                  new RowMapper<User>()
                                                  {

                                                      public User mapRow(ResultSet rs, int rowNum)
                                                          throws SQLException
                                                      {
                                                          User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("role"), rs.getString("id") , rs.getString("pending"));

                                                          return user;
                                                      }

                                                  });

        return users;
	}

	public void register(UserInfo user) {
		
		String sql = "INSERT INTO login (id,username, password, role , pending)"
				+ " VALUES (?,?,?,?,?)";

		jdbcTemplate.update(sql, UUID.randomUUID().toString(), user.getUsername(), user.getPassword(), "USER" , "true");
		
		
	}
}
