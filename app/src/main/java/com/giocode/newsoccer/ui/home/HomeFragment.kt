package com.giocode.newsoccer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giocode.newsoccer.databinding.FragmentHomeBinding
import com.giocode.newsoccer.ui.adapter.NewAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: NewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setAdapter()
        homeViewModel.noticias()

        return root




    }

    private fun setAdapter() {
        binding.recy.layoutManager = LinearLayoutManager(context)
        adapter = NewAdapter(emptyList())
        binding.recy.adapter = adapter
        homeViewModel.news.observe(viewLifecycleOwner) {listNews->
            adapter.updateList(listNews)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}