package com.project.astranomapp.presentation.create_user_card_feature.viewmodel.intents

import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.ViewModelCreateUserCard

object ToastIntent {
    fun execute(){
        ViewModelCreateUserCard.createUserCardState.toast.value = false
    }
}