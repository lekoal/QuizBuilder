package com.private_projects.quizbuilder.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "subscribe",
    foreignKeys = [ForeignKey(
        entity = QuizEntity::class,
        parentColumns = ["id"],
        childColumns = ["quizid"]
    ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["subscriberid"]
        )]
)
data class SubscribeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "subscriberid") val subscriberId: Long,
    @ColumnInfo(name = "quizid") val quizId: Long?,
    @ColumnInfo(name = "score") val score: Int?
)
