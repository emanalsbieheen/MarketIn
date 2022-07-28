package com.example.marketin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.marketin.R
import com.example.marketin.databinding.FragmentDetailsBinding
import com.example.marketin.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint




class DetailsFragment : Fragment(R.layout.fragment_details) {

    lateinit var binding: FragmentDetailsBinding

    private val viewmodeldetails:MainViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentDetailsBinding.bind(view)

     viewmodeldetails._itemdesc.observe(viewLifecycleOwner,{
         binding.itemprice.text=it.price
         binding.title.text=it.name
         Glide.with(requireContext()).load(it.image_urls[0]).into(binding.imageView1)
         Glide.with(requireContext()).load(it.image_urls_thumbnails[0]).into(binding.imageView2)

     })



    }

}