package com.sena.nuevalibreria.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sena.nuevalibreria.R
import com.sena.nuevalibreria.models.libro

class adapterLibro
    (var listLibro: List<libro>,
     var context: Context
): RecyclerView.Adapter<adapterLibro.MyHolder>()
{
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var lblTitulo: TextView
        lateinit var lblAutor: TextView
        lateinit var lblISBN: TextView
        lateinit var lblGenero: TextView

        init {
            lblTitulo=itemView.findViewById(R.id.lblTitulo)
            lblAutor=itemView.findViewById(R.id.lblAutor)
            lblISBN=itemView.findViewById(R.id.lblISBN)
            lblGenero=itemView.findViewById(R.id.lblGenero)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterLibro.MyHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_libro,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterLibro.MyHolder, position: Int) {
        val libro=listLibro[position]
        holder.lblTitulo.text=libro.titulo
        holder.lblAutor.text=libro.autor
        holder.lblISBN.text=libro.isbn
        holder.lblGenero.text=libro.genero
    }

    override fun getItemCount(): Int {
        return listLibro.size
    }
}