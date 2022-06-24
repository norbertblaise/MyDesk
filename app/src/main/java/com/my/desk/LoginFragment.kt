package com.my.desk

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.my.desk.ui.components.LogoedButton
import com.my.desk.ui.theme.MyDeskTheme
import com.my.desk.ui.theme.*
import com.my.desk.ui.theme.inter

class LoginFragment : Fragment() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser

    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_FeedFragment)
                }else{
                    //todo handle any sign in error
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {

            setContent {
                var emailText by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
                var passwordHidden by rememberSaveable { mutableStateOf(true) }
                val annotatedForgotPassword = buildAnnotatedString {
                    append("Forgot Password")
                }
                val annotatedSignUp = buildAnnotatedString {
                    append("SignUp")
                }
                MyDeskTheme() {
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
                                    "Login", style = MaterialTheme.typography.h1,
                                    color = DarkBlueGrey
                                )
                                Spacer(modifier = Modifier.padding(vertical = 16.dp))
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
                                ClickableText(
                                    onClick = {
                                        //todo go to password reset page
                                        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)

                                    },
                                    text = annotatedForgotPassword, style = TextStyle(
                                        color = MaterialTheme.colors.primary, fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = inter

                                    )
                                )
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Button(modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp), onClick = { /*TODO*/ }) {
                                    Text(
                                        "Login", color = Color.White,
                                        style = TextStyle(
                                            fontWeight = FontWeight.Normal,
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
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = inter

                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                LogoedButton(
                                    logo = R.drawable.google_logo,
                                    backgroundColor = DarkBlueGrey,
                                    label = "Google",
                                    onClick = {/*todo runn google login*/}
                                )
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Row(modifier = Modifier.padding(bottom = 16.dp)) {

                                    Text(text = "Don't have an Account? ")
                                    ClickableText(
                                        onClick = {
                                            //todo go to sign up page
                                                  findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
                                        },
                                        text = annotatedSignUp, style = TextStyle(
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
fun LoginForm() {
    var emailText by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    val annotatedForgotPassword = buildAnnotatedString {
        append("Forgot Password")
    }
    val annotatedSignUp = buildAnnotatedString {
        append("SignUp")
    }
    MyDeskTheme() {
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
                        "Login", style = MaterialTheme.typography.h1,
                        color = DarkBlueGrey
                    )
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
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
                    ClickableText(
                        onClick = {
                            //todo go to password reset page

                        },
                        text = annotatedForgotPassword, style = TextStyle(
                            color = MaterialTheme.colors.primary, fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = inter

                        )
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp), onClick = { /*TODO*/ }) {
                        Text(
                            "Login", color = Color.White,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
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
                                fontWeight = FontWeight.Bold,
                                fontFamily = inter

                            )
                        )
                    }
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    LogoedButton(
                        logo = R.drawable.google_logo,
                        backgroundColor = DarkBlueGrey,
                        label = "Google",
                        onClick = {/*todo runn google login*/}
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Row(modifier = Modifier.padding(bottom = 16.dp)) {

                        Text(text = "Don't have an Account? ")
                        ClickableText(
                            onClick = {
                                //todo go to sign up page

                            },
                            text = annotatedSignUp, style = TextStyle(
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

@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
//        withStyle(
//            span = SpanStyle(
//                color = MaterialTheme.colors.onBackground
//            )
//        ) {
//            append("Don't have an Account? ")
//        }

        pushStringAnnotation(
            tag = "SignUp",
            annotation = "SignUp"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary
            )
        ) {
            append("Sign Up")
        }
        pop()
    }
    ClickableText(text = annotatedText, onClick = {
        //todo go to sign up page
    })
}

@Preview(showBackground = true)
@Composable
fun ShowLoginPreview() {
    LoginForm()
}


