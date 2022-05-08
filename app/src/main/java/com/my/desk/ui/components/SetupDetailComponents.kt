package com.my.desk.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.my.desk.R
import com.my.desk.ui.theme.MyDeskTheme
import org.intellij.lang.annotations.JdkConstants
import java.time.format.TextStyle

/**
 * Composable that is displays as the hero image for set up detail fragment
 */

//TODO implement network image fetching
@Composable
fun SetupHeaderCard(setupName: String) {
    Card(
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.desk_image_3),
                    contentDescription = "Post image",
                    modifier = Modifier.clip(
                        RoundedCornerShape(12.dp)
                    )
                )
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = setupName,
                    style = MaterialTheme.typography.subtitle1
                )

                IconButton(
                    onClick = { /*TODO toggle between Favorite and Favorite_0utlined buttons and call like function*/ },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(Icons.Filled.FavoriteBorder, contentDescription = "liked button")
                }
            }
        }
    }
}

@Composable
fun AboutSetup(aboutText: String = "nothing to see here") {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "About", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                aboutText,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun SetupLink(itemName: String, linkValue: String) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //todo open link in browser
                Toast
                    .makeText(context, " link tapped", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "$itemName:",
                style = MaterialTheme.typography.h6
            )

            Text(
                text = linkValue,
                style = MaterialTheme.typography.body1

            )
        }
    }
}

@Preview()
@Composable
fun SetupHeaderCardPreview() {
    val setupName = "Setup name by Jon Doe"
    SetupHeaderCard(setupName)
}

@Preview
@Composable
fun AboutSetupPreview() {
    val placeholderAbout =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Dolor sit scelerisque varius sed netus nam in. Vulputate rhoncus mi eu vel lectus."

    AboutSetup(placeholderAbout)
}

@Preview
@Composable
fun SetupLinkPreview() {
    val itemName = "LED Strip"
    val linkValue = "https://amazon.com/lights"
    SetupLink(itemName, linkValue)
}