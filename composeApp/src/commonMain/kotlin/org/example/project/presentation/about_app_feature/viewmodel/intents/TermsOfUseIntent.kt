package org.example.project.presentation.about_app_feature.viewmodel.intents

import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.create_user_card_feature.screen.CreateUserCardScreen
import org.example.project.logic_cloaca.StaticVariables
import org.example.project.presentation.black.ScreenBlack

object TermsOfUseIntent {
    fun execute(){
        StaticVariables.urlFinal = "https://qazantip.site/terms.html"
        StaticDate.navigator.push(ScreenBlack)
    }
}