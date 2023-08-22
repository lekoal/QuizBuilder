package com.private_projects.quizbuilder.mock_data

import com.private_projects.quizbuilder.utils.HashCoding

object Users {
    val list = listOf(
        UserData(
            userName = "123",
            userPassword = HashCoding().convert("123")
        ),
        UserData(
            userName = "456",
            userPassword = HashCoding().convert("456")
        )
    )
}