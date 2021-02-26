package com.practica.practicafinalm8uf1.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practica.practicafinalm8uf1.Model.Marca
import com.practica.practicafinalm8uf1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item.view.*
import java.security.AccessControlContext

class MyAdapter(private val context: Context, private val modelList: MutableList<Marca>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        Log.i("prueba","test")
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(modelList[position].logo).into(holder.image)
        holder.txt_numero.text = modelList[position].numero_seminari
        holder.txt_descripcion.text = modelList[position].titol
        holder.txt_marca.text = modelList[position].empresa_organitzadora
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var txt_numero: TextView
        var txt_descripcion: TextView
        var txt_marca: TextView

        init {
            image = itemView.image_marca
            txt_numero = itemView.txt_name
            txt_descripcion = itemView.txt_team
            txt_marca = itemView.txt_createdby
        }
    }

}