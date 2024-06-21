package com.example.sportsync

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        //view.findViewById<Button>(R.id.loginButton).setOnClickListener{view.findNavController().navigate(R.id.action_blankFragment_to_registerFragment)}
  return view
    }



}