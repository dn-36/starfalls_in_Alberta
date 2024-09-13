package org.example.project.presentation.add_starfall_feature.viewmodel.intents

import androidx.compose.ui.graphics.ImageBitmap
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.ViewModelAddStarfall
import com.project.astranomapp.presentation.gallery.screen.GalleryScreen
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen

object SaveIntent {
    fun execute(images:MutableList<ImageBitmap>,date:String,location:String){
        for(i in images) {
            ViewModelAddStarfall(StaticDate).date.listGallery.add(i)
            ViewModelAddStarfall(StaticDate).date.listDescription.add(
                "Date:${date}\nLocation:${location}")
        }

        StaticDate.navigator.push(GalleryScreen)
    }
}