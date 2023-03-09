package com.example.grannyapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import android.graphics.Bitmap
import android.widget.Button

class DisplayScreen : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_info)

        //setting the variables
        val preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE)
        val display = preferences.getString("display","")
        val displayInfo = findViewById<View>(R.id.txtTextViewName) as TextView
        //displaying user details on textView
        displayInfo.text = display

        button = findViewById(R.id.btnUpload) as Button
        imageView = findViewById(R.id.img_save)

        button.setOnClickListener{
            pickImageGallery()
        }
    }
    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }
}