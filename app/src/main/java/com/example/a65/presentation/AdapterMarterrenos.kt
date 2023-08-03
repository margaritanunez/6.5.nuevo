package com.example.a65.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a65.data.remote.Marterreno
import com.example.a65.databinding.ItemLayoutBinding

class AdapterMarterrenos : RecyclerView.Adapter<AdapterMarterrenos.ItemLayoutViewHolder>() {
    lateinit var binding: ItemLayoutBinding
    private var listaMarterrenos= mutableListOf<Marterreno>()

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

    fun setData(marterreno: List<Marterreno>){
        this.listaMarterrenos.clear()
        this.listaMarterrenos.addAll(marterreno)
        notifyDataSetChanged()
    }

    class ItemLayoutViewHolder (val binding2: ItemLayoutBinding) : RecyclerView.ViewHolder(binding2.root) {
        fun bind(marterreno: Marterreno) {
            binding2.imgMars.load(marterreno.imgMars)
        }
    }

}