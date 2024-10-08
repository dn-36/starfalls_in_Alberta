package org.example.project.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import org.example.project.nika_screens_chats.list_dialog_feature.screen.ListDialogScreen
import org.example.project.presentation.main_screen_feature.screen.MainScreen

@Composable
fun navigator(){
    Navigator(screen = ListDialogScreen())
}