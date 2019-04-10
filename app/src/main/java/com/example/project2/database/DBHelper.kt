//package com.example.project2.database
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import com.example.project2.SQLattempt2.ShoppingListSchema
//import org.jetbrains.anko.db.*
//
//class DBHelper(context: Context): ManagedSQLiteOpenHelper(context.applicationContext, DB_NAME, null, DB_VERSION) {
//
//    init {
//        instance = this
//    }
//
//    companion object {
//        private var instance: DBHelper? = null
//
//        @Synchronized
//        fun getInstance(ctx: Context) = instance ?: DBHelper(ctx.applicationContext)
//
//        const val DB_NAME = "ShoppingList.sqLite"
//        const val DB_VERSION = 1
//    }
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        db?.createTable(
//            ShoppingListSchema.TABLE_NAME, true,
//            ShoppingListSchema.Cols.STORE to TEXT,
//            ShoppingListSchema.Cols.ID to INTEGER,
//            ShoppingListSchema.Cols.ITEM to TEXT,
//            ShoppingListSchema.Cols.COUNT to INTEGER,
//            ShoppingListSchema.Cols.PRICE to INTEGER
//
//        )
//        //db?.execSQL(ShoppingListSchema.sqlCreateString())
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//    }
//
//    // Access property for Context
//    val Context.db: DBHelper
//        get() = DBHelper.getInstance(this)
//
//}
//
