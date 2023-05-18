package com.private_projects.quizbuilder.data

import com.private_projects.quizbuilder.data.database.LocalDataBase
import com.private_projects.quizbuilder.data.entities.QuizEntity
import com.private_projects.quizbuilder.data.entities.SelectQuestionEntity
import com.private_projects.quizbuilder.data.entities.SubscribeEntity
import com.private_projects.quizbuilder.data.entities.TextQuestionEntity
import com.private_projects.quizbuilder.data.entities.UserEntity
import com.private_projects.quizbuilder.domain.LocalRepository

class LocalRepositoryImpl(localDataBase: LocalDataBase) : LocalRepository {
    //UserEntity
    private val userDao = localDataBase.userDao()
    override suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    override suspend fun getUserById(id: Long): UserEntity {
        return userDao.getUserById(id)
    }

    override suspend fun getUserByName(name: String): UserEntity {
        return userDao.getUserByName(name)
    }

    override suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }

    //QuizEntity
    private val quizDao = localDataBase.quizDao()
    override suspend fun getAllQuizzes(): List<QuizEntity> {
        return quizDao.getAllQuizzes()
    }

    override suspend fun getQuizById(id: Long): QuizEntity {
        return quizDao.getQuizById(id)
    }

    override suspend fun getQuizzesByOwner(ownerId: Long): List<QuizEntity> {
        return quizDao.getQuizzesByOwner(ownerId)
    }

    override suspend fun insertQuiz(quiz: QuizEntity) {
        quizDao.insertQuiz(quiz)
    }

    override suspend fun updateQuiz(quiz: QuizEntity) {
        quizDao.updateQuiz(quiz)
    }

    override suspend fun deleteQuiz(quiz: QuizEntity) {
        quizDao.deleteQuiz(quiz)
    }

    //SubscribeEntity
    private val subscribeDao = localDataBase.subscribeDao()
    override suspend fun getAllSubscribes(): List<SubscribeEntity> {
        return subscribeDao.getAllSubscribes()
    }

    override suspend fun getSubscribeById(id: Long): SubscribeEntity {
        return subscribeDao.getSubscribeById(id)
    }

    override suspend fun getSubscribesBySubscriber(subscriber: Long): List<SubscribeEntity> {
        return subscribeDao.getSubscribesBySubscriber(subscriber)
    }

    override suspend fun insertSubscribe(subscribe: SubscribeEntity) {
        subscribeDao.insertSubscribe(subscribe)
    }

    override suspend fun updateSubscribe(subscribe: SubscribeEntity) {
        subscribeDao.updateSubscribe(subscribe)
    }

    override suspend fun deleteSubscribe(subscribe: SubscribeEntity) {
        subscribeDao.deleteSubscribe(subscribe)
    }

    //TextQuestionEntity
    private val textQuestionDao = localDataBase.textQuestionDao()
    override suspend fun getAllTextQuestions(): List<TextQuestionEntity> {
        return textQuestionDao.getAllTextQuestions()
    }

    override suspend fun getTextQuestionById(id: Long): TextQuestionEntity {
        return textQuestionDao.getTextQuestionById(id)
    }

    override suspend fun getTextQuestionsByQuiz(quizId: Long): List<TextQuestionEntity> {
        return textQuestionDao.getTextQuestionsByQuiz(quizId)
    }

    override suspend fun insertTextQuestion(question: TextQuestionEntity) {
        textQuestionDao.insertTextQuestion(question)
    }

    override suspend fun updateTextQuestion(question: TextQuestionEntity) {
        textQuestionDao.updateTextQuestion(question)
    }

    override suspend fun deleteTextQuestion(question: TextQuestionEntity) {
        textQuestionDao.deleteTextQuestion(question)
    }

    //SelectQuestionEntity
    private val selectQuestionDao = localDataBase.selectQuestionDao()
    override suspend fun getAllSelectQuestions(): List<SelectQuestionEntity> {
        return selectQuestionDao.getAllSelectQuestions()
    }

    override suspend fun getSelectQuestionById(id: Long): SelectQuestionEntity {
        return selectQuestionDao.getSelectQuestionById(id)
    }

    override suspend fun getSelectQuestionsByQuiz(quizId: Long): List<SelectQuestionEntity> {
        return selectQuestionDao.getSelectQuestionsByQuiz(quizId)
    }

    override suspend fun insertSelectQuestion(question: SelectQuestionEntity) {
        selectQuestionDao.insertSelectQuestion(question)
    }

    override suspend fun updateSelectQuestion(question: SelectQuestionEntity) {
        selectQuestionDao.updateSelectQuestion(question)
    }

    override suspend fun deleteSelectQuestion(question: SelectQuestionEntity) {
        selectQuestionDao.deleteSelectQuestion(question)
    }


}