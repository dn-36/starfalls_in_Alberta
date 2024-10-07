package org.example.project.nika_screens_chats.list_dialog_feature.viewmodel

import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDate
import org.example.project.nika_screens_chats.add_chat_feature.screen.SelectContactsScreen
import org.example.project.nika_screens_chats.dialog_feature.screen.DialogScreen

class ListDialogViewModel : ViewModel() {

    fun processIntent(intent: ListDialogIntents) {
        when (intent) {
            is ListDialogIntents.DialogueSelection -> {
                dialogueSelection()
            }
            is ListDialogIntents.AddChat -> {
                addChat()
            }
        }
    }

    fun dialogueSelection() {

        StaticDate.navigator.push(DialogScreen())

    }

    fun addChat() {

        StaticDate.navigator.push(SelectContactsScreen())

    }

}