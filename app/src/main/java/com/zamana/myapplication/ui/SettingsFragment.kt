package com.zamana.myapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zamana.myapplication.R
import com.zamana.myapplication.databinding.FragmentHome1Binding
import com.zamana.myapplication.databinding.FragmentHomeBinding
import com.zamana.myapplication.model.University
import com.zamana.myapplication.reposytory.SharedPreferencesRepository
import com.zamana.myapplication.ui.home.HomeViewModel
import com.zamana.myapplication.ui.home.HomeViewModelFactory
import com.zamana.myapplication.ui.home.adapter.UniversityAdapter

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentHome1Binding

    lateinit var viewModel: HomeViewModel

    private var parameterForDialog = 1

    lateinit var sharePreferences: SharedPreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentHome1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, HomeViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharePreferences = SharedPreferencesRepository(requireContext())
        binding.userName.text = sharePreferences.getUserName()
        viewModel.getData()
        binding.univeristyList.run {
            adapter = UniversityAdapter(requireContext())
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.listData.observe(viewLifecycleOwner) {
            setList(it)
        }
        binding.showDialog.setOnClickListener {
            AddBottomSheetFragment().show(parentFragmentManager, "")
        }
        binding.info1.onClickInfo = {
            AddDialog().show(parentFragmentManager, "")
        }
        binding.info2.onClickInfo = {
            AddBottomSheetFragment().show(parentFragmentManager, "")
        }
//        AddDialog().show(parentFragmentManager, "")
//        val view = DialogAddBinding.inflate(layoutInflater)
//        AlertDialog.Builder(requireContext())
//            .setView(view.root)
//            .setTitle(R.string.dialog_title)
//            .setCancelable(true)
//            .setPositiveButton(
//                R.string.dialog_ok_button
//            ) { dialog, _ ->
//                parameterForDialog = 2
//                view.textFromDialog.text
//            }
//
//            .setNeutralButton(R.string.dialog_dont_ok_button) { _, _ ->
//                parameterForDialog = 4
//            }
//            .setMessage(R.string.dialog_message)
//
//            .setNegativeButton(R.string.dialog_close_button) { _, _ ->
//                parameterForDialog = 3
//            }
//            .create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.options1 -> {
                Toast.makeText(requireContext(), R.string.dialog_close_button, Toast.LENGTH_LONG)
                    .show()
            }
            R.id.options2 -> {
                Toast.makeText(requireContext(), R.string.dialog_title, Toast.LENGTH_LONG).show()
            }
        }
        return true
    }

    private fun setList(list: ArrayList<University>) {
        (binding.univeristyList.adapter as? UniversityAdapter)?.setDataList(list)
    }
}