package com.private_projects.quizbuilder.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.private_projects.quizbuilder.data.dao.AnswerDao
import com.private_projects.quizbuilder.data.dao.QuizDao
import com.private_projects.quizbuilder.data.dao.SelectQuestionDao
import com.private_projects.quizbuilder.data.dao.SubscribeDao
import com.private_projects.quizbuilder.data.dao.TextQuestionDao
import com.private_projects.quizbuilder.data.dao.UserDao
import com.private_projects.quizbuilder.data.entities.AnswerEntity
import com.private_projects.quizbuilder.data.entities.QuizEntity
import com.private_projects.quizbuilder.data.entities.SelectQuestionEntity
import com.private_projects.quizbuilder.data.entities.SubscribeEntity
import com.private_projects.quizbuilder.data.entities.TextQuestionEntity
import com.private_projects.quizbuilder.data.entities.UserEntity
import com.private_projects.quizbuilder.utils.converters.AnswersJsonConverter
import com.private_projects.quizbuilder.utils.converters.QuizzesJsonConverter
import com.private_projects.quizbuilder.utils.converters.SelectQuestionJsonConverter
import com.private_projects.quizbuilder.utils.converters.SubscribesJsonConverter
import com.private_projects.quizbuilder.utils.converters.TextQuestionJsonConverter

@Database(
    entities = [
        UserEntity::class,
        QuizEntity::class,
        SubscribeEntity::class,
        TextQuestionEntity::class,
        SelectQuestionEntity::class,
        AnswerEntity::class
    ],
    version = 1
)
@TypeConverters(
    QuizzesJsonConverter::class,
    SubscribesJsonConverter::class,
    TextQuestionJsonConverter::class,
    SelectQuestionJsonConverter::class,
    AnswersJsonConverter::class
)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun quizDao(): QuizDao
    abstract fun subscribeDao(): SubscribeDao
    abstract fun textQuestionDao(): TextQuestionDao
    abstract fun selectQuestionDao(): SelectQuestionDao
    abstract fun answerDao(): AnswerDao

    companion object {
        private var instance: LocalDataBase? = null

        fun getInstance(context: Context): LocalDataBase {
            if (instance == null) {
                synchronized(LocalDataBase::class) {
                    instance = buildRoomDB(context)
                }
            }
            return instance!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LocalDataBase::class.java,
                "local.db"
            ).build()
    }
}