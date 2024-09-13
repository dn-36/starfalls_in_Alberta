package com.project.astranomapp.data

import androidx.compose.ui.graphics.ImageBitmap
import cafe.adriel.voyager.navigator.Navigator


import org.jetbrains.compose.resources.DrawableResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund

object StaticDate:StaticDateApi{
    lateinit var navigator: Navigator
    override var theme: DrawableResource = Res.drawable.one_backgraund
    override var isUsedAddStarfall: Boolean = true
    override var isUsedMenu: Boolean = true
    override var isUsedGallery: Boolean = true
    override var isUsedSelect: Boolean = true
    override var isUsedFuture: Boolean = true
    override var first: Boolean = false
    override var listGallery: MutableList<ImageBitmap> = mutableListOf()
    override var listDescription: MutableList<String> = mutableListOf()
   // override var listMyStarfalls: MutableList<Pair<String, MutableList<ImageBitmap>>> = mutableListOf()

}