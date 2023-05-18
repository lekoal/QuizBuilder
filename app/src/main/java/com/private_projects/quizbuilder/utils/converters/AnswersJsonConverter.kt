package com.private_projects.quizbuilder.utils.converters

import androidx.room.TypeConverter
import com.private_projects.quizbuilder.data.entities.AnswerEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class AnswersJsonConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listConverter = ListJsonConverter(moshi.adapter(AnswerEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(answers: List<AnswerEntity>): String? {
        return listConverter.toJson(answers) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(text: String): List<AnswerEntity>? {
        return listConverter.fromJson(text)
    }
}