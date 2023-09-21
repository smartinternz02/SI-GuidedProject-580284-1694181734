package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity



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
            .background(color = Color.Black.copy(alpha = 0.4f))
            .fillMaxSize()
    ) {


        Text(
            text = "LOGIN",
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 230.dp, bottom = 50.dp)


        )
        OutlinedTextField(
            value = username,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { username = it },
            label = { Text("Enter your username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Yellow.copy(alpha = 0.9f), // Set the background color here
                cursorColor = Color.Yellow
            ),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person", tint = Color.Black)
            },
            modifier = Modifier
                .padding(bottom = 5.dp, top = 5.dp)
                .width(1000.dp)
        )

        OutlinedTextField(
            value = password,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { password = it },
            label = { Text("Enter your password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Yellow.copy(alpha = 0.9f), // Set the background color here
                cursorColor = Color.Yellow
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password", tint = Color.Black)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 10.dp)
        )


        Column(
            modifier = Modifier
                .padding(start = 120.dp)

        ) {
            // amazon
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.amazon)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "Amazon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Blue),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.amazon.in")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "amazon.in")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "OPEN")
                }
            }
            //H&M
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.hm)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "H & M",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Blue),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www2.hm.com/")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www2." + "hm.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "OPEN")
                }
            }
            //starbucks
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.starbucks)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "Starbuck",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Blue),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.starbucks.com/")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "starbucks.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "OPEN")
                }
            }
            // apple
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.apple)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "Apple",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Blue),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.apple.com")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "apple.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "OPEN")
                }
            }
        }
    }

}