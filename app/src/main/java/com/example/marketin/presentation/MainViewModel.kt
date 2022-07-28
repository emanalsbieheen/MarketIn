package com.example.marketin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketin.sourcedata.ItemResponse
import com.example.marketin.sourcedata.Items
import com.example.marketin.sourcedata.repositories.ItemRepositoryImp
import com.example.marketin.usecases.HandelDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



class MainViewModel (private val repository: ItemRepositoryImp   ):ViewModel() {


private val remotedata:MutableLiveData<HandelDataState<ItemResponse>> =MutableLiveData()

      val  _remotedata:LiveData<HandelDataState<ItemResponse>>
      get() = remotedata


    private val itemdesc:MutableLiveData<Items> = MutableLiveData()
    val _itemdesc:LiveData<Items>
    get() = itemdesc

   fun getItems(){

      viewModelScope.launch {
          try {

              val response:ItemResponse = repository.showItems()

              remotedata.postValue(HandelDataState.Success(response))

          }catch (e:Exception){


             remotedata.postValue(HandelDataState.Error(e.message!!.toString(), null))

          }



      }


   }

        fun itemDetail(itemdetail:Items?){

            itemdesc.value=itemdetail!!


        }

}