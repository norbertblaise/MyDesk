package com.my.desk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.my.desk.ui.components.LogoedButton
import com.my.desk.ui.theme.DarkBlueGrey
import com.my.desk.ui.theme.MyDeskTheme
import com.my.desk.ui.theme.Purple100
import com.my.desk.ui.theme.inter

class SignUpFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                var nameText by remember { mutableStateOf(TextFieldValue("")) }
                var emailText by remember { mutableStateOf(TextFieldValue("")) }
                var password by remember { mutableStateOf(TextFieldValue("")) }
                var passwordHidden by rememberSaveable { mutableStateOf(true) }

                val annotatedLogin = buildAnnotatedString {
                    append("Login")
                }

                MyDeskTheme {
                    Surface(color = Color.White) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(
                                modifier = Modifier
                                    .padding(
                                        horizontal = 16.dp
                                    )
                                    .align(alignment = Alignment.BottomCenter)
                            ) {
                                Text(
                                    "Register", style = MaterialTheme.typography.h1,
                                    color = DarkBlueGrey
                                )
                                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                                OutlinedTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = nameText,
                                    onValueChange = { nameText = it },
                                    label = { Text(text = "Name") },
                                    singleLine = true,
                                    placeholder = { Text(text = "Jon Snow") },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        backgroundColor = Purple100,
                                        unfocusedBorderColor = MaterialTheme.colors.primary
                                    )
                                )

                                Spacer(modifier = Modifier.padding(vertical = 6.dp))
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

                                Spacer(modifier = Modifier.padding(vertical = 6.dp))

                                OutlinedTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = password, onValueChange = { password = it },
                                    label = { Text("Password") },
                                    singleLine = true,
                                    visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                    trailingIcon = {
                                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                            val visibilityIcon =
                                                if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                                            val description =
                                                if (passwordHidden) "Show Password" else "Hide Password"
                                            Icon(imageVector = visibilityIcon, contentDescription = description)
                                        }
                                    },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        backgroundColor = Purple100,
                                        unfocusedBorderColor = MaterialTheme.colors.primary
                                    )
                                )

                                Spacer(modifier = Modifier.padding(vertical = 4.dp))

                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Button(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp), onClick = { /*TODO initial sign up*/ }) {
                                    Text(
                                        "Sign Up", color = Color.White,
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = inter
                                        )
                                    )

                                }
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "Or Continue with", style = TextStyle(
                                            color = MaterialTheme.colors.primary, fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal,
                                            fontFamily = inter

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                LogoedButton(
                                    logo = R.drawable.google_logo,
                                    backgroundColor = DarkBlueGrey,
                                    label = "Google",
                                    onClick = {/*todo run google login*/ }
                                )
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Row(modifier = Modifier.padding(bottom = 16.dp)) {

                                    Text(
                                        text = "Already have an Account? ",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal,
                                            fontFamily = inter
                                        )
                                    )
                                    ClickableText(
                                        onClick = {
                                            //todo go to sign in page
                                                  findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                                        },
                                        text = annotatedLogin, style = TextStyle(
                                            color = MaterialTheme.colors.primary, fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = inter

                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpForm() {

}


@Preview(showBackground = true)
@Composable
fun PreviewSignUpForm() {
    SignUpForm()
}