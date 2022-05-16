package com.example.actividadlogin

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class ActivityRegistro : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth = FirebaseAuth.getInstance()
        btnRegistrarce.setOnClickListener {
            if (txtRegEmail.text.toString().isEmpty()||txtRedPass.text.toString().isEmpty()||txtConPass.text.toString().isEmpty())
            {
                Toast.makeText(this,"Ingrese todos los valores",Toast.LENGTH_LONG).show()
            }
            else
            {
                if (!txtConPass.text.toString().equals(txtRedPass.text.toString()))
                {
                    Toast.makeText(this,"Las contraseñas no son iguales",Toast.LENGTH_LONG).show()
                }
                else
                {
                    if (txtConPass.text.toString().length<6)
                    {
                        Toast.makeText(this,"Contraseña muy corta, minimo 6 caracteres",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        auth.createUserWithEmailAndPassword(txtRegEmail.text.toString(), txtRedPass.text.toString())
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                                    val user = auth.currentUser
                                    Toast.makeText(this,"Authentication Successful", Toast.LENGTH_LONG).show()

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                                    Toast.makeText(this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                }
            }
        }
    }
}