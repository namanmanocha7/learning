package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeViewModel
import com.udacity.shoestore.databinding.ShoeListInfBinding

class ShoeList : Fragment() {
        private val shoeViewModel:ShoeViewModel by activityViewModels<ShoeViewModel>()
   // private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        //shoeViewModel = ViewModelProvider(MainActivity()).get(ShoeViewModel::class.java)
        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                DataBindingUtil.inflate<ShoeListInfBinding>(
                    layoutInflater,
                    R.layout.shoe_list_inf,
                    binding.shoeListLayout,
                    true
                ).apply {
                    this.shoe = shoe

                }
            }
        })

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
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
            findNavController().navigate(R.id.action_shoeList_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }



}

