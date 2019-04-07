package com.example.project2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(itemList: ItemListModel) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    var items = itemList.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemHolder, position: Int) {
        val currItem = items[position]
        holder.bindItem(currItem)
    }

    override fun getItemCount() = items.size

    class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var item: Item? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindItem(item: Item) {
            this.item = item
            view.textViewHead.text = item.name
            view.textViewDesc.text = item.quantity.toString()
        }

        companion object {
            private val ITEM_KEY = "ITEM"
        }
    }
}
