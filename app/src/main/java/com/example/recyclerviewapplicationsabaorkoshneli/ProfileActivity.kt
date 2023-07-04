package com.example.recyclerviewapplicationsabaorkoshneli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfileActivity : AppCompatActivity() {

    private lateinit var updatePasswordBtn : Button
    private lateinit var exitAppBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        listeners()
    }

    private fun listeners() {
        updatePasswordBtn.setOnClickListener {
            startActivity(Intent(this, UpdatePasswordActivity::class.java))
        }

        exitAppBtn.setOnClickListener {
            finishAffinity()
        }
    }

    private fun init() {
        updatePasswordBtn = findViewById(R.id.updatePasswordBtn)
        exitAppBtn = findViewById(R.id.exitAppBtn)
    }

}