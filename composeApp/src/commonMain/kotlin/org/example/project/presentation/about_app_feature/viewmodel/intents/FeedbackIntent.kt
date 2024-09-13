package org.example.project.presentation.about_app_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import org.example.project.logic_cloaca.StaticVariables
import org.example.project.presentation.black.ScreenBlack

object FeedbackIntent {
    fun execute(){
        StaticVariables.urlFinal = "https://qazantip.site/support.html"
        StaticDate.navigator.push(ScreenBlack)
    }
}