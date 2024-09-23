package com.project.astranomapp.presentation.create_user_card_feature.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.CreateUserCardIntents
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.ViewModelCreateUserCard
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource


import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.create_button
import starfallsinalberta.composeapp.generated.resources.create_user_card_text
import starfallsinalberta.composeapp.generated.resources.one_backgraund


object CreateUserCardScreen:Screen{
    val vm = ViewModelCreateUserCard(StaticDate)
    @Composable
    override fun Content(){
        var name by remember { mutableStateOf("Name") }
        var age by remember { mutableStateOf("18") }
        var placeOfResidents by remember { mutableStateOf("Alberta(Canada)") }
        var observationExperience by remember { mutableStateOf("0") }

        val isVisible by remember { mutableStateOf(Animatable(0f)) }

        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(Res.drawable.one_backgraund), contentDescription = null,
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
Column(modifier = Modifier
    .align(Alignment.Center)
    .fillMaxHeight(0.9f)
, horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.SpaceBetween) {
    Column(modifier = Modifier.fillMaxHeight(0.7f)
    , verticalArrangement = Arrangement.SpaceAround
    , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(Res.drawable.create_user_card_text), contentDescription = null
            , modifier = Modifier.fillMaxWidth(0.7f))

        TextField(value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 20.sp,
                color = Color(0xFF49679B)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {
                Text(
                    "Name", fontSize = 15.sp,
                    color = Color(0xFFBCBBBB)
                )
            })
        TextField(value = age,
            onValueChange = { age = it },
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 20.sp,
                color = Color(0xFF49679B)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {
                Text(
                    "Age", fontSize = 15.sp,
                    color = Color(0xFFBCBBBB)
                )
            })
        TextField(value = placeOfResidents,
            onValueChange = { placeOfResidents = it },
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 20.sp,
                color = Color(0xFF49679B)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = {
                Text(
                    "Place of residence", fontSize = 15.sp,
                    color = Color(0xFFBCBBBB)
                )
            })
        TextField(value = observationExperience,
            onValueChange = { observationExperience = it },
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(15.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 20.sp,
                color = Color(0xFF49679B)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = {
                Text(
                    "Observation experience", fontSize = 15.sp,
                    color = Color(0xFFBCBBBB)
                )
            })
    }
    Image(painter = painterResource(Res.drawable.create_button), contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.35f)
            .clickable (
                indication = null, // Отключение эффекта затемнения
                interactionSource = remember { MutableInteractionSource() })
            { vm.processIntent(CreateUserCardIntents.Create(name,age,placeOfResidents,observationExperience)) })

    if(ViewModelCreateUserCard.createUserCardState.toast.value) {
        LaunchedEffect(key1 = true) {
            //delay(500)
            isVisible.animateTo(
                targetValue = 1f
            )

            delay(1000) // видимость на 1 секунду
            isVisible.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = LinearEasing
                ) // плавное исчезновение

            )
            vm.processIntent(CreateUserCardIntents.Toast)
        }

    }
}
            Box(modifier = Modifier
                .padding(bottom = 150.dp)
                .clip(RoundedCornerShape(15.dp))
                .alpha(isVisible.value)
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .width(250.dp).height(50.dp)
                .border(width = 2.dp,
                    color = Color(0xFFF5D56D),
                    shape = RoundedCornerShape(15.dp))
                ,
                contentAlignment = Alignment.Center) {
                Text("fill in all the fields", fontSize = 15.sp,
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
    }
}