package com.private_projects.quizbuilder.modules

import com.private_projects.quizbuilder.ui.login.LoginStateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val loginStateModule = module {
    viewModel(qualifier = qualifier("login_state_view_model")) {
        LoginStateViewModel()
    }
}