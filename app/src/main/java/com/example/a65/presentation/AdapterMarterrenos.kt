package com.example.a65.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a65.R
import com.example.a65.data.local.TerrenoEntity
import com.example.a65.data.remote.Marterreno
import com.example.a65.databinding.ItemLayoutBinding

class AdapterMarterrenos : RecyclerView.Adapter<AdapterMarterrenos.ItemLayoutViewHolder>() {
    lateinit var binding: ItemLayoutBinding
    private var listaMarterrenos= mutableListOf<TerrenoEntity>() // cambiar lista por terreno entity p34.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLayoutViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemLayoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterMarterrenos.ItemLayoutViewHolder, position: Int) {
        val marterreno = listaMarterrenos[position]
        holder.bind(marterreno)
    }

    override fun getItemCount(): Int {
        return listaMarterrenos.size
    }

    fun setData(marterreno: List<TerrenoEntity>){ //cambiar lista Marterreno por TerrenoEntity p34
        this.listaMarterrenos.clear()
        this.listaMarterrenos.addAll(marterreno)
        notifyDataSetChanged()
    }

    class ItemLayoutViewHolder (val binding2: ItemLayoutBinding) : RecyclerView.ViewHolder(binding2.root) {
        fun bind(marterreno: TerrenoEntity) { //p34 cambiar Marterreno por TerrenoEntity
            binding2.imgMars.load(marterreno.imgMars)
            binding2.cv1.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id", marterreno.id )
                Navigation.findNavController(binding2.root).navigate(R.id.action_listFragment_to_detalleFragment, bundle)
            } //paso 39
            // al bundle se le pasa una clave  y un valor, en este caso la clave es el nombre que se le entrega y que se encuentra "" y el valor es el nombre de la variable
            //imaginar al bundle como una cajita que tiene varias casillas , cúando les decimos putAlgo, les damos una clave y un valor. en este caso es putString, lo que significa que son dos string, porque se pasan dos parámetros, uno es la clave y el otro es el valor.
            // la key es el identificador con el cual pasa al otro lado. la clave es cualquiera que quiera yo.
            // este bundle  se pasa a la navegación cómo puedes observar.
            // en detalle fragment obtenemos ese valor
        }
    }

}