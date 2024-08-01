package com.sena.nuevalibreria.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sena.nuevalibreria.R
import com.sena.nuevalibreria.models.multa
import com.sena.nuevalibreria.models.prestamo

class adapterMulta
    (var listMulta: List<multa>,
     var context: Context
): RecyclerView.Adapter<adapterMulta.MyHolder>()
{
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var lblFechaDevolucion: TextView
        lateinit var lblValorMulta: TextView
        lateinit var lblfechaMulta: TextView
        lateinit var lblEstado: TextView

        init {
            lblFechaDevolucion=itemView.findViewById(R.id.lblFechaDevolucion)
            lblValorMulta=itemView.findViewById(R.id.lblValorMulta)
            lblfechaMulta=itemView.findViewById(R.id.lblfechaMulta)
            lblEstado=itemView.findViewById(R.id.lblEstado)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterMulta.MyHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_multa,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterMulta.MyHolder, position: Int) {
        val multa=listMulta[position]
        holder.lblFechaDevolucion.text=multa.fechaDevolucion
        holder.lblValorMulta.text=multa.valorMulta
        holder.lblfechaMulta.text=multa.fechaMulta
        holder.lblEstado.text=multa.estado
    }

    override fun getItemCount(): Int {
        return listMulta.size
    }
}