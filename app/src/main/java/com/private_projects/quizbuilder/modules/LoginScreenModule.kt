package com.private_projects.quizbuilder.modules

import com.private_projects.quizbuilder.ui.login.LoginScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val loginScreenModule = module {
    viewModel(qualifier = qualifier("login_screen_view_model")) {
        LoginScreenViewModel(context = androidContext())
    }
}