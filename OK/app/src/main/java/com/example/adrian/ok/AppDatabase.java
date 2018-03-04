package com.example.adrian.ok;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by cameron on 04/03/18.
 */

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();

    public abstract WorkoutDao workoutDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                            .allowMainThreadQueries().addMigrations(new Migration[] {new Migration(1, 2) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {
                            // do nothing here
                        }
                    }}).build();
        }
        return instance;
    }

    public static void shutdown() {
        instance = null;
    }
}
