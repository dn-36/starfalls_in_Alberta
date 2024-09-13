package org.example.project.presentation.add_starfall_feature.screen

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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import com.preat.peekaboo.ui.camera.rememberPeekabooCameraState
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.AddStarfallIntents
import com.project.astranomapp.presentation.add_starfall_feature.viewmodel.ViewModelAddStarfall
import com.project.astranomapp.presentation.create_user_card_feature.screen.CreateUserCardScreen
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.CreateUserCardIntents
import com.project.astranomapp.presentation.create_user_card_feature.viewmodel.ViewModelCreateUserCard
import org.jetbrains.compose.resources.painterResource

import kotlinx.coroutines.delay

import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.add_photos_button
import starfallsinalberta.composeapp.generated.resources.add_strfall_text
import starfallsinalberta.composeapp.generated.resources.back
import starfallsinalberta.composeapp.generated.resources.delete_photo
import starfallsinalberta.composeapp.generated.resources.save_button


object AddStarfallScreen:Screen{
    val vm = ViewModelAddStarfall(StaticDate)
    @Composable
    override fun Content(){
        vm.processIntents(AddStarfallIntents.SetScreen)

        val isVisible by remember { mutableStateOf(Animatable(0f)) }


        var date by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }

        //
        val scope = rememberCoroutineScope()

        val images = remember { mutableStateListOf<ImageBitmap>() }

        val cameraState = rememberPeekabooCameraState(
            onCapture = { bytes ->
                bytes?.toImageBitmap()?.let {
                    images += it
                }
            }
        )

        val singleImagePicker = rememberImagePickerLauncher(
            scope = scope,
            selectionMode = SelectionMode.Single,
            onResult = { byteArrays ->
                byteArrays.firstOrNull()?.let {
                    images += it.toImageBitmap()
                }
            }
        )

        val multipleImagePicker = rememberImagePickerLauncher(
            scope = scope,
            selectionMode = SelectionMode.Multiple(),
            onResult = { byteArrays ->
                images += byteArrays.map {
                    it.toImageBitmap()
                }
            }
        )

        var showCamera by remember { mutableStateOf(false) }

        //
        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(ViewModelAddStarfall.addStarfallState.theme.value), contentDescription = null,
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
            Column(modifier = Modifier.align(Alignment.Center)
                .fillMaxHeight(0.9f)
                .fillMaxWidth(0.9f)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.SpaceBetween) {
                Column(horizontalAlignment = Alignment.CenterHorizontally
                , modifier = Modifier.fillMaxHeight(0.45f)
                , verticalArrangement = Arrangement.SpaceBetween) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.back),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                                .clickable(
                                    indication = null, // Отключение эффекта затемнения
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    vm.processIntents(AddStarfallIntents.Back)
                                }
                        )
                        Image(
                            painter = painterResource(Res.drawable.add_strfall_text),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    TextField(value = date,
                        onValueChange = { date = it },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(60.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = Color.Transparent
                        ),
                        textStyle = TextStyle(fontSize = 20.sp, color = Color(0xFF49679B)),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {
                            Text(
                                "Date", fontSize = 15.sp,
                                color = Color(0xFFBCBBBB)
                            )
                        })
                    TextField(value = location,
                        onValueChange = { location = it },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(60.dp)
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
                                "Location", fontSize = 15.sp,
                                color = Color(0xFFBCBBBB)
                            )
                        })
                    TextField(value = description,
                        onValueChange = { description = it },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(100.dp)
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
                                "Description", fontSize = 15.sp,
                                color = Color(0xFFBCBBBB)
                            )
                        })
                }
               LazyRow() {
                    items(images) { image ->
                        Box() {
                            Image(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .width(100.dp)
                                    .height(170.dp)
                                    .clip(RoundedCornerShape(25.dp))
                                    .border(
                                        width = 2.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(25.dp)
                                    ),
                                bitmap = image,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                            Image(painter = painterResource(Res.drawable.delete_photo), contentDescription = null,
                                modifier = Modifier.size(20.dp).align(Alignment.TopEnd)
                                    .clickable(
                                        indication = null, // Отключение эффекта затемнения
                                        interactionSource = remember { MutableInteractionSource() })
                                    { images.remove(image) })
                        }
                    }
                }
                Column() {
                Image(painter = painterResource(Res.drawable.add_photos_button), contentDescription = null,
                 modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 15.dp).height(60.dp).clickable(
                     indication = null, // Отключение эффекта затемнения
                     interactionSource = remember { MutableInteractionSource() }) {
                     if(images.size <= 5) {
                         multipleImagePicker.launch()
                     }
                     else{
                     ViewModelAddStarfall.addStarfallState.toast.value = true
                     }
                    //StaticDate.cameraHandler.openCamera {}
                 } )
                    Image(painter = painterResource(Res.drawable.save_button), contentDescription = null,
                        modifier = Modifier.fillMaxWidth(0.8f).height(60.dp)
                            .clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource()})
                            { if(images.size <= 6) {
                                vm.processIntents(AddStarfallIntents.Save(images,date,location))
                            }
                                else{
                                ViewModelAddStarfall.addStarfallState.toast.value = true
                                }

                            })
                }
            }
            if(ViewModelAddStarfall.addStarfallState.toast.value) {
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
                    vm.processIntents(AddStarfallIntents.Toast)
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
                Text("You can add no more \n than six photos", fontSize = 15.sp,
                    color = Color.Black, textAlign = TextAlign.Center
                )
            }
        }
    }
}