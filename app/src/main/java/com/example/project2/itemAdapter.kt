package com.example.project2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

//class itemAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<itemAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false)
//        return ViewHolder(view)
//    }
//
//    // For every row, we will give you a position
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.itemName.text = items[position]
//    }
//
//    override fun getItemCount() = items.size
//
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val itemName: TextView = itemView.findViewById(R.id.itemName)
//    }
//}

//class itemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<itemAdapter.ViewHolder>() {
class itemAdapter(itemList: ItemModel) : RecyclerView.Adapter<itemAdapter.ItemHolder>() {

    var items = itemList.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemAdapter.ItemHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ItemHolder(view)
    }

    // For every row, we will give you a position
    override fun onBindViewHolder(holder: itemAdapter.ItemHolder, position: Int) {
        val currItem = items[position]
        holder.bindItem(currItem)
    }


    override fun getItemCount() = items.size

    //1
    class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var item: Item ? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindItem(item: Item) {
            this.item = item
            view.textViewHead.text = item.name
            view.textViewDesc.text = item.quantity.toString()
        }

        companion object {
            //5
            private val ITEM_KEY = "ITEM"
        }
    }

}