package org.example.project.presentation.select_theme_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.select_theme_feature.viewmodel.SelectThemeIntents
import com.project.astranomapp.presentation.select_theme_feature.viewmodel.ViewModelSelectTheme

import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.back
import starfallsinalberta.composeapp.generated.resources.four_backgraund
import starfallsinalberta.composeapp.generated.resources.one_backgraund
import starfallsinalberta.composeapp.generated.resources.select_theme_text
import starfallsinalberta.composeapp.generated.resources.selected_theme
import starfallsinalberta.composeapp.generated.resources.three_backgraund
import starfallsinalberta.composeapp.generated.resources.two_backgraund


object SelectThemeScreen:Screen{
    var vm = ViewModelSelectTheme(StaticDate)
    @Composable
    override fun Content(){
        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(ViewModelSelectTheme.selectedThemeState.theme.value), contentDescription = null,
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
            Column(modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.TopCenter)
                .fillMaxHeight(0.7f)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceBetween) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                , horizontalArrangement = Arrangement.Start
                , verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(Res.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }) {
                                vm.processIntent(SelectThemeIntents.Back)
                            }
                    )
                    Image(
                        painter = painterResource(Res.drawable.select_theme_text),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)

                    )
                }
                Column() {
                    Row( modifier = Modifier
                        .fillMaxWidth(0.65f),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Box(contentAlignment = Alignment.Center
                        , modifier = Modifier.clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }) {
                            vm.processIntent(SelectThemeIntents.ChoosingTheme(0))
                            }) {
                            Image(
                                painter = painterResource(Res.drawable.one_backgraund),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(25.dp))
                                    .border(
                                        color = Color.White,
                                        width = 2.dp,
                                        shape = RoundedCornerShape(25.dp)
                                    )
                                    .width(120.dp)
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Image(painter = painterResource(Res.drawable.selected_theme), contentDescription = null,
                                modifier = Modifier.size(30.dp).alpha(ViewModelSelectTheme.selectedThemeState.alphaSelectedThem[0]))
                        }
                        Box(contentAlignment = Alignment.Center
                            , modifier = Modifier.clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }){
                                vm.processIntent(SelectThemeIntents.ChoosingTheme(1))
                            }) {
                            Image(
                                painter = painterResource(Res.drawable.two_backgraund),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(25.dp))
                                    .border(
                                        color = Color.White,
                                        width = 2.dp,
                                        shape = RoundedCornerShape(25.dp)
                                    )
                                    .width(120.dp)
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Image(painter = painterResource(Res.drawable.selected_theme), contentDescription = null,
                                modifier = Modifier.size(30.dp).alpha(ViewModelSelectTheme.selectedThemeState.alphaSelectedThem[1]))
                        }
                    }
                    Row( modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(0.65f),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Box(contentAlignment = Alignment.Center
                            , modifier = Modifier.clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }) {
                                vm.processIntent(SelectThemeIntents.ChoosingTheme(2))
                            }) {
                            Image(
                                painter = painterResource(Res.drawable.three_backgraund),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(25.dp))
                                    .border(
                                        color = Color.White,
                                        width = 2.dp,
                                        shape = RoundedCornerShape(25.dp)
                                    )
                                    .width(120.dp)
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Image(painter = painterResource(Res.drawable.selected_theme), contentDescription = null,
                                modifier = Modifier.size(30.dp).alpha(ViewModelSelectTheme.selectedThemeState.alphaSelectedThem[2]))
                        }
                        Box(contentAlignment = Alignment.Center
                            , modifier = Modifier.clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() }) {
                                vm.processIntent(SelectThemeIntents.ChoosingTheme(3))
                            }){
                            Image(painter = painterResource(Res.drawable.four_backgraund), contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(25.dp))
                                    .border(
                                        color = Color.White,
                                        width = 2.dp,
                                        shape = RoundedCornerShape(25.dp)
                                    )
                                    .width(120.dp)
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds)
                            Image(painter = painterResource(Res.drawable.selected_theme), contentDescription = null,
                            modifier = Modifier.size(30.dp).alpha(ViewModelSelectTheme.selectedThemeState.alphaSelectedThem[3]))
                        }
                    }
                }
            }
        }
    }
}