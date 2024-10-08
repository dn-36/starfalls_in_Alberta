package com.project.astranomapp.presentation.menu_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.menu_feature.viewmodel.MeniIntents
import com.project.astranomapp.presentation.menu_feature.viewmodel.MenuViewModel

import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.add_starfall_button
import starfallsinalberta.composeapp.generated.resources.future_button
import starfallsinalberta.composeapp.generated.resources.gallery_button
import starfallsinalberta.composeapp.generated.resources.star_logo
import starfallsinalberta.composeapp.generated.resources.starfalls_in_alberta
import starfallsinalberta.composeapp.generated.resources.themes_button


object MenuScreen:Screen{
    val vm = MenuViewModel(StaticDate)
    @Composable
    override fun Content(){
        vm.processIntent(MeniIntents.SetScreen)

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(MenuViewModel.menuState.theme.value), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Column(modifier = Modifier.align(Alignment.Center)
            .fillMaxHeight(0.9f)
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.SpaceAround) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(Res.drawable.star_logo),
                    contentDescription = null,
                    Modifier.size(100.dp)
                )
                Image(
                    painter = painterResource(Res.drawable.starfalls_in_alberta),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(250.dp)
                        .height(110.dp)
                )
            }

            Image(painter = painterResource(Res.drawable.future_button), contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.7f)
                .clickable { vm.processIntent(MeniIntents.FutureStarfall) })
            Image(painter = painterResource(Res.drawable.add_starfall_button), contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.7f)
                    .clickable { vm.processIntent(MeniIntents.AddStarfall) })
            Image(painter = painterResource(Res.drawable.gallery_button), contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.7f)
                    .clickable { vm.processIntent(MeniIntents.Gallery) })
            Image(painter = painterResource(Res.drawable.themes_button), contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.7f)
                    .clickable { vm.processIntent(MeniIntents.Themes) })
        }
        Text("Manual", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold
            , modifier = Modifier.align(Alignment.TopEnd).padding(end = 10.dp,top = 10.dp).clickable { vm.processIntent(MeniIntents.ManualScreen) })
    }
    }
}