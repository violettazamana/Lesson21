package com.zamana.myapplication.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zamana.myapplication.databinding.FragmentHomeBinding
import com.zamana.myapplication.model.University
import com.zamana.myapplication.reposytory.UniversityRepository
import com.zamana.myapplication.ui.home.adapter.UniversityAdapter

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, HomeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        binding.univeristyList.run {
            adapter = UniversityAdapter(requireContext())
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.listData.observe(viewLifecycleOwner) {
            setList(it)
        }
    }

    private fun setList(list: ArrayList<University>) {
        (binding.univeristyList.adapter as? UniversityAdapter)?.setDataList(list)
    }
}