package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.AnswerEntity

@Dao
interface AnswerDao {
    @Query("SELECT * FROM answer")
    suspend fun getAllAnswers(): List<AnswerEntity>

    @Query("SELECT * FROM answer WHERE id LIKE :id")
    suspend fun getAnswerById(id: Long): AnswerEntity

    @Query("SELECT * FROM answer WHERE questionsid LIKE :questionId")
    suspend fun getAnswersByQuestion(questionId: Long): List<AnswerEntity>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertAnswer(answer: AnswerEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAnswer(answer: AnswerEntity)

    @Delete
    suspend fun deleteAnswer(answer: AnswerEntity)
}