package com.example.deliziosociboapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var mTvName:EditText
    lateinit var mTvPhone:EditText
    lateinit var mTvPassword:EditText
    lateinit var mTvEmail:EditText
    lateinit var mBtnReg:Button
    lateinit var aboutBtn:Button
    lateinit var progressDialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        aboutBtn = findViewById(R.id.aboutBtn)
        mTvName = findViewById(R.id.EnterName)
        mTvEmail = findViewById(R.id.email)
        mTvPassword =findViewById(R.id.password)
        mTvPhone =findViewById(R.id.phone)
        mBtnReg =findViewById(R.id.btnreg)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving")
        progressDialog.setMessage("Please wait...")


        //Set onclick listeners
        aboutBtn.setOnClickListener {
            var tembea = Intent(this,AboutActivity::class.java)
            startActivity(tembea)
        }

        mBtnReg.setOnClickListener {
            var name = mTvName.text.toString().trim()
            var email = mTvEmail.text.toString().trim()
            var phone = mTvPhone.text.toString().trim()
            var password = mTvPassword.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (name.isEmpty()){
                mTvName.setError("Please fill this field")
                mTvName.requestFocus()
            }else if (email.isEmpty()){
                mTvEmail.setError("Please fill this field")
                mTvEmail.requestFocus()
            }else if (phone.isEmpty()){
                mTvPhone.setError("Please fill this field")
                mTvPhone.requestFocus()
            }else if (password.isEmpty()) {
                mTvPassword.setError("Please fill this field")
                mTvPassword.requestFocus()
            }else {
                //Proceed to save

                //Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().
                getReference().child("Users/"+id)
                //Show the progress to start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener{
                    //Dismiss the progress and check if the task was successful
                        task->
                    progressDialog.dismiss()
                    if (task.isSuccessful){
                        Toast.makeText(this,"User saved successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User saving failed",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }


    }
}