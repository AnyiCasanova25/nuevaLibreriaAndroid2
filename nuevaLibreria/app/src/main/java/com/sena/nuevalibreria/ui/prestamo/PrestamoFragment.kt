package com.sena.nuevalibreria.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sena.nuevalibreria.adapters.adapterPrestamo
import com.sena.nuevalibreria.databinding.FragmentPrestamoBinding
import com.sena.nuevalibreria.models.prestamo

class PrestamoFragment : Fragment() {


    private var _binding: FragmentPrestamoBinding? = null
    private val binding get() = _binding!!
    private lateinit var listPrestamo: MutableList<prestamo>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(PrestamoViewModel::class.java)

        _binding = FragmentPrestamoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listPrestamo = mutableListOf()
        listPrestamo.add(prestamo("25/05/2024", "25/06/2024", "Maydy", "El pricipito","Entregado"))
        listPrestamo.add(prestamo("25/05/2024", "25/06/2024", "Maydy", "El pricipito","Entregado"))

        val recyclerView = binding.RVPrestamo
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapterPrestamo = adapterPrestamo(listPrestamo, requireContext())
        recyclerView.adapter = adapterPrestamo

        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}