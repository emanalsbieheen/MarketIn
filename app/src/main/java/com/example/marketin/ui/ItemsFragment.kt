package com.example.marketin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketin.R
import com.example.marketin.databinding.FragmentItemsBinding
import com.example.marketin.presentation.MainViewModel
import com.example.marketin.presentation.MainViewModelFactory
import com.example.marketin.sourcedata.ItemResponse
import com.example.marketin.sourcedata.network.ItemApi
import com.example.marketin.sourcedata.repositories.ItemRepositoryImp
import com.example.marketin.usecases.HandelDataState
import dagger.hilt.android.AndroidEntryPoint



class ItemsFragment : Fragment(R.layout.fragment_items) {

    lateinit var binding: FragmentItemsBinding
    private val repository=ItemRepositoryImp()

  private val factory=MainViewModelFactory(repository)


    private val viewModel: MainViewModel by activityViewModels { factory }


       private val adapter by lazy { ItemsAdapter(requireContext()){it->
        viewModel.itemDetail(it)
           findNavController().navigate(R.id.action_itemsFragment_to_detailsFragment)
       } }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentItemsBinding.bind(view)

        binding.itemRecycle.adapter= adapter
        binding.itemRecycle.layoutManager= LinearLayoutManager(requireContext())



        viewModel.getItems()
      viewModel._remotedata.observe(viewLifecycleOwner,{ recievedata ->
          itemResponse(recievedata)
      })


    }

        private fun itemResponse( state : HandelDataState<ItemResponse>){

          when( state){


              is HandelDataState.Success -> {

                  if (state.data!=null){

                     adapter.data=state.data





                  }
              }

              is HandelDataState.Error-> Toast.makeText(requireContext(),"No data ", Toast.LENGTH_LONG).show()



          }

        }





}