package com.example.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth


        val Email = findViewById<EditText>(R.id.email2)
        val pass = findViewById<EditText>(R.id.password3)
        val LogIn  = findViewById<Button>(R.id.Login)
        val loader = findViewById<ProgressBar>(R.id.load2)


        LogIn.setOnClickListener(){

            if (Email.text.isNotEmpty() && pass.text.isNotEmpty()){
             loader.visibility = View.VISIBLE
                auth.signInWithEmailAndPassword( Email.text.toString() , pass.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            loader.visibility = View.INVISIBLE
                            // Sign in success, update UI with the signed-in user's information
                           Toast.makeText(this,"Authentication is Success!",Toast.LENGTH_LONG).show()


                        } else {
                            loader.visibility = View.INVISIBLE


                            Toast.makeText(this,task.exception.toString() ,Toast.LENGTH_LONG).show()
                        }

                        // ...
                    }




            }else{
                Toast.makeText(this,"please fill all fields",Toast.LENGTH_LONG).show()
            }




        }




    }
}