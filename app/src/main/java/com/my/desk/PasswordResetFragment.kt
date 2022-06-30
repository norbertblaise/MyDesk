package com.my.desk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.my.desk.ui.theme.DarkBlueGrey
import com.my.desk.ui.theme.MyDeskTheme
import com.my.desk.ui.theme.Purple100

class PasswordResetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                var emailText by rememberSaveable { mutableStateOf(TextFieldValue("") )}
                MyDeskTheme {
                    Surface(color = Color.White) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(
                                modifier = Modifier
                                    .padding(
                                        horizontal = 16.dp,
                                        vertical = 16.dp
                                    )
                                    .align(Alignment.BottomCenter)
                            ) {
                                Text(
                                    "Reset Password", style = MaterialTheme.typography.h1,
                                    color = DarkBlueGrey
                                )
                                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                                OutlinedTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = emailText,
                                    onValueChange = { emailText = it },
                                    label = { Text("Email") },
                                    singleLine = true,
                                    placeholder = { Text(text = "example@email.com") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        backgroundColor = Purple100,
                                        unfocusedBorderColor = colors.primary
                                    )
                                )
                                Spacer(modifier= Modifier.padding(vertical = 16.dp))

                            }
                        }
                    }
                }
            }
        }
    }
}