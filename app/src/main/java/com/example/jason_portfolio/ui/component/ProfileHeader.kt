package com.example.jason_portfolio.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jason_portfolio.R



@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun ProfileHeader() {


    Image(
        painter = painterResource(R.drawable.jason_photo),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(
                3.dp,
                Color.Black,
                CircleShape
            )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Jason Pham",
        color = Color.Black,
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic
    )

    Text(
        text = "Android Developer",
        color = Color.Green,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )

}








