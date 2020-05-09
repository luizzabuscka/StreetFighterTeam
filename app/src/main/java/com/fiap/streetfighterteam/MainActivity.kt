package com.fiap.streetfighterteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fiap.streetfighterteam.adapter.CharacterAdapter
import com.fiap.streetfighterteam.connection.SFConnection
import com.fiap.streetfighterteam.model.Character
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SFConnection().service.listCharacters().enqueue(object: Callback<List<Character>> {

            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                //SUCESSO!!
                val characters = response.body()

                characters?.let {
                    fillList(characters)
                } ?: run {
                    Toast.makeText(this@MainActivity, "Falha ao carregar personagens", Toast.LENGTH_LONG).show()
                }


            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                //ERRO :(
                Toast.makeText(this@MainActivity, "Falha ao carregar personagens", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun fillList(characters : List<Character>) {
        val adapter = CharacterAdapter(characters)
        rvCharacters.adapter = adapter
    }
}
