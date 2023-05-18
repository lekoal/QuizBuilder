package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "textquestions",
    foreignKeys = [ForeignKey(
        entity = QuizEntity::class,
        parentColumns = ["id"],
        childColumns = ["quizid"]
    )]
)
data class TextQuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "quizid") val quizId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "answer") val answer: String?,
    @ColumnInfo(name = "photo") val photo: String?,
    @ColumnInfo(name = "audio") val audio: String?,
    @ColumnInfo(name = "video") val video: String?
)
