package org.example.project.nika_screens_chats.dialog_feature.viewmodel

import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDate
import org.example.project.nika_screens_chats.dialog_feature.screen.DialogScreen
import org.example.project.nika_screens_chats.history_files_feature.screen.HistoryFilesScreen
import org.example.project.nika_screens_chats.list_dialog_feature.screen.ListDialogScreen

class DialogViewModel:ViewModel() {

    fun processIntent(intent: DialogIntents){
        when(intent){
            is DialogIntents.Back -> {back()}
            is DialogIntents.HistoryFiles -> {historyFiles()}
        }
    }

    fun back() {

        StaticDate.navigator.push(ListDialogScreen())

    }

    fun historyFiles() {

        StaticDate.navigator.push(HistoryFilesScreen())

    }
}