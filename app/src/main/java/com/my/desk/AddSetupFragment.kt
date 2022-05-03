package com.my.desk

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.findNavController
import com.google.android.material.composethemeadapter.MdcTheme


class AddSetupFragment : Fragment() {
    var pageName = "Submit Yours"
    var linkCount: List<Int> = listOf(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val confirmSubmitItem = menu.findItem(R.id.action_confirm_submission)
        val newSubmitItem = menu.findItem(R.id.action_create_new_submission)

        confirmSubmitItem.isVisible
        newSubmitItem.isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        ComposeView(requireContext()).apply {
            setContent {
                MdcTheme {
                    Scaffold(topBar = {
                        TopAppBar(
                            navigationIcon = {
                                IconButton(onClick = { findNavController().navigate(R.id.action_addSetupFragment_to_FeedFragment) },) {
Icon(Icons.Outlined.ArrowBack, contentDescription = "back button", tint =  Color.Black)
                                }
                            },
                            elevation = 0.dp,
                            backgroundColor = MaterialTheme.colors.background,
                            contentColor = Color.Black,
                            title = { Text(text = "Add Setup") },
                            actions = {
                                IconButton(onClick = { /*TODO*/
                                }) {
                                    Icon(Icons.Filled.Check, contentDescription = "")
                                }
                            }
                        )
                    },
                        content = {
                            AddMySetup()
                        })

                }
            }
        }
}

@Composable
fun AddMySetup() {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 16.dp, end = 8.dp)
            .fillMaxWidth()

    ) {
        var linkCount by remember { mutableStateOf(0) }
        //todo create body composable
        AddSetupImages()
        Spacer(modifier = Modifier.height(16.dp))
        AddSetupDescription(onPlusClicked = { linkCount++ })

        SetupLinks(linkCount)

    }
}

@Composable
fun AddSetupImages() {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Add some Pics", fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            LazyRow {
                //TODO add image  from list here
            }
            Card(
                border = BorderStroke(
                    width = 7.dp,
                    color = MaterialTheme.colors.primary
                ),
            ) {
                Icon(
                    Icons.Filled.AddCircle, contentDescription = "add new image",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}

@Composable
fun AddSetupDescription(onPlusClicked: () -> Unit) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            text = " Description", fontSize = 20.sp,
            textAlign = TextAlign.Left,
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        var nameText by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(value = nameText,
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                nameText = it
            })

        var descText by remember { mutableStateOf(TextFieldValue("")) }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = descText,
            label = { Text(text = "Description") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                descText = it
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Links", fontSize = 20.sp,
            )
            IconButton(onClick = onPlusClicked) {
                Icon(
                    Icons.Outlined.Add,
                    contentDescription = "add link button",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

    }
}

@Composable
fun SetupLink() {
    Row {
        var nameText by remember { mutableStateOf(TextFieldValue("")) }
        var urlText by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(value = nameText,
            label = { Text(text = "Item") },
            onValueChange = {
                nameText = it
            })
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(value = urlText,
            label = { Text(text = "url") },
            onValueChange = {
                urlText = it
            })
    }
}

@Composable
fun SetupLinks(numLinks: Int) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {

//        for (link in 0 until numLinks) {
//            SetupLink()
//        }
        items(numLinks) {
            SetupLink()
        }
    }
}


@Composable
fun AddSetupFormPreview() {
    AddSetupImages()

}

@Preview(showBackground = true)
@Composable
fun AddMySetupPreview() {
    AddMySetup()
}

@Composable
fun AddSetupDescriptionPreview() {
    var linkCount = 1
    AddSetupDescription(onPlusClicked = { linkCount++ })
}

//todo create custom image composable here
