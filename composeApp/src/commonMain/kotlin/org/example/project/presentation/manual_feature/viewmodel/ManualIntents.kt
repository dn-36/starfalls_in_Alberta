package org.example.project.presentation.manual_feature.viewmodel

sealed class ManualIntents {
    object Back:ManualIntents()
    object SetScreen:ManualIntents()
}