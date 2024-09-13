package org.example.project.presentation.future_starfall_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.astranomapp.data.StaticDate
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.FutureStarfallIntents
import com.project.astranomapp.presentation.future_starfall_feature.viewmodel.ViewModelFutureStarfall


import org.jetbrains.compose.resources.painterResource
import starfallsinalberta.composeapp.generated.resources.Res
import starfallsinalberta.composeapp.generated.resources.back_button
import starfallsinalberta.composeapp.generated.resources.future_starfall_text
import starfallsinalberta.composeapp.generated.resources.open_calendar


object FutureStarfallScreen:Screen{
    val vm = ViewModelFutureStarfall(StaticDate)
  @Composable
  override fun Content(){

     vm.processIntent(FutureStarfallIntents.SetScreen)
  Box(modifier = Modifier.fillMaxSize()){


      Image(painter = painterResource( ViewModelFutureStarfall.futureStarfallState.theme.value), contentDescription = null,
      modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
      Column(modifier = Modifier
          .align(Alignment.Center)
          .fillMaxWidth(0.8f)
          .fillMaxHeight(0.9f)
      , horizontalAlignment = Alignment.CenterHorizontally
      , verticalArrangement = Arrangement.SpaceBetween) {
          Column(modifier = Modifier.fillMaxHeight(0.7f)
          , verticalArrangement = Arrangement.SpaceBetween) {
              Image(
                  painter = painterResource(Res.drawable.future_starfall_text),
                  contentDescription = null,
                  modifier = Modifier.fillMaxWidth()
              )
              Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
              ) {
                  Column {
                      Text(text = "Month:", color = Color.White, fontSize = 25.sp)
                      Box() {
                          Box(
                              modifier = Modifier
                                  .width(140.dp)
                                  .height(60.dp)
                                  .clip(RoundedCornerShape(20.dp))
                                  .background(Color.White)
                          ) {
                              Image(
                                  painter = painterResource(Res.drawable.open_calendar),
                                  contentDescription = null,
                                  modifier = Modifier
                                      .padding(end = 10.dp)
                                      .size(10.dp)
                                      .align(Alignment.CenterEnd)
                                      .clickable(
                                          indication = null, // Отключение эффекта затемнения
                                          interactionSource = remember { MutableInteractionSource() })
                                      { vm.processIntent(FutureStarfallIntents.OpenCloseMonth) }
                              )
                              Text(
                                  text = "${ViewModelFutureStarfall.futureStarfallState.nowMonth.value}",
                                  color = Color(0xFFB2B2B2),
                                  fontSize = 20.sp,
                                  modifier = Modifier
                                      .padding(start = 10.dp)
                                      .align(Alignment.CenterStart)
                              )
                          }
                          Box(
                              modifier = Modifier
                                  .alpha(ViewModelFutureStarfall.futureStarfallState.alphaMonth.value)
                                  .width(140.dp)
                                  .height(130.dp)
                                  .clip(RoundedCornerShape(20.dp))
                                  .background(Color.White)

                          ) {
                              LazyColumn(modifier = Modifier.padding(start = 10.dp)) {
                                  itemsIndexed(listOf("August","September","October",
                                  "November","December","January","February",
                                      "March","April","May","June","July")) { index, item ->
                                      Text(text = "${item}",
                                          color = Color(0xFFB2B2B2),
                                          fontSize = 20.sp,
                                          modifier = Modifier
                                              .padding(top = 10.dp)
                                              .clickable(
                                                  indication = null, // Отключение эффекта затемнения
                                                  interactionSource = remember { MutableInteractionSource() })
                                              {
                                                  vm.processIntent(
                                                      FutureStarfallIntents.ChooseDate(
                                                          item,
                                                          ViewModelFutureStarfall.futureStarfallState.nowYear.value
                                                      )
                                                  )
                                              })
                                  }
                              }
                              Image(
                                  painter = painterResource(Res.drawable.open_calendar),
                                  contentDescription = null,
                                  modifier = Modifier
                                      .padding(end = 10.dp, top = 25.dp)
                                      .size(10.dp)
                                      .align(Alignment.TopEnd)
                                      .clickable(
                                          indication = null, // Отключение эффекта затемнения
                                          interactionSource = remember { MutableInteractionSource() })
                                      { vm.processIntent(FutureStarfallIntents.OpenCloseMonth) }
                              )
                          }
                      }
                  }
                  Column {
                      Text(text = "Year:", color = Color.White, fontSize = 25.sp)
                      Box(){
                      Box(
                          modifier = Modifier
                              .width(140.dp)
                              .height(60.dp)
                              .clip(RoundedCornerShape(20.dp))
                              .background(Color.White)
                      ){
                          Image(
                              painter = painterResource(Res.drawable.open_calendar),
                              contentDescription = null,
                              modifier = Modifier
                                  .padding(end = 10.dp)
                                  .size(10.dp)
                                  .align(Alignment.CenterEnd)
                                  .clickable(
                                      indication = null, // Отключение эффекта затемнения
                                      interactionSource = remember { MutableInteractionSource() })
                                  { vm.processIntent(FutureStarfallIntents.OpenCloseYear) }
                          )
                          Text(text = "${ViewModelFutureStarfall.futureStarfallState.nowYear.value}", color = Color(0xFFB2B2B2), fontSize = 20.sp
                              , modifier = Modifier
                                  .align(Alignment.CenterStart).padding(start = 10.dp))
                      }
                      Box(
                          modifier = Modifier
                              .alpha(ViewModelFutureStarfall.futureStarfallState.alphaYear.value)
                              .width(140.dp)
                              .height(90.dp)
                              .clip(RoundedCornerShape(20.dp))
                              .background(Color.White)

                      ){
                          Column(modifier = Modifier.padding(start = 10.dp)) {
                              Text(text = "2024",
                                  color = Color(0xFFB2B2B2),
                                  fontSize = 20.sp,
                                  modifier = Modifier
                                      .padding(top = 15.dp)
                                      .clickable(
                                          indication = null, // Отключение эффекта затемнения
                                          interactionSource = remember { MutableInteractionSource() })
                                      {
                                          vm.processIntent(
                                              FutureStarfallIntents.ChooseDate(
                                                  ViewModelFutureStarfall.futureStarfallState.nowMonth.value,
                                                  "2024"
                                              )
                                          )
                                      })
                              Text(text = "2025",
                                  color = Color(0xFFB2B2B2),
                                  fontSize = 20.sp,
                                  modifier = Modifier
                                      .padding(top = 15.dp)
                                      .clickable(
                                          indication = null, // Отключение эффекта затемнения
                                          interactionSource = remember { MutableInteractionSource() })
                                      {
                                          vm.processIntent(
                                              FutureStarfallIntents.ChooseDate(
                                                  ViewModelFutureStarfall.futureStarfallState.nowMonth.value,
                                                  "2025"
                                              )
                                          )
                                      })
                          }
                              Image(
                                  painter = painterResource(Res.drawable.open_calendar),
                                  contentDescription = null,
                                  modifier = Modifier
                                      .padding(end = 10.dp, top = 25.dp)
                                      .size(10.dp)
                                      .align(Alignment.TopEnd)
                                      .clickable(
                                          indication = null, // Отключение эффекта затемнения
                                          interactionSource = remember { MutableInteractionSource() })
                                      { vm.processIntent(FutureStarfallIntents.OpenCloseYear) }
                              )
                          }

                          }
                  }
              }
              if(ViewModelFutureStarfall.futureStarfallState.listFuture.size != 0) {
              LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
                  itemsIndexed(ViewModelFutureStarfall.futureStarfallState.listFuture) { index,item ->
                      Box(
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(top = 20.dp)
                              .height(130.dp)
                              .clip(RoundedCornerShape(20.dp))
                              .background(
                                  Brush.verticalGradient(colors = listOf(
                                      Color(0xFF6789C6),
                                  Color(0xFF062459)
                              ), startY = 10f))
                          , contentAlignment = Alignment.Center
                      ) {
                          Column(modifier = Modifier.align(Alignment.Center)
                              .fillMaxWidth(0.9f)) {
                              Text(
                                  text = "STARFALL ${index + 1}", color = Color.White,
                                  fontSize = 22.sp, fontWeight = FontWeight.Bold
                              )
                              Text(
                                  text = "DATE: ${item.first}", color = Color.White,
                                  fontSize = 22.sp
                              )
                              Text(
                                  text = "Location: ${item.second}", color = Color.White,
                                  fontSize = 22.sp
                              )
                          }
                      }
                  }
              }
          }
              else {
                  Text(
                      text = "${ViewModelFutureStarfall.futureStarfallState.text.value}", color = Color.White,
                      fontSize = 25.sp, textAlign = TextAlign.Center,
                      modifier = Modifier.padding(bottom = 100.dp))
              }
          }
          Image(painter = painterResource(Res.drawable.back_button), contentDescription = null,
          modifier = Modifier.fillMaxWidth(0.8f)
              .clickable(
                  indication = null, // Отключение эффекта затемнения
                  interactionSource = remember { MutableInteractionSource() })
              { vm.processIntent(FutureStarfallIntents.Back) })
      }
  }
  }
}