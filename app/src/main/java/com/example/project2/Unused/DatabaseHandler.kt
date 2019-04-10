//package com.example.project2
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import org.jetbrains.anko.db.INTEGER
//import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
//import org.jetbrains.anko.db.PRIMARY_KEY
//import org.jetbrains.anko.db.TEXT
//
//class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "LibraryDatabase", null, 1) {
//    companion object {
//        private var instance: DatabaseHelper? = null
//
//        @Synchronized
//        fun Instance(context: Context): DatabaseHelper {
//            if (instance == null) {
//                instance = DatabaseHelper(context.applicationContext)
//            }
//            return instance!!
//        }
//    }
//
//    override fun onCreate(database: SQLiteDatabase) {
//        createTable(Book.TABLE_NAME, true, Book.COLUMN_ID to INTEGER + PRIMARY_KEY, Book.COLUMN_TITLE to TEXT, Book.COLUMN_AUTHOR to TEXT)
//    }
//
//    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        dropTable(Book.TABLE_NAME, true)
//    }
//}






//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//
//val DATABASE_NAME = "ShoppingListDB"
//val TABLE_NAME = "Items"
//val COL_ID = "id"
//val COL_NAME = "name"
//val COL_QUANTITY = "quantity"
//val COL_PRICE = "price"
//
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