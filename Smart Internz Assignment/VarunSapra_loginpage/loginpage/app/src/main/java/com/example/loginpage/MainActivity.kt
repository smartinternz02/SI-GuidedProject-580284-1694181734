package com.example.loginpage

import android.content.Context
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginpageTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUI(applicationContext)
        }
    }
}

@Composable
fun LoginUI(context: Context) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LOGIN",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 120.dp, top = 130.dp)
        )


        var usernameField by remember { mutableStateOf(username) }
        Box(
            modifier = Modifier
                .padding(bottom = 10.dp, top = 10.dp)
                .fillMaxWidth()
                .background(Color.Yellow.copy(alpha = 0.9f))
                .border(2.dp, Color.Yellow, AbsoluteRoundedCornerShape(200.dp))
        ) {
            BasicTextField(
                value = usernameField,
                onValueChange = { usernameField = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                ),
                decorationBox = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "person",
                        tint = Color.Black
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        var passwordField by remember { mutableStateOf(password) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow.copy(alpha = 0.9f))
                .border(2.dp, Color.Yellow, AbsoluteRoundedCornerShape(200.dp))
                .padding(bottom = 10.dp, top = 10.dp)
                .padding(horizontal = 16.dp)
        ) {
            BasicTextField(
                value = passwordField,
                onValueChange = { passwordField = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                ),
                decorationBox = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password",
                        tint = Color.Black
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Button(
            onClick = {
                // Handle login here
                logged(usernameField, passwordField, context)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
            border = BorderStroke(width = 2.dp, color = Color.Green),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            Text(
                text = "SUBMIT",
                textAlign = TextAlign.Center,
                color = Color.White,
            )
        }
    }
}

fun logged(username: String, password: String, context: Context) {
    if (username == "varunsapra" && password == "1234") {
        Toast.makeText(context, "Logged In Successfully!", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Invalid Login. Please try again.", Toast.LENGTH_SHORT).show()
    }
}
