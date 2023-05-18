package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.private_projects.quizbuilder.utils.converters.QuizzesJsonConverter
import com.private_projects.quizbuilder.utils.converters.SubscribesJsonConverter

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "hash") val hash: String,
    @ColumnInfo(name = "quizzes")
    @TypeConverters(QuizzesJsonConverter::class)
    val quizzes: List<QuizEntity>?,
    @ColumnInfo(name = "subscribes")
    @TypeConverters(SubscribesJsonConverter::class)
    val subscribes: List<SubscribeEntity>?
)
