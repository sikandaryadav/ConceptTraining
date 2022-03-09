package chetu.second.batch.demo.roomDb.dataAccessObject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import chetu.second.batch.demo.roomDb.dataEntity.User;

@Dao
public interface UserDao {
    @Insert
    List<Long> insertData(User... users);

    @Query("SELECT * FROM user")
    List<User> getAllData();

    @Delete
    int deleteUser(User user);

    @Update
    int updateUser(User user);

}
