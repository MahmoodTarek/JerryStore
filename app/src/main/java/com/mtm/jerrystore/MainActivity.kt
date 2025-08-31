package com.mtm.jerrystore

import android.graphics.Color
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupStatusBars()

        setContentView(R.layout.activity_main)

        bindTomCards()
    }

    private fun bindTomCards() {
        val container: GridLayout = findViewById(R.id.tom_cards_container)

        for (card in cards) {

            val itemView = layoutInflater.inflate(R.layout.item_tom_card, container, false)

            val image = itemView.findViewById<ImageView>(R.id.card_image)
            val name = itemView.findViewById<TextView>(R.id.card_name)
            val description = itemView.findViewById<TextView>(R.id.card_description)
            val price = itemView.findViewById<TextView>(R.id.card_price)

            image.setImageResource(card.image)
            name.text = card.name
            description.text = card.description
            price.text = card.price

            container.addView(itemView)
        }
    }

    private fun setupStatusBars() {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = ContextCompat.getColor(this, R.color.white_blue),
                Color.TRANSPARENT
            )
        )
    }

    private val cards = listOf<TomCardDetails>(
        TomCardDetails(
            image = R.drawable.img_tom_sport,
            name = "Sport Tom",
            description = "He runs 1 meter... trips over his boot.",
            price = "3 cheeses"
        ),
        TomCardDetails(
            image = R.drawable.img_tom_lover,
            name = "Sport the lover",
            description = "He loves one-sidedly... and is beaten by the other side.",
            price = "5 cheeses"
        ),
        TomCardDetails(
            image = R.drawable.img_tom_bomb,
            name = "Tom the bomb",
            description = "He blows himself up before Jerry can catch him.",
            price = "10 cheeses"
        ),
        TomCardDetails(
            image = R.drawable.img_tom_spy,
            name = "spy Tom",
            description = "Disguises itself as a table.",
            price = "12 cheeses"
        ),
        TomCardDetails(
            image = R.drawable.img_tom_frozen,
            name = "Frozen Tom",
            description = "He was chasing Jerry, he froze after the first look.",
            price = "10 cheeses"
        ),
        TomCardDetails(
            image = R.drawable.img_tom_sport,
            name = "Sleeping Tom",
            description = "He doesn't chase anyone, he just snores in stereo.",
            price = "10 cheeses"
        )
    )
}