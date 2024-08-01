package com.sena.nuevalibreria.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sena.nuevalibreria.R
import com.sena.nuevalibreria.models.prestamo

class adapterPrestamo
    (var listPrestamo: List<prestamo>,
     var context: Context
): RecyclerView.Adapter<adapterPrestamo.MyHolder>()
{
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var lblFechaPrestamo: TextView
        lateinit var lblFechaDevolucion: TextView
        lateinit var lblNombre: TextView
        lateinit var lblTitulo: TextView
        lateinit var lblEstado: TextView

        init {
            lblFechaPrestamo=itemView.findViewById(R.id.lblFechaPrestamo)
            lblFechaDevolucion=itemView.findViewById(R.id.lblFechaDevolucion)
            lblNombre=itemView.findViewById(R.id.lblNombre)
            lblTitulo=itemView.findViewById(R.id.lblTitulo)
            lblEstado=itemView.findViewById(R.id.lblEstado)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterPrestamo.MyHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_prestamo,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterPrestamo.MyHolder, position: Int) {
        val prestamo=listPrestamo[position]
        holder.lblFechaPrestamo.text=prestamo.fechaPrestamo
        holder.lblFechaDevolucion.text=prestamo.fechaDevolucion
        holder.lblNombre.text=prestamo.nombre
        holder.lblTitulo.text=prestamo.titulo
        holder.lblEstado.text=prestamo.estado
    }

    override fun getItemCount(): Int {
        return listPrestamo.size
    }
}