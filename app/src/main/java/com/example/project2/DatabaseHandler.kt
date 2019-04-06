//package com.example.project2
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//
//val DATABASE_NAME = "MyDB"
//val TABLE_NAME = "Items"
//val COL_NAME = "name"
//val COL_PRICE = "price"
//val COL_ID = "id"
//
//// Not passing cursor factory, so passing null
//class DatabaseHandler(var context: Context) : SQLiteOpenHelper(
//    context,DATABASE_NAME,null,1) {
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//
//        val createTable = "Create Table " + TABLE_NAME + " (" +
//                COL_ID +" Integer primary key autoincrement," +
//                COL_NAME + " VarChar(256)," +
//                COL_PRICE + " Double)";
//
//        db?.execSQL(createTable)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    fun insertData(item : ItemModel) {
//        val db = this.writableDatabase
//        var cv = ContentValues()
//        cv.put(COL_NAME, item.name)
//        cv.put(COL_PRICE, item.price)
//        var result = db.insert(TABLE_NAME, null, cv)
//        if (result == -1.toLong() )
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
//        else
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//
//    }
//
//}