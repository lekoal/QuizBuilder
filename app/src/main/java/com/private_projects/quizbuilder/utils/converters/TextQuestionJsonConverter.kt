package com.private_projects.quizbuilder.utils.converters

import androidx.room.TypeConverter
import com.private_projects.quizbuilder.data.entities.TextQuestionEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class TextQuestionJsonConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listConverter = ListJsonConverter(moshi.adapter(TextQuestionEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(textQuestions: List<TextQuestionEntity>): String? {
        return listConverter.toJson(textQuestions) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(text: String): List<TextQuestionEntity>? {
        return listConverter.fromJson(text)
    }
}