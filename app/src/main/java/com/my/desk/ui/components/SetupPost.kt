package com.my.desk.ui.components

import com.my.desk.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController

@Composable
fun SetupPostCard() {
    val context = LocalContext.current
    Card(shape = RoundedCornerShape(12.dp),
//    onClick = {
////        NavHostFragment.findNavController(this).navigate(R.id.action_FeedFragment_to_SetupDetailFragment)
//    }
    ) {
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
                        Spacer(modifier = Modifier.padding(start = 4.dp))
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