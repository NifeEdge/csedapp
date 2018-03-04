package com.example.adrian.ok;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by cameron on 04/03/18.
 */

@Entity(tableName = "workouts",
        foreignKeys = @ForeignKey(entity = User.class,
parentColumns = "id",
childColumns = "user_id",
onDelete = CASCADE ))
public class Workout {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date_created")
    private String dateCreated;
    // What other data needed for workout?

    public Workout() {
        this.dateCreated = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }
}
