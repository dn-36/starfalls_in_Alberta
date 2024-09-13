package com.project.astranomapp.presentation.gallery.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap


import org.jetbrains.compose.resources.DrawableResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund

data class GalleryState(
    val theme: MutableState<DrawableResource> = mutableStateOf(Res.drawable.one_backgraund),
    val alpha: MutableState<Float> = mutableStateOf(1F),
    val alphaSelectPhoto: MutableState<Float> = mutableStateOf(0F),
    val listGallery: MutableList<ImageBitmap> = mutableListOf(),
    val listDescription: MutableList<String> = mutableListOf()
)
