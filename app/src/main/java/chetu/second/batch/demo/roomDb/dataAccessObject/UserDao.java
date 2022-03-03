package chetu.second.batch.demo.roomDb.dataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import chetu.second.batch.demo.roomDb.dataEntity.User;

@Dao
public interface UserDao {
    @Insert
    List<Long> insertData(User... users);

    @Query("SELECT * FROM user")
    List<User> getAllData();

}
