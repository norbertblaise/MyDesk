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
import com.my.desk.ui.theme.MyDeskTheme

class HomeActivity : ComponentActivity() {
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


@Composable
fun SetupPostCard() {
    Card(shape = RoundedCornerShape(12.dp)) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.desk_image_2),
                contentDescription = "Post image",
                modifier = Modifier.clip(
                    RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
            )
            Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 18.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = "Setup name by Jon Doe",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row{
                        Text(text = "300 likes",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                        IconButton(
                            onClick = { /*TODO toggle between Favorite and Favorite_0utlined buttons and call like function*/ },
                            modifier = Modifier.size(20.dp)
                        ) {
                            Icon(Icons.Filled.FavoriteBorder, contentDescription = "liked button")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Dolor sit scelerisque varius sed netus nam in. Vulputate rhoncus mi eu vel lectus.",
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 3,
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SetupPostCardPreview() {
    SetupPostCard()
}
