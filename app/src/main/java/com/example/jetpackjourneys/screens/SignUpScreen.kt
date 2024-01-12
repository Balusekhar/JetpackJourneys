package com.example.jetpackjourneys.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackjourneys.R
import com.example.jetpackjourneys.util.CustomButton
import com.example.jetpackjourneys.util.TextInputField

@Composable
fun SignUpScreen() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.padding(top = 36.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )

        StyledText()

        Spacer(modifier = Modifier.padding(24.dp))

        Text(
            text = "SIGN UP",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        )
        Text(text = "sign up to continue")

        TextInputField(
            modifier =  Modifier.fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp, top = 16.dp),
            value = email,
            maxLines = true
        ) { email = it }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,
            ),
            maxLines = 1,
            value = password,
            onValueChange = { password = it },
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


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,),
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            maxLines = 1,
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    if (confirmPasswordVisible) {
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

        CustomButton(label = "SIGNUP") {

        }

    }

}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}