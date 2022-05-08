package com.my.desk.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.my.desk.R

// Set of Material typography styles to start with
val openSans = FontFamily(
    Font(R.font.open_sans, weight = FontWeight.Normal),
    Font(R.font.open_sans_semibold, weight = FontWeight.SemiBold),
    Font(R.font.open_sans_bold, weight = FontWeight.Bold)
)

val inter = FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.inter_bold, weight = FontWeight.Bold)
)
val montserrat = FontFamily(
    Font(R.font.montserrat, weight = FontWeight.Normal),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium)
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 39.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    h6 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),

    */
)