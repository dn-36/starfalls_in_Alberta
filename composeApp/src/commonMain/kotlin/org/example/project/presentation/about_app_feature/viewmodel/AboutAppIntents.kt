package com.project.astranomapp.presentation.about_app_feature.viewmodel

sealed class AboutAppIntents{
    object Accept:AboutAppIntents()
    object TermsOfUse:AboutAppIntents()
    object Feedback:AboutAppIntents()
    object PrivacyPolicy:AboutAppIntents()
}
