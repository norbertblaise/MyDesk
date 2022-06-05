package com.my.desk.ui

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.view.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.my.desk.R
import com.my.desk.ui.theme.DarkBlueGrey
import com.my.desk.ui.theme.MyDeskTheme
import com.my.desk.ui.theme.Purple100
import com.my.desk.ui.theme.inter

class ForgotPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                var emailText by rememberSaveable { mutableStateOf("") }

                MyDeskTheme() {
                    Surface(
                        color = Color.White,
                    ) {
                        Scaffold(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            topBar = {
                                TopAppBar(
                                    elevation = 0.dp,
                                    backgroundColor = MaterialTheme.colors.background,
                                    contentColor = Color.Black,
                                    title = {
                                        Text(text = "Reset Password")
                                    },
                                    navigationIcon = {
                                        IconButton(onClick = {
                                            findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
                                        }) {
                                            Icon(
                                                Icons.Filled.ArrowBack,
                                                contentDescription = "Return to login"
                                            )
                                        }
                                    },
                                )
                            },
                            content = {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text="Enter your Email",
                                        style = TextStyle(
                                            color = DarkBlueGrey, fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = inter

                                        )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    OutlinedTextField(
                                        modifier = Modifier.fillMaxWidth(),
                                        value = emailText,
                                        onValueChange = { emailText = it },
                                        label = { Text(text = "Email") },
                                        singleLine = true,
                                        placeholder = { Text(text = "example@email.com") },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            backgroundColor = Purple100,
                                            unfocusedBorderColor = MaterialTheme.colors.primary
                                        )
                                    )
                                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                    Button(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(44.dp), onClick = { /*TODO*/ }) {
                                        Text(
                                            "Reset Password", color = Color.White,
                                            style = TextStyle(
                                                fontWeight = FontWeight.Normal,
                                                fontFamily = inter
                                            )
                                        )

                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RecoverPass(){
    var emailText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text="Enter your Email",
            style = TextStyle(
                color = DarkBlueGrey, fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = inter

            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text(text = "Email") },
            singleLine = true,
            placeholder = { Text(text = "example@email.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Purple100,
                unfocusedBorderColor = MaterialTheme.colors.primary
            )
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(44.dp), onClick = { /*TODO*/ }) {
            Text(
                "Reset Password", color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = inter
                )
            )

        }
    }
}

@Preview
@Composable
fun RecoverPassPreview(){
    RecoverPass()



































}