package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.QuizEntity

@Dao
interface QuizDao {
    @Query("SELECT * FROM quizzes")
    suspend fun getAllQuizzes(): List<QuizEntity>

    @Query("SELECT * FROM quizzes WHERE id LIKE :id")
    suspend fun getQuizById(id: Long): QuizEntity

    @Query("SELECT * FROM quizzes WHERE ownerid LIKE :ownerId")
    suspend fun getQuizzesByOwner(ownerId: Long): List<QuizEntity>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertQuiz(quiz: QuizEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuiz(quiz: QuizEntity)

    @Delete
    suspend fun deleteQuiz(quiz: QuizEntity)
}