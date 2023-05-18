package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "answer",
    foreignKeys = [ForeignKey(
        entity = SelectQuestionEntity::class,
        parentColumns = ["id"],
        childColumns = ["questionsid"]
    )]
)
data class AnswerEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "questionsid") val questionsId: Long,
    @ColumnInfo(name = "iscorrect") val isCorrect: Boolean?,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "photo") val photo: String?,
    @ColumnInfo(name = "audio") val audio: String?,
    @ColumnInfo(name = "video") val video: String?
)
