package com.example.project2

import android.util.Log
import java.io.Serializable

class ItemListModel : Serializable {

    private var name: String

    constructor (name: String) {
        this.name = name
    }

    var items: ArrayList<Item> = ArrayList()

    fun getName() : String {
        return name
    }

    fun addItem(index: Int, name: String, quantity: Int, price: Double){
        items.add(index, Item(name, quantity, price))
    }

    fun removeItem(index: Int) : Boolean {
        if( items.isEmpty() )
            return false
        else {
            Log.e("ItemModel" , "Deleting: ${items[index]}" )
            items.removeAt(index)
        }

        Log.e("ItemModel", "Item deleted" )
        return true
    }

    fun getTotal() : Double {
        var totals = 0.0

        for( item in items ){
            totals += (item.price * item.quantity)
        }

        return totals
    }

}

//var id : Int = 0
//var name : String = ""
//var quantity : Int = 1
//var price : Double = 0.0
//
//constructor(id:Int,name:String,quantity:Int,price:Double) {
//    this.id = id
//    this.name = name
//    this.quantity = quantity
//    this.price = price
//}