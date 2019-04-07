package com.example.project2

import android.util.Log
import java.io.Serializable

class GroceryListModel : Serializable{
    private var GroceryList: ArrayList<ItemListModel> = ArrayList()

    fun getLists() : ArrayList<ItemListModel> {
        return GroceryList
    }

    fun addItemToList(idx: Int, index: Int, name: String, quantity: Int, price: Double) {
        GroceryList[idx].addItem(index, name, quantity, price)
    }

    fun addList(name: String){
        GroceryList.add(ItemListModel(name))
    }

    fun removeList(index: Int) : Boolean {
        if( GroceryList.isEmpty() )
            return false
        else {
            Log.e("GroceryList" , "Deleting: ${GroceryList[index]}" )
            GroceryList.removeAt(index)
        }

        Log.e("GroceryList", "List deleted" )
        return true
    }
}