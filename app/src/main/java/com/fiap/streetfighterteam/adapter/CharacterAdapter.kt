package com.fiap.streetfighterteam.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fiap.streetfighterteam.CharacterDetailActivity
import com.fiap.streetfighterteam.R
import com.fiap.streetfighterteam.model.Character

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvName by lazy {
            view.findViewById<TextView>(R.id.tvName)
        }

        private val ivPhoto by lazy {
            view.findViewById<ImageView>(R.id.ivPhoto)
        }

        fun bind(character : Character) {
            tvName.text = character.name

            Glide
                .with(view.context)
                .load(character.photo)
                .into(ivPhoto)

            view.setOnClickListener {
                val intent = Intent(view.context, CharacterDetailActivity::class.java)
                intent.putExtra("character", character)
                view.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }
}