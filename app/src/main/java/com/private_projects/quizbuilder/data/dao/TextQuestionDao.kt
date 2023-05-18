package com.private_projects.quizbuilder.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.private_projects.quizbuilder.data.entities.TextQuestionEntity

@Dao
interface TextQuestionDao {
    @Query("SELECT * FROM textquestions")
    suspend fun getAllTextQuestions(): List<TextQuestionEntity>

    @Query("SELECT * FROM textquestions WHERE id LIKE :id")
    suspend fun getTextQuestionById(id: Long): TextQuestionEntity

    @Query("SELECT * FROM textquestions WHERE quizid LIKE :quizId")
    suspend fun getTextQuestionsByQuiz(quizId: Long): List<TextQuestionEntity>

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertTextQuestion(question: TextQuestionEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTextQuestion(question: TextQuestionEntity)

    @Delete
    suspend fun deleteTextQuestion(question: TextQuestionEntity)
}