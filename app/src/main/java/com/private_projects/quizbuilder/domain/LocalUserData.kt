package com.private_projects.quizbuilder.domain

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.private_projects.quizbuilder.mock_data.UserData

class LocalUserData(context: Context) {
    private val keyGenParameter = MasterKeys.AES256_GCM_SPEC
    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameter)
    private val securePreferences = EncryptedSharedPreferences.create(
        USER_SECURED_PREFS,
        mainKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    companion object {
        private const val USER_SECURED_PREFS = "local_user_secured_shared_preferences"
        private const val USER_NAME = "user_name"
        private const val USER_PASSWORD = "user_password"
    }
    fun write(userData: UserData) {
        with(securePreferences.edit()) {
            putString(USER_NAME, userData.userName)
            putString(USER_PASSWORD, userData.userPassword)
            commit()
        }
    }

    fun read(): UserData? {
        val userName = securePreferences.getString(USER_NAME, "")
        val userPassword = securePreferences.getString(USER_PASSWORD, "")
        return if (userName.isNullOrEmpty() || userPassword.isNullOrEmpty()) null
        else UserData(
            userName = userName,
            userPassword = userPassword
        )
    }
}