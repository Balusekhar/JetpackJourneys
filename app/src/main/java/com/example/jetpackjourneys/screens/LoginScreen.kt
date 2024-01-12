package com.example.jetpackjourneys.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackjourneys.R
import com.example.jetpackjourneys.navigation.Routes
import com.example.jetpackjourneys.util.CustomButton
import com.example.jetpackjourneys.util.TextInputField


@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.padding(top = 36.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )

        StyledText()

        Spacer(modifier = Modifier.padding(36.dp))

        Text(
            text = "LOGIN",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Text(text = "sign in to continue")

        TextInputField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp, top = 16.dp),
            value = email,
            maxLines = true
        ) { email = it }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,),
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            label = { Text(text = "Enter Your Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility),
                            contentDescription = "Hide Password"
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility_off),
                            contentDescription = "Show Password"
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        CustomButton(label = "LOGIN") {
            navController.navigate(Routes.BlogList.route)
        }

        SignUpText {
            navController.navigate(Routes.Signup.route)
        }

    }
}



@Composable
fun SignUpText(onSignUpClicked: () -> Unit) {
    Spacer(modifier = Modifier.height(18.dp))
    Text(text = "Don't Have An Account?")
    TextButton(onClick = onSignUpClicked) {
        Text(text = "Create Account")
    }
}

@Composable
fun StyledText() {
    val styledText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        ) {
            append("Jetpack ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        ) {
            append("Journeys")
        }
    }

    Text(text = styledText, textAlign = TextAlign.Center)
}


//@Preview
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}