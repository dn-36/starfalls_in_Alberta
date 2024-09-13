package org.example.project.presentation.main_screen_feature.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.main_screen_feature.viewmodel.ViewModelMain

import kotlinx.coroutines.delay

import org.example.project.logic_cloaca.answer
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.one_backgraund
import starfallsinalberta.composeapp.generated.resources.star_logo
import starfallsinalberta.composeapp.generated.resources.starfalls_in_alberta


object MainScreen:Screen{
    val vm = ViewModelMain(StaticDate)

   // var goToStartState = true

    @Composable
   override fun Content(){

        StaticDate.navigator =  LocalNavigator.currentOrThrow


        /*if (MainScreen.goToStartState) {
            MainScreen.goToStartState = false
            if (StaticVariables.status == Status.WHITE) {
                StaticDate.navigator.push(AboutAppScreen)
            } else {
                StaticDate.navigator.push(ScreenBlack)
            }
        }*/


        var progress by remember { mutableStateOf(0f) }

        // Анимация изменения значения progress от 0 до 1f за 3 секунды
        val animatedProgress by animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(durationMillis = 3000) // 3000 миллисекунд = 3 секунды
        )

        LaunchedEffect(Unit) {
            // Задержка для запуска анимации
            delay(500)
            progress = 1f
            delay(3000)
      answer() // Установка значения в 1f для завершения прогресс бара
        }
        Box(modifier = Modifier.fillMaxSize()){
Image(painter = painterResource(Res.drawable.one_backgraund), contentDescription = null,
modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
            Column(modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(0.8f)
                .align(Alignment.Center)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(painter = painterResource(Res.drawable.star_logo) , contentDescription = null
                        ,Modifier.size(100.dp))
                    Image(painter = painterResource(Res.drawable.starfalls_in_alberta), contentDescription = null
                        , modifier = Modifier
                            .padding(top = 10.dp)
                            .width(250.dp)
                            .height(110.dp))
                }

                LinearProgressIndicator(progress = animatedProgress,
                color = Color(0xFFD9B45E),
                backgroundColor = Color(0xFF375485),
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth(0.8f)
                        .clip(RoundedCornerShape(25.dp))
                )
            }
        }
    }
}