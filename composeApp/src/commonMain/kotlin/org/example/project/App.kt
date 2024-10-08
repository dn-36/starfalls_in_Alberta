package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.project.nika_screens_chats.list_dialog_feature.screen.ListDialogScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.example.project.presentation.navigator

@Composable
@Preview
fun App() {
    MaterialTheme {
        navigator()
    }
}

data class Contact(
    val id: String,
    val name: String,
    var phoneNumber: String
)

interface ContactProvider{
    fun getAllContacts(): List<Contact>
}

