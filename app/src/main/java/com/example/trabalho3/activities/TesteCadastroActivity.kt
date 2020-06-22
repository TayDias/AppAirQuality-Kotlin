package com.example.trabalho3.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalho3.R

class TesteCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste_cadastro)

        val editTextId: EditText = findViewById(R.id.editTextId)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonRegister: Button = findViewById(R.id.buttonCreate)

        buttonRegister.setOnClickListener {
            val id: String = editTextId.text.toString()
            val name: String = editTextName.text.toString()

            if ((!id.isEmpty() && !id.isNullOrBlank())
                && (!name.isEmpty() && !name.isNullOrBlank())) {

                val data = Intent()
                data.putExtra("id", id)
                data.putExtra("name", name)

                setResult(Activity.RESULT_OK, data)
                finish()
            }
            else {
                //lançar exception e mensagem na tela
            }
        }
    }
}