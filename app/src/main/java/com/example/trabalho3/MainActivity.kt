package com.example.trabalho3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.trabalho3.activities.FavoritesActivity
import com.example.trabalho3.activities.TesteCadastroActivity
import com.example.trabalho3.classes.location.Location
import com.example.trabalho3.classes.location.LocationDao
import com.example.trabalho3.database.AppDatabase

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var idx: String? = null
    var aqi: String? = null
    var city: String? = null

    private val list = ArrayList<Location>()

    private var database: AppDatabase? = null

    private var locationDao: LocationDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        findCurrentLocation()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "techstore-database"
        ).allowMainThreadQueries().build()

        locationDao = database!!.locationDao()

        //Database request
        list.addAll(locationDao!!.all())

        //Delete Item
        val bundle = intent.extras
        val op: String? = bundle?.getString("op")

        if(op.toString() == "delete") {
            val location = bundle?.get("location") as Location?

            if(location != null) {
                list.remove(location)
                locationDao!!.delete(location)
            }
            reloadFavoritesCities()
        }

    }

    private fun findCurrentLocation() {
        val requestQueue = Volley.newRequestQueue(this)

        val textViewTargetCity: TextView = findViewById(R.id.textViewTargetCity)
        val textViewLastUpdate: TextView = findViewById(R.id.textViewLastUpdate)
        val textViewScore: TextView = findViewById(R.id.textViewScore)

        val url = "https://api.waqi.info/feed/here/?&token=${TOKEN}"

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val data = response.getJSONObject("data")
                city = data.getJSONObject("city").getString("name")
                aqi = data.getString("aqi")
                idx = data.getString("idx")
                val lastUpdate = data.getJSONObject("time").getString("s")

                textViewTargetCity.text = city
                textViewScore.text = aqi
                textViewLastUpdate.text = lastUpdate

            },
            Response.ErrorListener { error ->
                val toast = Toast.makeText(applicationContext, "Request Error", Toast.LENGTH_LONG)
                toast.show()
            }
        )
        requestQueue.add(request)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorites -> {
                val intent: Intent = Intent(this, FavoritesActivity::class.java)

                //Parcializable object
                intent.putExtra("list", list)

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

    fun reloadFavoritesCities () {
        val intent: Intent = Intent(this, FavoritesActivity::class.java)
        intent.putExtra("list", list)

        startActivityForResult(intent, 1)
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
}
