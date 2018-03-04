package com.example.adrian.ok;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by cameron on 04/03/18.
 */

@Dao
public interface WorkoutDao {

    @Insert
    void insert(Workout workout);

    @Update
    void update(Workout... workouts);

    @Delete
    void delete(Workout... workouts);

    @Query("SELECT * FROM workouts WHERE user_id = :userId")
    List<Workout> getWorkoutsForUser(int userId);
}
