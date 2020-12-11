package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autentification_activity)
        val signUpBtn = findViewById<Button>(R.id.SignUp)
        val signInBtn = findViewById<Button>(R.id.SignIn)
        signUpBtn.setOnClickListener(){
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)


        }
        signInBtn.setOnClickListener(){
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)


        }




    }



}