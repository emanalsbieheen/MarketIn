package com.example.marketin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marketin.databinding.RowstyleBinding
import com.example.marketin.sourcedata.ItemResponse
import com.example.marketin.sourcedata.Items

class ItemsAdapter( val context: Context , val listener:(Items?  )->Unit):RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    var data:ItemResponse?=null
        set(value) {
            field = value
            notifyDataSetChanged()
        }


  inner class ViewHolder(val binding: RowstyleBinding):RecyclerView.ViewHolder(binding.root){

       val name:TextView=binding.itemName
       val icon:ImageView=binding.imageView



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder(RowstyleBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: ItemsAdapter.ViewHolder, position:Int) {

        holder.name.text= data?.results?.get(position)?.name
            Glide.with(context).load(data?.results?.get(position)?.image_urls?.get(0)).into(holder.icon
                  )
        holder.itemView.setOnClickListener { listener(data?.results?.get(position))  }





    }

    override fun getItemCount()= data?.results?.size?:0


}