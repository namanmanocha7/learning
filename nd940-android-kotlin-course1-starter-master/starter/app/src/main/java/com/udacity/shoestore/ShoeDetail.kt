package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetail : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels<ShoeViewModel>()
   // private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail,
            container,
            false)
       // viewModel = ViewModelProvider(MainActivity()).get(ShoeViewModel::class.java)
       binding.shoeViewModel = viewModel
        binding.shoe = Shoe("",0.0,"","")
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menuu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.LoginFragment) {
            findNavController().navigate(R.id.action_shoeDetail_to_loginFragment)}
        return super.onOptionsItemSelected(item)
    }
}