package com.example.deliziosociboapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class OffersActivity : AppCompatActivity() {
    lateinit var mTvOffer:EditText
    lateinit var add:Button
    lateinit var check:Button
    lateinit var progressDialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers)

        mTvOffer = findViewById(R.id.edtoffer)
        add = findViewById(R.id.addOffers)
        check = findViewById(R.id.viewOffers)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please wait...")
        add.setOnClickListener {

            var name = mTvOffer.text.toString().trim()

            if (name.isEmpty()) {
                mTvOffer.setError("Please fill this field")
                mTvOffer.requestFocus()
            } else {
                //Proceed to save
                var user = User(name)
                //Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().getReference().child("Users/")
                //Show the progress to start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener {
                    //Dismiss the progress and check if the task was successful
                        task ->
                    progressDialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "User saved successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this, "User saving failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
        check.setOnClickListener {
            var tembea = Intent(this,UsersActivity::class.java)
            startActivity(tembea)
        }
    }
}
