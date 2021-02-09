package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentInstrucionBinding

class Instruction : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstrucionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_instrucion,container,false)
        binding.instructionsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instrucion_to_shoeList)
        )
        return binding.root
    }
}