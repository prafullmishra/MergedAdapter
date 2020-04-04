package com.wordmug.mergedadapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wordmug.mergedadapter.R
import kotlinx.android.synthetic.main.list_item_layout_first.view.box
import kotlinx.android.synthetic.main.list_item_layout_first.view.name

class FirstAdapter(private val entries: ArrayList<String>) :
    RecyclerView.Adapter<FirstAdapter.FirstHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout_first, parent, false)
        return FirstHolder(view)
    }

    override fun getItemCount() = entries.size

    override fun onBindViewHolder(holder: FirstHolder, position: Int) {
        holder.name.text = entries[position]
    }

    class FirstHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name
        init {
            view.box.setOnClickListener {
                    Toast.makeText(
                        view.context,
                        "Item no. ${bindingAdapterPosition+1} of List 1",
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }

}