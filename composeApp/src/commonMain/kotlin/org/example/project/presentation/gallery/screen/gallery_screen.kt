package com.project.astranomapp.presentation.gallery.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.gallery.viewmodel.GalleryIntents
import com.project.astranomapp.presentation.gallery.viewmodel.ViewModelGallery

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.example.project.core.PhotoSender
import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.back
import starfallsinalberta.composeapp.generated.resources.delete_photo
import starfallsinalberta.composeapp.generated.resources.gallery_text
import starfallsinalberta.composeapp.generated.resources.share_button


object GalleryScreen:Screen{
    val vm = ViewModelGallery(StaticDate)

    @Composable
    override fun Content(){
        vm.processIntent(GalleryIntents.SetScreen)

        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(ViewModelGallery.galleryState.theme.value), contentDescription = null,
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Image(painter = painterResource(Res.drawable.back), contentDescription = null,
        modifier = Modifier
            .alpha(ViewModelGallery.galleryState.alpha.value)
            .padding(top = 30.dp, start = 30.dp)
            .size(50.dp)
            .align(Alignment.TopStart)
            .clickable(
                indication = null, // Отключение эффекта затемнения
                interactionSource = remember { MutableInteractionSource() }) {
                vm.processIntent(GalleryIntents.Back)
            })
            Box(modifier = Modifier.align(Alignment.TopCenter)
                .padding(top = 30.dp)) {
                Image(
                    painter = painterResource(Res.drawable.gallery_text), contentDescription = null,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .alpha(ViewModelGallery.galleryState.alpha.value)
                        .fillMaxWidth(0.5f)
                )
                Text("Select a photo", color = Color.White, fontSize = 28.sp,
                    fontWeight = FontWeight.Bold, modifier = Modifier
                        .alpha(ViewModelGallery.galleryState.alphaSelectPhoto.value))
            }
            Column(modifier = Modifier.align(Alignment.Center)
                .fillMaxHeight(0.6f) ) {

                if (ViewModelGallery.galleryState.listGallery.size != 0) {
                    LazyColumn() {
                        itemsIndexed(ViewModelGallery.galleryState.listGallery.chunked(2)) { indexes,item ->
                            Row(
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(0.6f),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                item.forEachIndexed { index,image ->
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Box() {
                                            Image(
                                                modifier = Modifier
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() })
                                                    { vm.processIntent(GalleryIntents.ChoiceImage("/${image}.png")) }
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
                                            Image(painter = painterResource(Res.drawable.delete_photo),
                                                contentDescription = null,
                                                modifier = Modifier.alpha(ViewModelGallery.galleryState.alpha.value)
                                                    .size(20.dp).align(Alignment.TopEnd)
                                                    .clickable(
                                                        indication = null, // Отключение эффекта затемнения
                                                        interactionSource = remember { MutableInteractionSource() })
                                                    {
                                                        vm.processIntent(
                                                            GalleryIntents.DeletePhoto(
                                                                image,
                                                                indexes * 2 + index
                                                            )
                                                        )
                                                    })
                                        }
                                        Text("${ViewModelGallery.galleryState.listDescription[indexes * 2 + index]}"
                                        , color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                if (item.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }

                        }
                    }
                }
                else {
                    Box(
                        modifier = Modifier
                            .clickable (
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            {vm.processIntent(GalleryIntents.AddStarfall)  }
                            .fillMaxWidth(0.7F)
                            .padding(top = 70.dp)
                            .height(70.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFF5DA6C),
                                        Color(0xFFA98543)
                                    ), startY = 10f
                                )
                            ), contentAlignment = Alignment.Center
                    ){
                        Text("Add a starfall", color = Color.White, fontSize = 25.sp
                        , fontWeight = FontWeight.Bold)
                    }
                }

                }
            Image(painter = painterResource(Res.drawable.share_button), contentDescription = null,
            modifier = Modifier
                .alpha(ViewModelGallery.galleryState.alpha.value)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .fillMaxWidth(0.7f)
                .clickable(
                    indication = null, // Отключение эффекта затемнения
                    interactionSource = remember { MutableInteractionSource() })
                { vm.processIntent(GalleryIntents.Shared) })
        }
    }
}
