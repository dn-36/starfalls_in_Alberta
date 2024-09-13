package org.example.project.presentation.gallery.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.add_starfall_feature.screen.AddStarfallScreen

object AddStarfallIntent {
    fun execute(){
        StaticDate.navigator.push(AddStarfallScreen)
    }
}