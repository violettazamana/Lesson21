package com.zamana.myapplication.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zamana.myapplication.databinding.FragmentLoginBinding
import com.zamana.myapplication.ui.home.HomeViewModel
import com.zamana.myapplication.ui.home.HomeViewModelFactory
import com.zamana.myapplication.ui.home.adapter.UniversityAdapter
import com.zamana.myapplication.ui.login.adapter.LoginAdapter

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, LoginViewModelFactiory())
            .get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onSaveUser = {
            binding.loginText.setText("")
            binding.passwordText.setText("")
        }
        viewModel.showPhone = {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
        viewModel.showProgressBar = {
            binding.progressView.visibility = if (it) {
                View.VISIBLE
            } else View.GONE
        }
        binding.recyclerView.run {
            adapter = LoginAdapter(requireContext()) {
                viewModel.getPhone(it)
            }
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.list.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as LoginAdapter).setDataList(it)
        }
        binding.loginButton.setOnClickListener {
            viewModel.saveUser(
                binding.loginText.text.toString(),
                binding.passwordText.text.toString()
            )
        }
        viewModel.loadList()
    }
}