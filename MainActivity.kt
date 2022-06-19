package com.govind8061.simplesimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnLogin=findViewById<Button>(R.id.btnSave)
        btnLogin.setOnClickListener {
            val sp= getSharedPreferences("userDetails", MODE_PRIVATE)
            val editor=sp.edit()
            editor.putString("logStatus","true")
            editor.apply()
            startActivity(Intent(this,UserActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        val sp=getSharedPreferences("userDetails", MODE_PRIVATE)
        if (sp.contains("logStatus")){
            val status=sp.getString("logStatus","")
            if (status=="true"){
                startActivity(Intent(this,UserActivity::class.java))
            }
        }
    }
}