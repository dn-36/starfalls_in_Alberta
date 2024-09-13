package com.project.astranomapp.presentation.gallery.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.astranomapp.data.StaticDateApi
import org.example.project.presentation.gallery.viewmodel.intents.BackIntent
import com.project.astranomapp.presentation.gallery.viewmodel.intents.SetGalleryIntent
import org.example.project.presentation.gallery.viewmodel.intents.AddStarfallIntent
import org.example.project.presentation.gallery.viewmodel.intents.ChoiceImageIntent
import org.example.project.presentation.gallery.viewmodel.intents.DeletePhotoIntent
import org.example.project.presentation.gallery.viewmodel.intents.SharedIntent

class ViewModelGallery(val date: StaticDateApi):ViewModel() {
    companion object{
        var galleryState by mutableStateOf(GalleryState())
    }
    fun processIntent(intents: GalleryIntents){
        when(intents){
            is GalleryIntents.SetScreen -> {SetGalleryIntent.execute()}
            is GalleryIntents.Back -> {
                BackIntent.execute()}
            is GalleryIntents.AddStarfall -> {AddStarfallIntent.execute()}
            is GalleryIntents.DeletePhoto -> {DeletePhotoIntent.execute(intents.image,intents.indexImage)}
            is GalleryIntents.ChoiceImage -> {ChoiceImageIntent.execute(intents.imageString)}
            is GalleryIntents.Shared -> {SharedIntent.execute()}
        }
    }
}