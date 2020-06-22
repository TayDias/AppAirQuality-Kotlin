package com.example.trabalho3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.room.Room
import com.example.trabalho3.activities.FavoritesActivity
import com.example.trabalho3.activities.TesteCadastroActivity
import com.example.trabalho3.classes.location.Location
import com.example.trabalho3.classes.location.LocationDao
import com.example.trabalho3.database.AppDatabase

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Location>()

    private var database: AppDatabase? = null

    private var locationDao: LocationDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "techstore-database"
        ).allowMainThreadQueries().build()

        locationDao = database!!.locationDao()

        //Database request
        list.addAll(locationDao!!.all())

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorites -> {
                val intent: Intent = Intent(this, FavoritesActivity::class.java)

                //Problem: Formato do Array não pode ser objeto dinamico
                //intent.putExtra("list", list)

                //Alternativas
                //intent.putStringArrayListExtra("idsList", locationsIdsListToStringList())
                //intent.putStringArrayListExtra("namesList", locationsNamesListToStringList())

                startActivityForResult(intent, 1)
                true
            }
            R.id.telaTesteCadastro -> {
                val intent: Intent = Intent(this, TesteCadastroActivity::class.java)
                startActivityForResult(intent, 1)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Apenas para a Tela de Criação Feita para Testes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            val locationId: String? = data?.getStringExtra("id")
            val name: String? = data?.getStringExtra("name")

            val location = Location(
                0,
                locationId.toString(),
                name.toString()
            )

            list.add(location)
            val id = locationDao!!.insert(location)
        }
    }

//    fun locationsIdsListToStringList(): ArrayList<String> {
//        val ids: ArrayList<String> = ArrayList()
//        var position: Int = 0
//
//        list.forEach {
//            ids[position] = it.locationId
//            position++
//        }
//
//        return ids
//    }
//
//    fun locationsNamesListToStringList(): ArrayList<String> {
//        val names: ArrayList<String> = ArrayList()
//        var position: Int = 0
//
//        list.forEach {
//            names[position] = it.locationName
//            position++
//        }
//
//        return names
//    }
}
