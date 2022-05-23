package com.my.desk.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.my.desk.ui.theme.DarkBlueGrey
import com.my.desk.ui.theme.inter

@Composable
fun LogoedButton(
    logo: Int,
    backgroundColor: Color,
    label: String,
    onClick: () -> Unit
){
    Button(modifier = Modifier
        .fillMaxWidth()
        .height(44.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        onClick = onClick) {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(logo),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(4.dp))

            Text(
                label, color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = inter
                )
            )
        }

    }
}