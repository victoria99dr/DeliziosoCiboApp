package com.example.deliziosociboapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btnLogin: Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // View Binding
        btnLogin = findViewById(R.id.btnLogin)
        etEmail = findViewById(R.id.email2)
        etPass = findViewById(R.id.password2)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
            var tembea = Intent(this,HomeActivity::class.java)
            startActivity(tembea)

        }
    }

    private fun login() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Successfully signed in", Toast.LENGTH_SHORT).show()
        }
    }

}
