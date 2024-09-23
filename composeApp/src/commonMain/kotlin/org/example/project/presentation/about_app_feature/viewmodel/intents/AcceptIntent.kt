package com.project.astranomapp.presentation.about_app_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.create_user_card_feature.screen.CreateUserCardScreen
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen

object AcceptIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)
    }
}