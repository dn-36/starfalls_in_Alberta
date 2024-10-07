package org.example.project.nika_screens_chats.list_dialog_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.project.astranomapp.data.StaticDate
import org.example.project.nika_screens_chats.list_dialog_feature.model.listDialogItem
import org.example.project.nika_screens_chats.list_dialog_feature.viewmodel.ListDialogIntents
import org.example.project.nika_screens_chats.list_dialog_feature.viewmodel.ListDialogViewModel
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.plus
import starfallsinalberta.composeapp.generated.resources.star_logo


class ListDialogScreen : Screen {

    private val vm = ListDialogViewModel()

    @Composable
    override fun Content() {

        StaticDate.navigator =  LocalNavigator.currentOrThrow

        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

            Column(modifier = Modifier.align(Alignment.TopCenter).padding(16.dp)) {
                Text("Чаты", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(listOf("")) { item ->
                        listDialogItem(vm)
                    }
                }
            }
            Image(painter = painterResource(Res.drawable.plus),contentDescription = null,
                modifier = Modifier.padding(16.dp).size(60.dp).align(Alignment.BottomEnd).clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { vm.processIntent(ListDialogIntents.AddChat) })
        }
    }
}