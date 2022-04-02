package com.my.desk

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding



@Composable
fun SubmitPageTopAppBar(
    title: @Composable () -> Unit,
    modifier:Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.()-> Unit = {},
    backgroundColor: Color = Color.Transparent,
    contentColor:Color =contentColorFor(backgroundColor),
    elevation: Dp =0.dp,
) {
    androidx.compose.material.Surface(
color = backgroundColor,
elevation = elevation,
        modifier = modifier
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            backgroundColor = Color.Transparent,
contentColor = contentColor,
modifier = Modifier
    .statusBarsPadding()
    .navigationBarsPadding(bottom = false)
        )

    }
}



