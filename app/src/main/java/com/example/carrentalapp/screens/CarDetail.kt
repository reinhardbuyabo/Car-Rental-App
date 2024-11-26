package com.example.carrentalapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentalapp.data.fetchAll

@Composable
fun Detail(id:Int)
{
    val idDetail = fetchAll().firstOrNull{it.id==id}
    val scrollState= rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)

    )
    {
        Row ( modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 10.dp)){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)

            }
            Spacer(modifier = Modifier.weight(1f))

            Text(text = "Map", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W800,
                fontFamily = FontFamily.Monospace,
                color = Color.White

            ),
                modifier = Modifier.padding(top = 13.dp, end = 15.dp)
            )

        }
        Spacer(modifier = Modifier.height(40.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
            .clip(RoundedCornerShape(25.dp))) {
            Box (modifier = Modifier.fillMaxSize()){
                if(idDetail!=null) {
                    Image(painter = painterResource(id = idDetail.image), contentDescription = null)
                }

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        if(idDetail!=null) {

            Text(
                text = "${idDetail.name}", style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White

                ),
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "${idDetail?.info}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.Monospace,
                color = Color.White

            ),
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

