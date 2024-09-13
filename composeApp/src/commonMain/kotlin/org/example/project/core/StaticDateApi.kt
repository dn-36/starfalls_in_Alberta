package com.project.astranomapp.data

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.DrawableResource

interface StaticDateApi {
    var theme:DrawableResource
    var isUsedMenu:Boolean
    var isUsedSelect:Boolean
    var isUsedFuture:Boolean
    var isUsedGallery:Boolean
    var first:Boolean
    var isUsedAddStarfall:Boolean
    var listGallery:MutableList<ImageBitmap>
    var listDescription:MutableList<String>
    //var listMyStarfalls:MutableList<Pair<String,MutableList<ImageBitmap>>>

}