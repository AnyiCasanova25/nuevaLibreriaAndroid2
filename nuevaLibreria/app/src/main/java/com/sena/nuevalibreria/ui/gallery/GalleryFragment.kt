package com.sena.nuevalibreria.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sena.nuevalibreria.adapters.adapterUsers
import com.sena.nuevalibreria.databinding.FragmentGalleryBinding
import com.sena.nuevalibreria.models.users

class GalleryFragment : Fragment() {


    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var listUsers: MutableList<users>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        
        listUsers = mutableListOf()
        listUsers.add(users("Admin", "Maidy", "neiva", "Maidy@gmail.com"))
        listUsers.add(users("Admin", "Maidy", "neiva", "Maidy@gmail.com"))

        val recyclerView = binding.RVUsers
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapterUsers = adapterUsers(listUsers, requireContext())
        recyclerView.adapter = adapterUsers

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