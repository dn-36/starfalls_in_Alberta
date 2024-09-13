package org.example.project.presentation.manual_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import org.jetbrains.compose.resources.DrawableResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund

data class ManualState(
    val theme: MutableState<DrawableResource> = mutableStateOf(Res.drawable.one_backgraund)

)
