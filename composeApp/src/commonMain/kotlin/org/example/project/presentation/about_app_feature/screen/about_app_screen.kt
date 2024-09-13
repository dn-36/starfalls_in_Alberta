package org.example.project.presentation.about_app_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.presentation.about_app_feature.viewmodel.AboutAppIntents
import com.project.astranomapp.presentation.about_app_feature.viewmodel.ViewModelAboutApp
import com.project.astranomapp.presentation.gallery.screen.GalleryScreen
import com.project.astranomapp.presentation.gallery.viewmodel.GalleryIntents
import org.jetbrains.compose.resources.painterResource


import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.accept_button
import starfallsinalberta.composeapp.generated.resources.one_backgraund
import starfallsinalberta.composeapp.generated.resources.privacy_policy
import starfallsinalberta.composeapp.generated.resources.text


object AboutAppScreen:Screen{
    val vm = ViewModelAboutApp()
    @Composable
    override fun Content(){

       // val uriHandler = LocalUriHandler.current

        Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(Res.drawable.one_backgraund), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)

        Column(horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceAround
            , modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.9f)
                .fillMaxWidth(0.9f)) {
            Box(
                modifier = Modifier
                    .clickable (
                        indication = null, // Отключение эффекта затемнения
                        interactionSource = remember { MutableInteractionSource() })
                    { GalleryScreen.vm.processIntent(GalleryIntents.AddStarfall)  }
                    .fillMaxWidth(0.6F)
                    .height(60.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF5DA6C),
                                Color(0xFFA98543)
                            ), startY = 50f
                        )
                    ), contentAlignment = Alignment.Center
            ){
                Text("TERMS OF USE", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold
                    , modifier = Modifier.clickable {  vm.processIntents(AboutAppIntents.TermsOfUse) })
            }
            Image(painter = painterResource(Res.drawable.text), contentDescription = null
            , modifier = Modifier.fillMaxHeight(0.5f))
            Box(
                modifier = Modifier
                    .clickable (
                        indication = null, // Отключение эффекта затемнения
                        interactionSource = remember { MutableInteractionSource() })
                    { GalleryScreen.vm.processIntent(GalleryIntents.AddStarfall)  }
                    .fillMaxWidth(0.8F)
                    .height(50.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF5DA6C),
                                Color(0xFFA98543)
                            ), startY = 50f
                        )
                    ), contentAlignment = Alignment.Center
            ){
                Text("FEEDBACK", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold
                    , modifier = Modifier.clickable { vm.processIntents(AboutAppIntents.Feedback)})
            }

            Image(painter = painterResource(Res.drawable.privacy_policy), contentDescription = null
            , modifier = Modifier.fillMaxWidth(0.6f).height(50.dp).clickable {
                    vm.processIntents(AboutAppIntents.PrivacyPolicy)
            })
            Image(painter = painterResource(Res.drawable.accept_button), contentDescription = null
            , modifier = Modifier.fillMaxWidth(0.8f).height(60.dp)
                    .clickable(
                        indication = null, // Отключение эффекта затемнения
                        interactionSource = remember { MutableInteractionSource() })
                    { vm.processIntents(AboutAppIntents.Accept) })
        }
    }
    }
}