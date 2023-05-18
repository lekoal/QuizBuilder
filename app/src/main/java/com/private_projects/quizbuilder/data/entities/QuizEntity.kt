package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.private_projects.quizbuilder.utils.converters.SelectQuestionJsonConverter
import com.private_projects.quizbuilder.utils.converters.TextQuestionJsonConverter

@Entity(
    tableName = "quizzes",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["ownerid"]
    )]
)
data class QuizEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "ownerid") val ownerId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "time") val time: Int,
    @ColumnInfo(name = "textquestions")
    @TypeConverters(TextQuestionJsonConverter::class)
    val textQuestions: List<TextQuestionEntity>?,
    @ColumnInfo(name = "selectquestions")
    @TypeConverters(SelectQuestionJsonConverter::class)
    val selectQuestions: List<SelectQuestionEntity>?
)
