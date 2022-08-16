package com.example.graphql_sampleapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObeserver()
        findViewById<AppCompatImageButton>(R.id.btnSearch).setOnClickListener {
            displaySearchedCharacter()
        }
    }

    private fun setObeserver() {
        mainActivityViewModel.characterResult.observeForever{
            //findViewById<EditText>(R.id.progressBar).isEnabled= false
            val result=  String.format("Id: %s%nGender: %s%nImage: %s%nName: %s", it.id, it.gender, it.image, it.name)
            findViewById<TextView>(R.id.txtResult).text= result
        }
    }

    private val mainActivityViewModel: MainViewModel by viewModels()
    private fun displaySearchedCharacter() {
        var id = findViewById<EditText>(R.id.txtId).text
        mainActivityViewModel.searchByCharacterId(id.toString())
    }
}
