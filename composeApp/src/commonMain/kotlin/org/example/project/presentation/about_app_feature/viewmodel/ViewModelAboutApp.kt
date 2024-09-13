package com.project.astranomapp.presentation.about_app_feature.viewmodel

import androidx.lifecycle.ViewModel
import com.project.astranomapp.presentation.about_app_feature.viewmodel.intents.AcceptIntent
import org.example.project.presentation.about_app_feature.viewmodel.intents.FeedbackIntent
import org.example.project.presentation.about_app_feature.viewmodel.intents.PrivacyPolicyIntent
import org.example.project.presentation.about_app_feature.viewmodel.intents.TermsOfUseIntent

class ViewModelAboutApp:ViewModel() {
    fun processIntents(intent: AboutAppIntents){
     when(intent){
         is AboutAppIntents.Accept -> {AcceptIntent.execute()}
         is AboutAppIntents.TermsOfUse -> {TermsOfUseIntent.execute()}
         is AboutAppIntents.Feedback -> {FeedbackIntent.execute()}
         is AboutAppIntents.PrivacyPolicy -> {PrivacyPolicyIntent.execute()}
     }
    }
}