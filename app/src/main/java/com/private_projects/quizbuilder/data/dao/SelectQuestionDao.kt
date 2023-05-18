package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.SelectQuestionEntity

@Dao
interface SelectQuestionDao {
    @Query("SELECT * FROM selectquestions")
    suspend fun getAllSelectQuestions(): List<SelectQuestionEntity>

    @Query("SELECT * FROM selectquestions WHERE id LIKE :id")
    suspend fun getSelectQuestionById(id: Long): SelectQuestionEntity

    @Query("SELECT * FROM selectquestions WHERE quizid LIKE :quizId")
    suspend fun getSelectQuestionsByQuiz(quizId: Long): List<SelectQuestionEntity>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertSelectQuestion(question: SelectQuestionEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSelectQuestion(question: SelectQuestionEntity)

    @Delete
    suspend fun deleteSelectQuestion(question: SelectQuestionEntity)
}