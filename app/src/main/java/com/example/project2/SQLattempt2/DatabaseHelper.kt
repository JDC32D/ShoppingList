package com.example.project2.SQLattempt2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

class DatabaseHelper(context: Context):
    ManagedSQLiteOpenHelper(context.applicationContext, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(ShoppingListSchema.sqlCreateString())
        db?.execSQL(ListItemSchema.sqlCreateString())
    }

    override fun onOpen(db: SQLiteDatabase) {
        db?.setForeignKeyConstraintsEnabled(true)
        super.onOpen(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { }

    companion object {
        const val DB_NAME = "ShoppingList.sqLite"
        const val DB_VERSION = 1
    }
}

//class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "LibraryDatabase", null, 1) {
//
//    private val TABLE_LIST = "main_list"
//    private val TABLE_LIST_ID = "id"
//    private val TABLE_LIST_NAME = "name"
//
//    private val TABLE_CHILD_LIST = "child_list"
//    private val TABLE_CHILD_LIST_ID = "id"
//    private val TABLE_PARENT_LIST_ID = "parent_id"
//    private val TABLE_CHILD_LIST_NAME = "name"
//
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        val CREATE_MAIN_LIST_TABLE = ("CREATE TABLE " + TABLE_LIST + "("
//                + TABLE_LIST_ID + " INTEGER PRIMARY KEY,"
//                + TABLE_LIST_NAME + " TEXT" + ")")
//
//        val CREATE_TABLE_CHILD_LIST = ("CREATE TABLE " + TABLE_CHILD_LIST + "("
//                + TABLE_CHILD_LIST_ID + " INTEGER PRIMARY KEY,"
//                + TABLE_PARENT_LIST_ID + " INTEGER,"
//                + TABLE_CHILD_LIST_NAME + " TEXT" + ")")
//
//        db?.execSQL(CREATE_MAIN_LIST_TABLE)
//        db?.execSQL(CREATE_TABLE_CHILD_LIST)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//}