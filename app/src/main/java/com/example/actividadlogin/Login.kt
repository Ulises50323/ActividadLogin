package com.example.actividadlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        btnRegistro.setOnClickListener {
            val intent = Intent(this,ActivityRegistro::class.java)
            startActivity(intent)
        }
        btnIngresar.setOnClickListener {
            if (txtCorreo.text.toString().isEmpty()||txtcontra.text.toString().isEmpty())
            {
                Toast.makeText(this,"Ingrese todos los valores", Toast.LENGTH_LONG).show()
            }
            else
            {
                auth.signInWithEmailAndPassword(txtCorreo.text.toString(),txtcontra.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this,MenuContactos::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Acceso no autorizado! ", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}