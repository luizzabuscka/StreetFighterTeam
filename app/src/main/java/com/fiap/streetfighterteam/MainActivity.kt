package com.fiap.streetfighterteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiap.streetfighterteam.adapter.CharacterAdapter
import com.fiap.streetfighterteam.model.Character
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val characters = listOf(
        Character(
            1,
            "Ryu",
            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-ryu-2.jpg",
            4, 3, 3, 2, 4
        ),
        Character(
            2,
            "Chun-Li",
            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-chun-li-2.jpg",
            2, 2, 4, 4, 3
        ),
        Character(
            3,
            "Ken",
            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-ken-2.jpg",
            3, 3, 4, 2, 3
        ),
        Character(
            4,
            "Vega",
            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-vega-2.jpg",
            3, 2, 5, 3, 3
        ),
        Character(
            5,
            "Zangief",
            "https://streetfighter.com/wp-content/uploads/2019/11/portrait-zangief-2.jpg",
            5, 5, 1, 2, 3
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CharacterAdapter(characters)
        rvCharacters.adapter = adapter
    }
}
