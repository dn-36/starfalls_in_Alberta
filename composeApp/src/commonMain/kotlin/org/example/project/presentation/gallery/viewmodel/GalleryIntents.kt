package com.project.astranomapp.presentation.gallery.viewmodel

import androidx.compose.ui.graphics.ImageBitmap

sealed class GalleryIntents{
object SetScreen:GalleryIntents()
    object Back:GalleryIntents()
    object AddStarfall:GalleryIntents()
    data class DeletePhoto(val image: ImageBitmap,val indexImage:Int):GalleryIntents()
    data class ChoiceImage(val imageString:String):GalleryIntents()
    object Shared:GalleryIntents()
}
