package com.giocode.newsoccer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.giocode.newsoccer.databinding.FragmentNewsBinding
import com.giocode.newsoccer.ui.adapter.NewAdapter

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private var _binding: FragmentNewsBinding? = null
    private lateinit var adapter: NewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setAdapter()
        newsViewModel.buscarNoticias()

        return root




    }

    private fun setAdapter() {
        binding.recy.layoutManager = LinearLayoutManager(context)
        adapter = NewAdapter(emptyList())
        binding.recy.adapter = adapter
        newsViewModel.news.observe(viewLifecycleOwner) { listNews->
            adapter.updateList(listNews)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}