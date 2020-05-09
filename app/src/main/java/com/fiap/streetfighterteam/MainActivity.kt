package com.fiap.streetfighterteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        listCharactersFromAPI()

        btRefresh.setOnClickListener {
            listCharactersFromAPI()
        }
    }

    private fun listCharactersFromAPI() {
        val connection = SFConnection()

        pbLoading.visibility = View.VISIBLE
        rvCharacters.visibility = View.INVISIBLE
        connection.service.listCharacters().enqueue(object: Callback<List<Character>> {

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                pbLoading.visibility = View.INVISIBLE

                Toast.makeText(this@MainActivity, "Falha ao carregar personagens", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                // RESPOSTA COM SUCESSO
                pbLoading.visibility = View.INVISIBLE
                rvCharacters.visibility = View.VISIBLE

                val characters = response.body()

                characters?.let {
                    fillList(characters)
                } ?: run {
                    Toast.makeText(this@MainActivity, "Falha ao carregar personagens", Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    private fun fillList(characters: List<Character>) {
        val adapter = CharacterAdapter(characters)
        rvCharacters.adapter = adapter
    }
}
