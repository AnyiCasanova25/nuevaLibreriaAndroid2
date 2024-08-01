package com.sena.nuevalibreria.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sena.nuevalibreria.R
import com.sena.nuevalibreria.models.users

class adapterUsers
    (var listUsers: List<users>,
     var context: Context
): RecyclerView.Adapter<adapterUsers.MyHolder>()
{
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var lblCargo: TextView
        lateinit var lblNombre: TextView
        lateinit var lblDireccion: TextView
        lateinit var lblCorreo: TextView

        init {
            lblCargo=itemView.findViewById(R.id.lblCargo)
            lblNombre=itemView.findViewById(R.id.lblNombreUsuario)
            lblDireccion=itemView.findViewById(R.id.lblDireccion)
            lblCorreo=itemView.findViewById(R.id.lblCorreo)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterUsers.MyHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_user,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterUsers.MyHolder, position: Int) {
        val users=listUsers[position]
        holder.lblCargo.text=users.cargo
        holder.lblNombre.text=users.nombre
        holder.lblDireccion.text=users.direccion
        holder.lblCorreo.text=users.correo
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }
}