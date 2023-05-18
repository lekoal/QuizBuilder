package com.private_projects.quizbuilder.utils.converters

import androidx.room.TypeConverter
import com.private_projects.quizbuilder.data.entities.SelectQuestionEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SelectQuestionJsonConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listConverter = ListJsonConverter(moshi.adapter(SelectQuestionEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(selectQuestions: List<SelectQuestionEntity>): String? {
        return listConverter.toJson(selectQuestions) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(text: String): List<SelectQuestionEntity>? {
        return listConverter.fromJson(text)
    }
}