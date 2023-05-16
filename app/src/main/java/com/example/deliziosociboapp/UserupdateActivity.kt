package com.example.deliziosociboapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class UserupdateActivity : AppCompatActivity() {
    lateinit var edtName: EditText
    lateinit var progressDialog : ProgressDialog
    lateinit var btnUpdate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userupdate)
        edtName = findViewById(R.id.mEdtName)
        btnUpdate = findViewById(R.id.mBtnUserUpdate)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Updating")
        progressDialog.setMessage("Please wait...")
        //Receive data from the intent
        var receivedName = intent.getStringExtra("name")
        //Set the received data to the EditTexts
        edtName.setText(receivedName)
        ///Set onClickListener on the button update
        btnUpdate.setOnClickListener {
            var name = edtName.text.toString().trim()
            if (name.isEmpty()){
                edtName.setError("Please fill this field")
                edtName.requestFocus()
            }else {
                //Proceed to save
                var user = User(name!!)
                //Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().
                getReference().child("Users/")
                //Show the progress to start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener{
                    //Dismiss the progress and check if the task was successful
                        task->
                    progressDialog.dismiss()
                    if (task.isSuccessful){
                        Toast.makeText(this,"User updated successfully",
                            Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@UserupdateActivity,UsersActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"User updating failed",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }
}