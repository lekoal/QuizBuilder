package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.SubscribeEntity

@Dao
interface SubscribeDao {
    @Query("SELECT * FROM subscribe")
    suspend fun getAllSubscribes(): List<SubscribeEntity>

    @Query("SELECT * FROM subscribe WHERE id LIKE :id")
    suspend fun getSubscribeById(id: Long): SubscribeEntity

    @Query("SELECT * FROM subscribe WHERE subscriberid LIKE :subscriber")
    suspend fun getSubscribesBySubscriber(subscriber: Long): List<SubscribeEntity>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertSubscribe(subscribe: SubscribeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSubscribe(subscribe: SubscribeEntity)

    @Delete
    suspend fun deleteSubscribe(subscribe: SubscribeEntity)
}