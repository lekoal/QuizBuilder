package com.private_projects.quizbuilder.utils

import java.security.MessageDigest

class HashCoding {
    fun convert(input: String): String {
        val bytes = input.toByteArray()
        val messageDigest = MessageDigest.getInstance("SHA-256")
        val digest = messageDigest.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }
}