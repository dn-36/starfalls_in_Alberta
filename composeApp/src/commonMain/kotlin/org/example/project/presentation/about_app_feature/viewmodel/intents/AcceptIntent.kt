package com.project.astranomapp.presentation.about_app_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.create_user_card_feature.screen.CreateUserCardScreen
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.ServiceLocator

object AcceptIntent {
    fun execute(){
        CoroutineScope(Dispatchers.IO).launch {
            ServiceLocator.key.saveString("name","name")
        }
        StaticDate.navigator.push(MenuScreen)
    }
}