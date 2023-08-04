package com.example.a65.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.a65.R
import com.example.a65.databinding.FragmentListBinding

/*Paso 11

 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val marterrenoViewModel: MarterrenoViewModel by activityViewModels()
    //corresponde al nombre de la clase VM.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.btnCharge.setOnClickListener {
            marterrenoViewModel.getAllMarterrenos()
        } // paso 15
        return binding.root
    }

    private fun initAdapter(){
        val adapter = AdapterMarterrenos()
        binding.rv.adapter = adapter
        marterrenoViewModel.marterrenosLiveData.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}