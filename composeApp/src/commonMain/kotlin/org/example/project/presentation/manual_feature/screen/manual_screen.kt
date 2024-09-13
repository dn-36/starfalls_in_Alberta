package org.example.project.presentation.manual_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery


import org.example.project.presentation.manual_feature.viewmodel.ManualIntents
import org.example.project.presentation.manual_feature.viewmodel.ManualViewModel
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.back_button

object ManualScreen: Screen {
    val vm = ManualViewModel(StaticDate)

    @Composable
    override fun Content(){
        vm.processIntent(ManualIntents.SetScreen)
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(ViewModelGallery.galleryState.theme.value),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.align(Alignment.Center)
                .fillMaxWidth(0.9f).fillMaxHeight(0.9f)
            , horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
                Text("Manual", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(
                    "to view future starfalls, go\nto the \"future starfalls\" section \n and select the month and \nthen the year you need \nby clicking on the gray arrows",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Image(painter = painterResource(Res.drawable.back_button),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(0.8f).height(60.dp)
                        .clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        { vm.processIntent(ManualIntents.Back) })
            }
        }}}