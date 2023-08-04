package com.example.a65.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
        }
    }

}