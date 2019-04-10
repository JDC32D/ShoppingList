//package com.example.project2
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.snackbar.Snackbar
//import kotlinx.android.synthetic.main.activity_main.*
//
//class DetailListActivity : AppCompatActivity() {
//
//
//    private var selectedList: ItemListModel? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        selectedList = intent.getSerializableExtra(LIST_KEY) as ItemListModel
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ItemAdapter(selectedList ?: return)
//        setRecyclerViewItemTouchListener()
//
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//    }
//
//    companion object {
//        private const val LIST_KEY = "LIST"
//    }
//
//    private fun setRecyclerViewItemTouchListener() {
//
//        //1
//        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
//            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
//                //2
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
//                //3
//                val position = viewHolder.adapterPosition
//                selectedList?.removeItem(position)
//                recyclerView.adapter!!.notifyItemRemoved(position)
//                //totalView.text = itemList.getTotal().toString()
//            }
//        }
//
//        //4
//        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
//        itemTouchHelper.attachToRecyclerView(recyclerView)
//    }
//
//}
