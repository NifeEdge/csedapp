package com.example.adrian.ok;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by cameron on 04/03/18.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE username = :username")
    User getUserByUsername(String username);

    @Insert
    void createUser(User user);

    @Delete
    void deleteUser(User user);
}
