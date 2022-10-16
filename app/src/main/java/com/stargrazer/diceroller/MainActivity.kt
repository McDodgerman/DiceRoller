package com.stargrazer.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollDice()
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val diceImage : ImageView = findViewById(R.id.imageView)
        val dRoll = Die(6).roll()
        val result = when (dRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(result)
        diceImage.contentDescription = dRoll.toString()
    }
}

class Die(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }

}