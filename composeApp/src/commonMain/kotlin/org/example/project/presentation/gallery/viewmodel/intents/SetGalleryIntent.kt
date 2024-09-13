package com.project.astranomapp.presentation.gallery.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery

object SetGalleryIntent {
    fun execute(){
        if(ViewModelGallery(StaticDate).date.isUsedGallery) {
            ViewModelGallery(StaticDate).date.isUsedGallery = false
            ViewModelGallery.galleryState = ViewModelGallery.galleryState.copy(
                theme = mutableStateOf(ViewModelGallery(StaticDate).date.theme),
                listGallery =  ViewModelGallery(StaticDate).date.listGallery,
                listDescription = ViewModelGallery(StaticDate).date.listDescription
            )
        }
    }
}