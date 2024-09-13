package com.project.astranomapp.presentation.future_starfall_feature.viewmodel

sealed class FutureStarfallIntents{
object SetScreen:FutureStarfallIntents()
object Back:FutureStarfallIntents()
object OpenCloseMonth:FutureStarfallIntents()
object OpenCloseYear:FutureStarfallIntents()
data class ChooseDate(val month:String,val year:String):FutureStarfallIntents()
}
