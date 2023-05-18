package com.private_projects.quizbuilder.utils.converters

import androidx.room.TypeConverter
import com.private_projects.quizbuilder.data.entities.SubscribeEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class SubscribesJsonConverter {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val listConverter = ListJsonConverter(moshi.adapter(SubscribeEntity::class.java))

    @TypeConverter
    @ToJson
    fun toJson(subscribes: List<SubscribeEntity>): String? {
        return listConverter.toJson(subscribes) ?: null
    }

    @TypeConverter
    @FromJson
    fun fromJson(text: String): List<SubscribeEntity>? {
        return listConverter.fromJson(text)
    }
}