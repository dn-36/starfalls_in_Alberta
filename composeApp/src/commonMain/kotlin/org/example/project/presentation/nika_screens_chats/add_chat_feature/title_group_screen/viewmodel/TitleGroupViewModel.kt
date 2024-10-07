package org.example.project.nika_screens_chats.title_group_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDate
import org.example.project.nika_screens_chats.dialog_feature.screen.DialogScreen
import org.example.project.presentation.nika_screens_chats.add_chat_feature.title_group_screen.viewmodel.TitleGroupState

class TitleGroupViewModel:ViewModel() {

    var titleGroupState by mutableStateOf(TitleGroupState())

    fun processIntent(intent: TitleGroupIntents){
        when(intent){
            is TitleGroupIntents.Ready -> {ready()}
        }
    }

    fun ready() {

        StaticDate.navigator.push(DialogScreen())

    }
}