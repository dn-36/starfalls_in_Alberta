package org.example.project.presentation.gallery.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.screen.GalleryScreen
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

object BackIntent {
    fun execute(){
        StaticDate.navigator.push(MenuScreen)
    }
}