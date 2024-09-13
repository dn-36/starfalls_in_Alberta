package com.project.astranomapp.presentation.menu_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.screen.GalleryScreen
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

object GalleryIntent {
    fun execute(){
        MenuViewModel(StaticDate).date.isUsedGallery = true
        StaticDate.navigator.push(GalleryScreen)
    }
}