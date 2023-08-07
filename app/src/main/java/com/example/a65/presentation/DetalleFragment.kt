package com.example.a65.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.a65.R
import com.example.a65.databinding.FragmentDetalleBinding

// paso 37

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id" //paso 40 cambiar valor a ARG_PARAM1, esta es la misma key que usé en Adapter para guardar
// el bundle recupera el valor y entrega el id del elemento

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val marterrenoViewModel: MarterrenoViewModel by activityViewModels() //paso 42

    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        marterrenoViewModel.marterrenoLiveData(param1.toString()).observe(viewLifecycleOwner){
            binding.tvID.text = it.id
            binding.tvPrice.text =it.price.toString()
            binding.tvType.text = it.type
            binding.imageView.load(it.imgMars)
        }// paso 42
        return binding.root
    }
}