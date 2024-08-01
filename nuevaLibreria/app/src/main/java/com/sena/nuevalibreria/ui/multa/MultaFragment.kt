package com.sena.nuevalibreria.ui.multa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sena.nuevalibreria.adapters.adapterMulta
import com.sena.nuevalibreria.databinding.FragmentMultaBinding
import com.sena.nuevalibreria.models.multa

class MultaFragment : Fragment() {


    private var _binding: FragmentMultaBinding? = null
    private val binding get() = _binding!!
    private lateinit var listMulta: MutableList<multa>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(MultaViewModel::class.java)

        _binding = FragmentMultaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listMulta = mutableListOf()
        listMulta.add(multa("25/06/2024", "5000", "31/07/2024", "pagado"))
        listMulta.add(multa("25/06/2024", "5000", "31/07/2024", "pagado"))

        val recyclerView = binding.RVMulta
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapterMulta = adapterMulta(listMulta, requireContext())
        recyclerView.adapter = adapterMulta

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