package org.example.project.nika_screens_chats.dialog_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import org.example.project.ServiceLocator
import org.example.project.nika_screens_chats.dialog_feature.model.componentMessageNeighbor
import org.example.project.nika_screens_chats.dialog_feature.model.componentMyMessage
import org.example.project.nika_screens_chats.dialog_feature.viewmodel.DialogIntents
import org.example.project.nika_screens_chats.dialog_feature.viewmodel.DialogViewModel
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.add_photo
import starfallsinalberta.composeapp.generated.resources.back
import starfallsinalberta.composeapp.generated.resources.back_
import starfallsinalberta.composeapp.generated.resources.back_button
import starfallsinalberta.composeapp.generated.resources.dots
import starfallsinalberta.composeapp.generated.resources.paperclip
import starfallsinalberta.composeapp.generated.resources.smile
import starfallsinalberta.composeapp.generated.resources.star_logo
import starfallsinalberta.composeapp.generated.resources.user


class DialogScreen : Screen {

    private val vm = DialogViewModel()

    @Composable
    override fun Content() {

        var text by remember { mutableStateOf("") }

        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

            Column(modifier = Modifier.align(Alignment.TopCenter)) {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.back_),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { vm.processIntent(DialogIntents.Back) }
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Image(
                            painter = painterResource(Res.drawable.user),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Text("Название чата", fontSize = 20.sp)
                    }

                    Image(
                        painter = painterResource(Res.drawable.dots),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp).clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        { vm.processIntent(DialogIntents.HistoryFiles) }
                    )

                }

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Spacer(modifier = Modifier.height(15.dp))
                    Box(
                        modifier = Modifier.alpha(0.8f).width(100.dp).height(30.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Сегодня", fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                }


                LazyColumn(
                    modifier = Modifier.padding(10.dp).fillMaxWidth().fillMaxHeight(0.94f)
                ) {
                    items(listOf("")) { item ->
                        componentMyMessage()
                        componentMessageNeighbor()
                    }
                }
            }

            Row(
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.ime),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.LightGray), contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                       /* Image(
                            painter = painterResource(Res.drawable.smile),
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 15.dp,top = 8.dp).size(25.dp)
                        )*/

                        BasicTextField(
                            value = text,
                            onValueChange = { text = it },
                            modifier = Modifier
                                .fillMaxWidth(0.65f).heightIn(min = 33.dp, max = 150.dp),
                            textStyle = TextStyle(fontSize = 18.sp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        )

                        Image(
                            painter = painterResource(Res.drawable.add_photo),
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 15.dp,top = 8.dp).size(22.dp)
                        )

                        Spacer(modifier = Modifier.width(7.dp))

                        Image(
                            painter = painterResource(Res.drawable.paperclip),
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 15.dp,top = 8.dp).size(22.dp).clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            {  }
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Image(
                            painter = painterResource(Res.drawable.back_),
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 15.dp,top = 8.dp).size(25.dp)
                                .graphicsLayer(rotationZ = 180f)
                        )
                    }
                }
            }
        }
    }
}