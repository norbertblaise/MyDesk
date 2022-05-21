package com.my.desk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.my.desk.databinding.FragmentSetupDetailBinding
import com.my.desk.ui.components.AboutSetup
import com.my.desk.ui.components.SetupHeaderCard


class DeskSetupFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            navigationIcon = {
                                IconButton(onClick = { findNavController().navigate(R.id.action_addSetupFragment_to_FeedFragment) }) {
                                    Icon(
                                        Icons.Outlined.ArrowBack,
                                        contentDescription = "back button",
                                        tint = Color.Black
                                    )
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
                        SetupHeaderCard(setupName = "Baller black desk")
                        Spacer(modifier = Modifier.height(24.dp))
                        AboutSetup()
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Links", style = MaterialTheme.typography.subtitle1)
                        Spacer(modifier = Modifier.height(8.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            SetupLink()
                            SetupLink()
                            SetupLink()
                            SetupLink()
                            SetupLink()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                )
            }
        }

    }
}