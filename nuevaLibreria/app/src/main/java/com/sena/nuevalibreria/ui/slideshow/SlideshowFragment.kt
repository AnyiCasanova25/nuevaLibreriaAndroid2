package com.sena.nuevalibreria.ui.slideshow

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
import com.sena.nuevalibreria.adapters.adapterLibro
import com.sena.nuevalibreria.adapters.adapterUsers
import com.sena.nuevalibreria.databinding.FragmentGalleryBinding
import com.sena.nuevalibreria.databinding.FragmentSlideshowBinding
import com.sena.nuevalibreria.models.libro
import com.sena.nuevalibreria.models.users
import com.sena.nuevalibreria.ui.gallery.GalleryViewModel

class SlideshowFragment : Fragment() {


    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!
    private lateinit var listLibro: MutableList<libro>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listLibro = mutableListOf()
        listLibro.add(libro("Las rosas de mayo","Thriller","125351825","Dot Hutchenson"))
        listLibro.add(libro("Las rosas de mayo","Thriller","125351825","Dot Hutchenson"))

        //esto puede generar error
        val recyclerView = binding.RVLibro
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapterLibro = adapterLibro(listLibro, requireContext())
        recyclerView.adapter = adapterLibro

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