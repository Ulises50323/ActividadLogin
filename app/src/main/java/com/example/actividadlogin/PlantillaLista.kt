package com.example.actividadlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PlantillaLista constructor(private val movieList: List<Movie_plantilla>) :
    RecyclerView.Adapter<PlantillaLista.MyViewHolder>() {
    private var clickListener: ClickListener<Movie_plantilla>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_plantilla_lista, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.people.text = movie.Nombre
        holder.image.setBackgroundResource(movie.image)
        holder.cardView.setOnClickListener {
            clickListener!!.onItemClick(movie)
        }
        holder.numer.text = "Numero : ${movie.numero}"
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setOnItemClickListener(movieClickListener: ClickListener<Movie_plantilla>?) {
        clickListener = movieClickListener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val people: TextView = itemView.findViewById(R.id.txtNombre)
        val image: ImageView = itemView.findViewById(R.id.image)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val numer: TextView = itemView.findViewById(R.id.txtNumero)

    }
}

interface ClickListener<T> {
    fun onItemClick(data: T)
}