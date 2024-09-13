package com.project.astranomapp.presentation.add_starfall_feature.viewmodel

import androidx.compose.ui.graphics.ImageBitmap

sealed class AddStarfallIntents{
    object SetScreen:AddStarfallIntents()
    object Back:AddStarfallIntents()
    object Toast:AddStarfallIntents()
    data class Save(val images:MutableList<ImageBitmap>,val date:String,val location:String):AddStarfallIntents()
}
