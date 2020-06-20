package com.example.trabalho3.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho3.Location
import com.example.trabalho3.R
import com.example.trabalho3.adapter.AdapterLocations
import kotlinx.android.synthetic.main.city.view.*

class FavoritesActivity : AppCompatActivity() {
    val list = ArrayList<Location>()
    val adapter = AdapterLocations(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        //Recycle List and Adapter connection
        val recyclerListView: RecyclerView = findViewById(R.id.recyclerListView)
        val layoutManager = LinearLayoutManager(this)
        recyclerListView.layoutManager = layoutManager
        recyclerListView.adapter = adapter

        //Delete Item

    }

    //Apenas para a Tela de Criação Feita para Testes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            val id: String? = data?.getStringExtra("id")
            val name: String? = data?.getStringExtra("name")

            //criar objeto e incluir na lista
            list.add(Location(id.toString(), name.toString()))

            //Atualizar lista
            adapter.notifyDataSetChanged()
        }
    }

}