package com.project.astranomapp.presentation.create_user_card_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.ViewModelCreateUserCard
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.example.project.ServiceLocator
import kotlin.coroutines.coroutineContext


object CreateIntent {
    fun execute(name:String,age:String,place:String,experience:String){
        if (name.length == 0 || age.length == 0 || place.length == 0 || experience.length == 0) {
ViewModelCreateUserCard.createUserCardState = ViewModelCreateUserCard.createUserCardState.copy(
    toast = mutableStateOf(true)
)
        }
        else{
            CoroutineScope(Dispatchers.IO).launch {
                ServiceLocator.key.saveString("name",name)
            }
        StaticDate.navigator.push(MenuScreen)}

    }
}