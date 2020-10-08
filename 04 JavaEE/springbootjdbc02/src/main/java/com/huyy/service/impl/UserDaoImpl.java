package com.huyy.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.huyy.pojo.User;
import com.huyy.service.UserDao;

import net.sf.json.JSONObject;

@Repository
public class UserDaoImpl implements UserDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users(name, password, age) values(?, ?, ?)",
              user.getName(), user.getPassword(), user.getAge());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET name = ? , password = ? , age = ? WHERE id=?",
               user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM users where id = ? ",id);

    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", 
        		new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> findALL() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
        // return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper(User.class));
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }

    @Override
    public String saveUser(JSONObject jo) {
        //解析json
        int id = jo.getInt("id");
        String name = jo.getString("name");
        String password = jo.getString("password");
        int age = jo.getInt("age");
        
        
        jdbcTemplate.update("INSERT INTO users (id,name,password,age) VALUES (?,?,?,?)",
                id,name,password,age);
        
        return "success";
    }

    @Override
    public List<User> getUserById(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?",
                new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> getUserByIdName(int id, String name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ? and name = ?",
                new Object[] { id,name }, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> getUserByIdName2(String id, String name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ? and name = ?",
                new Object[] { id,name }, new BeanPropertyRowMapper<User>(User.class));
    }
}
