package org.example.project.presentation.gallery.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery
import org.example.project.ServiceLocator

object ChoiceImageIntent {
    fun execute(photoPath: String){
        if(ViewModelGallery(StaticDate).date.first == false){
            return
        }
        ServiceLocator.photoSender.sendPhoto(photoPath)
        ViewModelGallery(StaticDate).date.first = false
        ViewModelGallery.galleryState =  ViewModelGallery.galleryState.copy(
            alpha = mutableStateOf(1f),
            alphaSelectPhoto = mutableStateOf(0f))
    }
}