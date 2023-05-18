package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.private_projects.quizbuilder.utils.converters.AnswersJsonConverter

@Entity(
    tableName = "selectquestions",
    foreignKeys = [ForeignKey(
        entity = QuizEntity::class,
        parentColumns = ["id"],
        childColumns = ["quizid"]
    )]
)
data class SelectQuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "quizid") val quizId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "answers")
    @TypeConverters(AnswersJsonConverter::class)
    val answers: List<AnswerEntity>?
)
