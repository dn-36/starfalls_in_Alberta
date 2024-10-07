package org.example.project.nika_screens_chats.list_dialog_feature.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.nika_screens_chats.list_dialog_feature.viewmodel.ListDialogIntents
import org.example.project.nika_screens_chats.list_dialog_feature.viewmodel.ListDialogViewModel
import org.example.project.presentation.manual_feature.screen.ManualScreen
import org.example.project.presentation.manual_feature.viewmodel.ManualIntents
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.star_logo
import starfallsinalberta.composeapp.generated.resources.user

@Composable
fun listDialogItem(vm : ListDialogViewModel){
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp).clickable(
        indication = null, // Отключение эффекта затемнения
        interactionSource = remember { MutableInteractionSource() })
    { vm.processIntent(ListDialogIntents.DialogueSelection) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(Res.drawable.user),contentDescription = null,
            modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.height(60.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Text("Название чата", fontSize = 18.sp)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    "последнее сообщение",
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
                Text(
                    "13:40",
                    fontSize = 13.sp,
                    color = Color.LightGray
                )
            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp)
                .background(Color.LightGray))
        }
    }
}