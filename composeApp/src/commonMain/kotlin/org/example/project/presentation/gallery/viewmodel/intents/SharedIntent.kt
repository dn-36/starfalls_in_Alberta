package org.example.project.presentation.gallery.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery
import org.example.project.ServiceLocator


object SharedIntent {
    fun execute() {
        if(ViewModelGallery.galleryState.listGallery.size == 0){
            return
        }
        ViewModelGallery(StaticDate).date.first = true
        ViewModelGallery.galleryState =  ViewModelGallery.galleryState.copy(
            alpha = mutableStateOf(0f),
            alphaSelectPhoto = mutableStateOf(1f)
        )
    }
}