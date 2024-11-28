package com.example.carrentalapp.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentalapp.data.carData
import com.example.carrentalapp.data.fetchAll

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
                }
                Spacer(modifier = Modifier.weight(0.6f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.White)
                }
                Text(text = "Nairobi", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W900,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White

                ),
                    modifier = Modifier.padding(top = 13.dp, end = 10.dp)
                )
            }
            Row( modifier = Modifier.padding(top = 30.dp)) {
                Text(text = "Your Ideal\nCar Awaits", style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.W900,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White

                ),
                    modifier = Modifier.padding(top = 13.dp, start = 15.dp)
                )
                Spacer(modifier = Modifier.weight(0.6f))

                Box(
                    modifier = Modifier
                        .size(width = 150.dp, height = 70.dp)
                        .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                        .background(Color(0xFF4B4141))
                        .padding(top = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Search, contentDescription = null, tint = Color.White, modifier = Modifier
                            .size(50.dp, 50.dp)
                            .padding(bottom = 13.dp))
                    }
                }
            }

            LazyColumn(modifier = Modifier.padding(top = 30.dp)) {
                val myList= fetchAll()
                itemsIndexed(myList, itemContent = {index, item ->
                    lazyColumnItem(item = item, onClick = {
                        navController.navigate("detail/${item.id}")
                    })

                })
            }
        }
    }
}

@Composable
fun lazyColumnItem(item: carData,onClick: ()->Unit){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
        .clip(RoundedCornerShape(25.dp))
        .clickable { onClick() }
    ) {



        Image(painter = painterResource(id = item.image), contentDescription =null, contentScale = ContentScale.Crop,modifier = Modifier.offset(y = -70.dp))

        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = 0f,
                    endY = 390f
                )
            ))
        Box(modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.BottomStart) {

            Column {
                Row {
                    Text(text = "${item.name}", style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White

                    ),
                        modifier = Modifier.padding(start = 20.dp)
                    )

                }
                Row {
                    Text(text = "${item.quality}", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White

                    ),
                        modifier = Modifier.padding(start = 20.dp,top = 13.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = "${item.price}", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        fontFamily = FontFamily.Monospace,
                        color = Color.White

                    ),
                        modifier = Modifier.padding(top = 13.dp, end = 15.dp)
                    )
                }
            }
        }
    }
}