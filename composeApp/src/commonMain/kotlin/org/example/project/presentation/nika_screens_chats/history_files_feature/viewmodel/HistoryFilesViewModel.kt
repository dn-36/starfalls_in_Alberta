package org.example.project.nika_screens_chats.history_files_feature.viewmodel

import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDate
import org.example.project.nika_screens_chats.dialog_feature.screen.DialogScreen

class HistoryFilesViewModel : ViewModel() {

    fun processIntent(intent: HistoryFilesIntents) {
        when (intent) {
            is HistoryFilesIntents.Back -> {
                back()
            }
        }
    }

    fun back() {
        StaticDate.navigator.push(DialogScreen())

    }

}