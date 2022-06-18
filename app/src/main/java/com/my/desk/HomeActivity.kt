package com.my.desk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.composethemeadapter.MdcTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.my.desk.ui.theme.MyDeskTheme

class HomeActivity : ComponentActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var loggedUser: FirebaseUser

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                elevation = 0.dp,
                                backgroundColor = MaterialTheme.colors.background,
                                contentColor = MaterialTheme.colors.primary,
                                title = { Text(text = "My Desk") },
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(Icons.Filled.Add, contentDescription = "")
                                    }
                                }
                            )
                        },
                        content = {
                            Column {
                                Text(text = "Featured", fontSize = 20.sp)
                                Image(
                                    painter = painterResource(id = R.drawable.desk_image_1),
                                    contentDescription = ""
                                )
                                Text(text = "Popular", fontSize = 20.sp)


                            }
                        },
                    )
                }
            }
        }
    }
}

