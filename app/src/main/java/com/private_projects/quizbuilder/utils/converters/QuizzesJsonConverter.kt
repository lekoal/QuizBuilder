package com.private_projects.quizbuilder.utils.converters

import androidx.room.TypeConverter
import com.private_projects.quizbuilder.data.entities.QuizEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class QuizzesJsonConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listConverter = ListJsonConverter(moshi.adapter(QuizEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(quizzes: List<QuizEntity>): String? {
        return listConverter.toJson(quizzes) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(text: String): List<QuizEntity>? {
        return listConverter.fromJson(text)
    }
}