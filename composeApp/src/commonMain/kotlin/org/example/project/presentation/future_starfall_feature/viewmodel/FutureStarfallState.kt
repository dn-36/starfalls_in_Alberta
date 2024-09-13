package com.project.astranomapp.presentation.future_starfall_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


import org.jetbrains.compose.resources.DrawableResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund

data class FutureStarfallState(
    val theme: MutableState<DrawableResource> = mutableStateOf(Res.drawable.one_backgraund),
    val alphaMonth: MutableState<Float> = mutableStateOf(0f),
    val alphaYear: MutableState<Float> = mutableStateOf(0f),
    val nowYear: MutableState<String> = mutableStateOf("2024"),
    val nowMonth: MutableState<String> = mutableStateOf("August"),
    val text: MutableState<String> = mutableStateOf("No stargazing is expected this month"),
    val listFuture:MutableList<Pair<String,String>> = mutableListOf()

)
