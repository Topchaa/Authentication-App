package com.example.authentication

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
  private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth
        val Email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val repeate = findViewById<EditText>(R.id.password2)
        val register = findViewById<Button>(R.id.register)
        val loader = findViewById<ProgressBar>(R.id.load)
        register.setOnClickListener(){

            if(Email.text.isNotEmpty() && password.text.isNotEmpty() && repeate.text.isNotEmpty()) {
                if (password.text.toString() == repeate.text.toString()) {
                    if (isEmailValid(Email.text.toString())) {
                        loader.visibility = View.VISIBLE
                        auth.createUserWithEmailAndPassword(Email.text.toString(), password.text.toString())
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    loader.visibility = View.INVISIBLE
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(this,"SignUp is success",Toast.LENGTH_LONG).show()

                                } else {

                                    loader.visibility = View.INVISIBLE
                                    Toast.makeText(baseContext,task.exception.toString(),Toast.LENGTH_LONG).show()
                                }


                            }



                    } else {
                        Toast.makeText(this, "email format is not correct ", Toast.LENGTH_LONG).show()
                    }

                } else {
                    Toast.makeText(this, "passwords does not match", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show()

            }



        }


    }


    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}