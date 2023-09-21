package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroll.ui.theme.DiceRollTheme
//import kotlinx.android.synthetic.main.activity_main.diceImage
//import kotlinx.android.synthetic.main.activity_main.rollButton

class MainActivity : ComponentActivity() {
    private lateinit var rollButton:Button
    private lateinit var diceImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton=findViewById<Button>(R.id.rollButton)
        diceImage=findViewById<ImageView>(R.id.diceImage)
        rollButton.setOnClickListener {
            diceRoll()
        }
    }
    private fun diceRoll(){
        var randomNumber=(1..6).random()
        var imageDice :Int
        when (randomNumber) {
            1 -> {
                imageDice=R.drawable.dice1
            }
            2 -> {
                imageDice=R.drawable.dice2
            }
            3 -> {
                imageDice=R.drawable.dice3
            }
            4 -> {
                imageDice=R.drawable.dice4
            }
            5 -> {
                imageDice=R.drawable.dice5
            }
            else -> {
                imageDice=R.drawable.dice6
            }
        }
        diceImage.setImageResource(imageDice)
    }

    }


