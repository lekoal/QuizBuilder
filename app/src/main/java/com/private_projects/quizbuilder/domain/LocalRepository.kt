package com.private_projects.quizbuilder.domain

import com.private_projects.quizbuilder.data.entities.AnswerEntity
import com.private_projects.quizbuilder.data.entities.QuizEntity
import com.private_projects.quizbuilder.data.entities.SelectQuestionEntity
import com.private_projects.quizbuilder.data.entities.SubscribeEntity
import com.private_projects.quizbuilder.data.entities.TextQuestionEntity
import com.private_projects.quizbuilder.data.entities.UserEntity

interface LocalRepository {
    //UserEntity
    suspend fun getAllUsers(): List<UserEntity>
    suspend fun getUserById(id: Long): UserEntity
    suspend fun getUserByName(name: String): UserEntity
    suspend fun insertUser(user: UserEntity)
    suspend fun updateUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)

    //QuizEntity
    suspend fun getAllQuizzes(): List<QuizEntity>
    suspend fun getQuizById(id: Long): QuizEntity
    suspend fun getQuizzesByOwner(ownerId: Long): List<QuizEntity>
    suspend fun insertQuiz(quiz: QuizEntity)
    suspend fun updateQuiz(quiz: QuizEntity)
    suspend fun deleteQuiz(quiz: QuizEntity)

    //SubscribeEntity
    suspend fun getAllSubscribes(): List<SubscribeEntity>
    suspend fun getSubscribeById(id: Long): SubscribeEntity
    suspend fun getSubscribesBySubscriber(subscriber: Long): List<SubscribeEntity>
    suspend fun insertSubscribe(subscribe: SubscribeEntity)
    suspend fun updateSubscribe(subscribe: SubscribeEntity)
    suspend fun deleteSubscribe(subscribe: SubscribeEntity)

    //TextQuestionEntity
    suspend fun getAllTextQuestions(): List<TextQuestionEntity>
    suspend fun getTextQuestionById(id: Long): TextQuestionEntity
    suspend fun getTextQuestionsByQuiz(quizId: Long): List<TextQuestionEntity>
    suspend fun insertTextQuestion(question: TextQuestionEntity)
    suspend fun updateTextQuestion(question: TextQuestionEntity)
    suspend fun deleteTextQuestion(question: TextQuestionEntity)

    //SelectQuestionEntity
    suspend fun getAllSelectQuestions(): List<SelectQuestionEntity>
    suspend fun getSelectQuestionById(id: Long): SelectQuestionEntity
    suspend fun getSelectQuestionsByQuiz(quizId: Long): List<SelectQuestionEntity>
    suspend fun insertSelectQuestion(question: SelectQuestionEntity)
    suspend fun updateSelectQuestion(question: SelectQuestionEntity)
    suspend fun deleteSelectQuestion(question: SelectQuestionEntity)

    //AnswerEntity
    suspend fun getAllAnswers(): List<AnswerEntity>
    suspend fun getAnswerById(id: Long): AnswerEntity
    suspend fun getAnswersByQuestion(questionId: Long): List<AnswerEntity>
    suspend fun insertAnswer(answer: AnswerEntity)
    suspend fun updateAnswer(answer: AnswerEntity)
    suspend fun deleteAnswer(answer: AnswerEntity)
}