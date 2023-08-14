package com.private_projects.quizbuilder.ui.main

import android.app.Application
import com.private_projects.quizbuilder.modules.loginStateModule
import com.private_projects.quizbuilder.modules.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(mainModule, loginStateModule)
        }
    }
}