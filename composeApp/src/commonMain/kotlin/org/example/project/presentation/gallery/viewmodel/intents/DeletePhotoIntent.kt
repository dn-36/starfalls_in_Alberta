package org.example.project.presentation.gallery.viewmodel.intents

import androidx.compose.ui.graphics.ImageBitmap
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery

object DeletePhotoIntent {
    fun execute(image: ImageBitmap,indexImage:Int){
        val newList = ViewModelGallery(StaticDate).date.listGallery.toMutableList()

        val newListDescription = ViewModelGallery(StaticDate).date.listDescription.toMutableList()

        newList.remove(image)

        newListDescription.removeAt(indexImage)


        ViewModelGallery.galleryState = ViewModelGallery.galleryState.copy(
            listGallery = newList,
            listDescription = newListDescription
        )


        ViewModelGallery(StaticDate).date.listGallery.remove(image)
        ViewModelGallery(StaticDate).date.listDescription.removeAt(indexImage)
    }
}