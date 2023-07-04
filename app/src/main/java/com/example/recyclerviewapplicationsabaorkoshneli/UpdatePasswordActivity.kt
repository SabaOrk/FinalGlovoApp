package com.example.recyclerviewapplicationsabaorkoshneli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class UpdatePasswordActivity : AppCompatActivity() {

    private lateinit var newPasswordET : EditText
    private lateinit var updatePasswordSaveBtn : Button
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        init()
        listeners()
    }

    private fun listeners() {
        updatePasswordSaveBtn.setOnClickListener {
            val newPassword = newPasswordET.text.toString()

            if ( newPassword.isEmpty() ){
                return@setOnClickListener
            }

            val user = auth.currentUser
            user!!.updatePassword(newPassword).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "you have successfully changed your password", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ProfileActivity::class.java))
                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun init() {
        updatePasswordSaveBtn = findViewById(R.id.updatePasswordSaveBtn)
        newPasswordET = findViewById(R.id.newPasswordET)
    }
}