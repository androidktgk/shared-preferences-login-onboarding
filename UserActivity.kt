package com.govind8061.simplesimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val btnLogout=findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            val sp=getSharedPreferences("userDetails", MODE_PRIVATE)
            val editor=sp.edit()
            editor.putString("logStatus","false")
            editor.apply()
            finishAfterTransition()
        }
    }
}