package com.fiap.streetfighterteam

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fiap.streetfighterteam.model.Character
import kotlinx.android.synthetic.main.activity_character_detail.*

class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val character = intent.extras?.get("character")!! as Character

        Glide
            .with(this@CharacterDetailActivity)
            .load(character.photo)
            .into(ivPhoto)

        tvName.text = character.name

        ivPower.setImageDrawable(getStars(character.power))
        ivHealth.setImageDrawable(getStars(character.health))
        ivTechnique.setImageDrawable(getStars(character.technique))
        ivSpeed.setImageDrawable(getStars(character.mobility))
        ivReach.setImageDrawable(getStars(character.reach))

    }

    private fun getStars(stars : Int) : Drawable {
        return when(stars) {
            1 -> getDrawable(R.drawable.starts1)!!
            2 -> getDrawable(R.drawable.starts2)!!
            3 -> getDrawable(R.drawable.starts3)!!
            4 -> getDrawable(R.drawable.starts4)!!
            5 -> getDrawable(R.drawable.starts5)!!
            else -> getDrawable(R.drawable.starts1)!!
        }
    }
}
