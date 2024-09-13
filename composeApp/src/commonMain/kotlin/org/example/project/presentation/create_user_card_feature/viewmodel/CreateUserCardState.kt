package com.project.astranomapp.presentation.create_user_card_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CreateUserCardState(
    val toast:MutableState<Boolean> = mutableStateOf(false)
)
