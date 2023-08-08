package com.private_projects.quizbuilder.modules

import com.private_projects.quizbuilder.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val mainModule = module {
    viewModel(qualifier = qualifier("main_view_model")) {
        MainViewModel()
    }
}