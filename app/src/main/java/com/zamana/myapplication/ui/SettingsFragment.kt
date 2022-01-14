package com.zamana.myapplication.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.zamana.myapplication.databinding.FragmentHome1Binding

private val IMAGE_URL =
    "https://media-exp1.licdn.com/dms/image/C561BAQExLW4Wf3dVAA/company-background_10000/0/1595001411699?e=2159024400&v=beta&t=zugeDQZW5uds0EaUScVI7vFQVn5_AP9osOJ92YAnAjs"

class SettingsFragment : Fragment() {

    lateinit var binding: FragmentHome1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentHome1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(IMAGE_URL).into(binding.imageView)
    }
}