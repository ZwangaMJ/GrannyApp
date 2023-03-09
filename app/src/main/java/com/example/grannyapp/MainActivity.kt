package com.example.grannyapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar.DisplayOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Creating variables
        var  txtUserName :EditText = findViewById(R.id.txtUsername)
        var txtPassword :EditText = findViewById(R.id.txtPassword)
        var btnLogin :Button = findViewById(R.id.btnLogin) as Button
        var btnRegister :Button = findViewById(R.id.btnRegister) as Button
        //variable to get stored preferences
        val preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val userDetails = preferences.getString(txtUserName.toString()+ txtPassword.toString()+"data ","Username or Password is Incorrect.")
        val editor = preferences.edit()


        btnLogin.setOnClickListener(){
            txtUserName.text.toString()
            txtPassword.text.toString()

            editor.putString("display", userDetails)
            val intent = Intent(this, DisplayScreen::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
