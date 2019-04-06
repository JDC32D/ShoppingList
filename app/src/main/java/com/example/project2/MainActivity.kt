/*
Shopping List

Create a shopping list app where users can add, delete, modify items in their list as well as create multiple lists.

Main Page

User can create New lists by name.
When a list is deleted, all data is deleted with it. (must allow deletes)
When users select a list, present the items in it on the “List Page”


List Page

User can add, update, and delete items to their list
Can add an infinite number of items (need to have a button or operation to add items)
User can “check off” items they may have already picked up/looked at (indicate this somehow such as a checkmark.
This may require a drawable or image) optional
Each row should contain the following:
Item Name
Quantity
Price (optionally)
Provide a running total for the shopping list and keep it updated as items are added/removed
Running total should be the correct amount
Items List MUST be a Recycler View (cannot use ListView)


Add Item

Present a view to allow a user to add AND update an item
The view can be presented as a full screen or as a portion of the screen
View must have, at minimum, the following:
Item Name
Quantity
I would suggest adding a unique ID to these items for SQL/updating reasons
Modifying the same item will perform an update and NOT an insert
You can either delete items here, or on the “List Page”


Additional Requirements

You will use SQLite to store data (Room if you want to research yourself)
Support all orientations
Follow MVC design patterns (no data in the Activity and/or View)
Model properties cannot be modified directly from the Activity/View (must use private or private set for your model properties)
The Main Page and List Page must be separate screens


This project will take some time to complete.
While it is fairly strait forward, there are a lot of minor processes that you will have to consider and account for
(how to delete, how to update after a delete, removing/update rows on the view, etc.).
 */

package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_item.*

class MainActivity : AppCompatActivity() {

    var itemList = ItemModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up dummy values to test recycler view
        itemList.addItem(0, "Peaches", 1, 1.50)
        itemList.addItem(1, "Apples", 5, 2.00)
        itemList.addItem(2, "Oranges", 7, 8.00)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList)
        setRecyclerViewItemTouchListener()

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        totalView.text = itemList.getTotal().toString()
    }

    private fun setRecyclerViewItemTouchListener() {

        //1
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                //2
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                //3
                val position = viewHolder.adapterPosition
                itemList.removeItem(position)
                recyclerView.adapter!!.notifyItemRemoved(position)
                totalView.text = itemList.getTotal().toString()
            }
        }

        //4
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }


}

//        val context = this
//        btn_insert.setOnClickListener({
//            if(addItemName.text.toString().length > 0 && addItemPrice.text.toString().length > 0 ) {
//                var item = ItemModel(addItemName.text.toString(), addItemPrice.text.toString().toDouble())
//                var db = DatabaseHandler(context)
//                db.insertData(item)
//            }
//            else{
//                Toast.makeText(context,"Fill in all data values",Toast.LENGTH_SHORT).show()
//            }
//        })


//        val items: ArrayList<String> = ArrayList()
//        for (i in 1..10) {
//            items.add("Item #$i")
//        }