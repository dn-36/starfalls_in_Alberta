package com.project.astranomapp.presentation.future_starfall_feature.viewmodel.intents

import androidx.compose.runtime.mutableStateOf
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.ViewModelFutureStarfall

object ChooseDateIntent {
    fun execute(month:String,year:String){

        ViewModelFutureStarfall.futureStarfallState =
            ViewModelFutureStarfall.futureStarfallState.copy(
                nowMonth = mutableStateOf(month),
                nowYear = mutableStateOf(year),
                alphaYear = mutableStateOf(0f),
                alphaMonth = mutableStateOf(0f)
            )
        if(year == "2024") {
            when (month ) {
                "January" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                    text = mutableStateOf("This month has already passed this year")
                    )}
                "February" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "March" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "April" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "May" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "June" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "July" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("This month has already passed this year"))}
                "August" ->  { ViewModelFutureStarfall.futureStarfallState =
                    ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("No stargazing is expected this month"))}
                "September" ->  { ViewModelFutureStarfall.futureStarfallState =
                    ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("No stargazing is expected this month"))}
                "October" ->  { ViewModelFutureStarfall.futureStarfallState =
                    ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("21-22 October 2024","Alberta(Canada)")))}
                "November" ->  { ViewModelFutureStarfall.futureStarfallState =
                    ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("17-18 November 2024","Alberta(Canada)")))}
                "December" ->  { ViewModelFutureStarfall.futureStarfallState =
                    ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("14-15 December 2024","Alberta(Canada)"),
                            Pair("22-23 December 2024","Alberta(Canada)")))}
            }
        }
        else if(year == "2025") {
            when (month) {
                "January" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                            listFuture = mutableListOf(Pair("3-4 January 2025","Alberta(Canada)")))}
                "February" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("No stargazing is expected this month"))}
                "March" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("20 March 2025","Alberta(Canada)")))}
                "April" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("21-22 April 2025","Alberta(Canada)")))}
                "May" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("5-6 May 2025","Alberta(Canada)")))}
                "June" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("21 June 2025","Alberta(Canada)")))}
                "July" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(),
                        text = mutableStateOf("No stargazing is expected this month"))}
                "August" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("12-13 August 2025","Alberta(Canada)")))}
                "September" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf( Pair("23 September 2025","Alberta(Canada)")))}
                "October" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("21-22 October 2025","Alberta(Canada)")))}
                "November" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("17-18 November 2025","Alberta(Canada)")))}
                "December" -> {
                    ViewModelFutureStarfall.futureStarfallState = ViewModelFutureStarfall.futureStarfallState.copy(
                        listFuture = mutableListOf(Pair("22 December 2025","Alberta(Canada)")))}

            }
        }
    }
}