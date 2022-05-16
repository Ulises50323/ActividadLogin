package com.example.actividadlogin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuContactos : AppCompatActivity() {
    private var recyclerView: RecyclerView?=null
    private var recyclerViewAdapter:PlantillaLista?=null
    private var movieList = mutableListOf<Movie_plantilla>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_contactos)
        movieList = ArrayList()
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        recyclerViewAdapter = PlantillaLista(movieList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<Movie_plantilla> {
            override fun onItemClick(elemento: Movie_plantilla) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:" + elemento.numero)
                startActivity(intent)
            }
        })
        recyclerView!!.adapter = recyclerViewAdapter
        prepareMovie()
    }


    private fun prepareMovie() {
        var movie = Movie_plantilla("Martina Sofía Turcios Mendez", R.drawable.persona1,"79045375")
        movieList.add(movie)
        movie = Movie_plantilla("María Lucía Duarte Díaz", R.drawable.persona2, "60947885")
        movieList.add(movie)
        movie = Movie_plantilla("Hugo Martín Fernández Espinoza", R.drawable.persona3,"77120394")
        movieList.add(movie)
        movie = Movie_plantilla("Pablo Alejandro Flores Giménez", R.drawable.persona4,"65494385")
        movieList.add(movie)

        recyclerViewAdapter?.notifyDataSetChanged()
    }
}