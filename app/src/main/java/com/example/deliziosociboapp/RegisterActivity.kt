package com.example.deliziosociboapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    lateinit var mTvEnterName: EditText
    lateinit var mPhone: EditText
    lateinit var txtBottom: EditText
    private lateinit var mTvPassword: EditText
    private lateinit var mreg: Button
    lateinit var mEmail: EditText
    private lateinit var mTvPasswordTwo: EditText



    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // View Bindings
        mTvEnterName = findViewById(R.id.EnterName)
        mPhone= findViewById(R.id.phone)
        mTvPassword = findViewById(R.id.password)
        mreg = findViewById(R.id.btnreg)
        mEmail = findViewById(R.id.email)
        mTvPasswordTwo =findViewById(R.id.passwordTwo)
        txtBottom = findViewById(R.id.textBottom)


        // Initialising auth object
        auth = Firebase.auth

        mreg.setOnClickListener {
            signUpUser()
            var tembea = Intent(this,HomeActivity::class.java)
            startActivity(tembea)

        }

        txtBottom.setOnClickListener {
            signUpUser()
            var tembea = Intent(this,LoginActivity::class.java)
            startActivity(tembea)

        }
    }

    private fun signUpUser() {
        val email = mEmail.text.toString()
        val pass = mTvPassword.text.toString()
        val confirmPassword = mTvPasswordTwo.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
