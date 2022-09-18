package com.anderson.appdenoticiasusuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anderson.appdenoticiasusuario.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ocultação da Toolbar de serviço.
        supportActionBar!!.hide()

        recuperarNoticia()
    }

    // função para recuperar os dados servidor
    private fun recuperarNoticia(){
        db.collection("noticias").document("noticia").get()
            .addOnCompleteListener { document ->
                if (document.isSuccessful){
                    //recuperação dos campos do banco
                    val titulo = document.result.get("titulo").toString()
                    val noticia = document.result.get("noticia").toString()
                    val data = document.result.get("data").toString()
                    val autor = document.result.get("autor").toString()
                }
            }
    }
}