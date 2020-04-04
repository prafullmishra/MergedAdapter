package com.wordmug.mergedadapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wordmug.mergedadapter.R
import kotlinx.android.synthetic.main.list_item_layout_first.view.name
import kotlinx.android.synthetic.main.list_item_layout_second.view.box

class SecondAdapter(private val entries: ArrayList<String>) :
    RecyclerView.Adapter<SecondAdapter.SecondHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout_second, parent, false)
        return SecondHolder(view)
    }

    override fun getItemCount() = entries.size

    override fun onBindViewHolder(holder: SecondHolder, position: Int) {
        holder.name.text = entries[position]
    }

    class SecondHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name

        init {
            view.box.setOnClickListener {
                Toast.makeText(
                    view.context,
                    "Item no. ${bindingAdapterPosition+1} of List 2",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}