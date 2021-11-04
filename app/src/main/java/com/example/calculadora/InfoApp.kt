package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_app)

        val btnBack : Button = findViewById(R.id.btnRegresar)
        val intentCalcu = Intent(this, MainActivity::class.java)

        btnBack.setOnClickListener{view ->
            startActivity(intentCalcu)
        }
    }
}