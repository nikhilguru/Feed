package com.nikhil.feed.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nikhil.feed.R

import com.nikhil.feed.entity.Row


class FeedAdapter(private val context: Context, private val rows: List<Row>) : RecyclerView.Adapter<FeedAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtTitle: TextView
        var txtDesc: TextView
        var img: ImageView


        init {
            txtTitle = view.findViewById<View>(R.id.txtTitle) as TextView
            txtDesc = view.findViewById<View>(R.id.txtDesc) as TextView
            img = view.findViewById<View>(R.id.img) as ImageView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val row = rows[position]

        if (row.title.isNullOrBlank()){
            holder.txtTitle.text = ""
        }else{
            holder.txtTitle.text =  row.title
        }

        if (row.description.isNullOrBlank()){
            holder.txtDesc.text = ""
        }else{
            holder.txtDesc.text =  row.description
        }

        if (row.imageHref.isNullOrBlank()){
            holder.img.setImageResource(R.drawable.noimg)
        }else{
            Glide.with(context).load(row.imageHref).into(holder.img)

        }

    }

    override fun getItemCount(): Int {
        return rows.size
    }

}