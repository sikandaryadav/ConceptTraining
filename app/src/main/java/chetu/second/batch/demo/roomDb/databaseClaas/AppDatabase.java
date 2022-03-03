package chetu.second.batch.demo.roomDb.databaseClaas;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import chetu.second.batch.demo.roomDb.dataAccessObject.UserDao;
import chetu.second.batch.demo.roomDb.dataEntity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase appDatabaseInstance;

    public static AppDatabase getInstance(Context context){
        if (appDatabaseInstance == null){
            appDatabaseInstance = Room.databaseBuilder(context, AppDatabase.class, "UserDatabase").build();
        }
        return appDatabaseInstance;
    }

    public abstract UserDao userDao();
}
