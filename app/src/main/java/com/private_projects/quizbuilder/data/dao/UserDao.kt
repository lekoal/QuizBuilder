package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id LIKE :id")
    suspend fun getUserById(id: Long): UserEntity

    @Query("SELECT * FROM users WHERE name LIKE :name")
    suspend fun getUserByName(name: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertUser(user: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}