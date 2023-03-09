package com.example.grannyapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        //Creating variables
        val userName = findViewById<View>(R.id.txtNewName) as EditText
        val password = findViewById<View>(R.id.txtNewPassword) as EditText
        val email = findViewById<View>(R.id.txtNewEmail) as EditText
        val btnRegister = findViewById<View>(R.id.btnNewRegister) as Button

        //Button click method
        btnRegister.setOnClickListener {
            val preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
            val newUser = userName.text.toString()
            val newPassword = password.text.toString()
            val newEmail = email.text.toString()
            val editor = preferences.edit()
            editor.putString(newUser+ newPassword+"data ", newUser +"\n "+ newEmail)
            editor.commit()
            val loginScreen = Intent(this@Register, MainActivity::class.java)
            startActivity(loginScreen)
            Toast.makeText( this,"Registered!", Toast.LENGTH_SHORT).show()
            Toast.makeText( this,"Please Login", Toast.LENGTH_SHORT).show()
        }
    }
}