package com.example.project2.SQLattempt2

import android.database.sqlite.SQLiteConstraintException
import com.example.project2.ShoppingList
import kotlinx.coroutines.selects.select
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.insertOrThrow
import org.jetbrains.anko.db.select


class ListsPersistence(private val db: DatabaseHelper) {

    private fun shoppingListFor(listName: String) : ShoppingList {
        return db.use{
            select(ShoppingListSchema.TABLE_NAME)
                .whereSimple("${ShoppingListSchema.Cols.NAME} = ?", listName)
                .parseSingle(object : MapRowParser<ShoppingList> {
                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
                        val id = columns[ShoppingListSchema.Cols.ID] as Number
                        val name = columns[ShoppingListSchema.Cols.NAME] as String
                        return ShoppingList(id.toInt(), name)
                    }
                })
        }
    }

    fun getShoppingLists() : List<ShoppingList> {
        return db.use{
            select(ShoppingListSchema.TABLE_NAME)
                .parseList(object : MapRowParser<ShoppingList> {
                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
                        val id = columns[ShoppingListSchema.Cols.ID] as Number
                        val name = columns[ShoppingListSchema.Cols.NAME] as String
                        return ShoppingList(id.toInt(), name)
                    }
                })
        }
    }

    fun createShoppingList(name: String) : ShoppingList? {
       return db.use{
           try {
               insertOrThrow(ShoppingListSchema.TABLE_NAME, ShoppingListSchema.Cols.NAME to name)
               shoppingListFor(name)
           } catch (e: SQLiteConstraintException) {
               null
           }
       }
   }
}

//class ListsPersistence(private val db: DBHelper) {
//
//    fun getLists(): List<ShoppingList> {
//        return db.use {
//            select(ShoppingListSchema.TABLE_NAME)
//                .parseList(object : MapRowParser<ShoppingList> {
//                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
//                        val Store =  columns.get(ShoppingListSchema.Cols.STORE) as String?
//                        val Id = columns.get(ShoppingListSchema.Cols.ID) as Int?
//                        val Item = columns.get(ShoppingListSchema.Cols.ITEM) as String?
//                        val Count = columns.get(ShoppingListSchema.Cols.COUNT) as String?
//                        val Price = columns.get(ShoppingListSchema.Cols.PRICE) as String?
//                        return ShoppingList(Store, Id, Item, Count?.toInt(), Price?.toInt())
//                    }
//                })
//        }
//    }
//
//    fun createShoppingList(Store: String): ShoppingList?{
//        return db.use {
//            try {
//                insertOrThrow(ShoppingListSchema.TABLE_NAME, ShoppingListSchema.Cols.STORE to Store)
//                shoppingListFor(Store)
//            }catch (e: SQLiteConstraintException) {
//                null
//            }
//        }
//
//    }
//
//    //returns a list of items for a parent
//    fun shoppingListFor(listName: String): ShoppingList {
//        return db.use {
//            select(ShoppingListSchema.TABLE_NAME)
//                .whereSimple("${ShoppingListSchema.Cols.STORE} = ?", listName)
//                .parseSingle(object : MapRowParser<ShoppingList> {
//                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
//                        val Id = columns[ShoppingListSchema.Cols.ID] as Int?
//                        val Item = columns[ShoppingListSchema.Cols.ITEM] as String?
//                        val Count = columns[ShoppingListSchema.Cols.COUNT] as Int?
//                        val Price = columns[ShoppingListSchema.Cols.PRICE] as Int?
//                        val Store = columns[ShoppingListSchema.Cols.STORE] as String?
//                        return ShoppingList(Store, Id, Item, Count, Price)
//                    }
//                })
//        }
//
//    }
////    private fun shoppingListFor(listName: String) : ShoppingList {
////        return db.use{
////            select(ShoppingListSchema.TABLE_NAME,
////                "${ShoppingListSchema.Cols.STORE}", listName)
////
////    }
//
//    fun shoppingListFor(listId: Int): ShoppingList? {
//        return db.use {
//            select(ShoppingListSchema.TABLE_NAME)
//                .whereSimple("${ShoppingListSchema.Cols.ID} = ?", listId.toString())
//                .parseSingle(object : MapRowParser<ShoppingList> {
//                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
//                        val Store = columns[ShoppingListSchema.Cols.STORE] as String
//                        val Id = columns[ShoppingListSchema.Cols.ID] as Int?
//                        val Item = columns[ShoppingListSchema.Cols.ITEM] as String
//                        val Count = columns[ShoppingListSchema.Cols.COUNT] as Int?
//                        val Price = columns[ShoppingListSchema.Cols.PRICE] as Int?
//                        return ShoppingList(Store, Id, Item, Count, Price)
//                    }
//                })
//        }
//
//    }
//
//
//    fun getParentLists(): List<ShoppingList> {
//        return db.use {
//            select(ShoppingListSchema.TABLE_NAME)
//                .parseList(object: MapRowParser<ShoppingList> {
//                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
//                        val Id = columns[ShoppingListSchema.Cols.ID] as Number
//                        val Store = columns[ShoppingListSchema.Cols.STORE] as String
//                        return ShoppingList(Store, Id.toInt(), null, null, null)
//                    }
//                })
//        }
//    }
//
//    fun deleteParentList(deleteList: ShoppingList) {
//        db.use {
//            delete(ShoppingListSchema.TABLE_NAME, "${ShoppingListSchema.Cols.ID} = ?", arrayOf(deleteList.Id.toString()))
//        }
//    }
//
//    fun addChildItem(list: ShoppingList): ShoppingList? {
//        return db.use {
//            try {
//                insertOrThrow(
//                    ShoppingListSchema.TABLE_NAME,
//                    ShoppingListSchema.Cols.STORE to list.Store,
//                    ShoppingListSchema.Cols.ITEM to list.Item,
//                    ShoppingListSchema.Cols.COUNT to list.Count.toString(),
//                    ShoppingListSchema.Cols.PRICE to list.Price
//                )
//                itemInListWith(list.Item!!)
//            } catch (e: SQLiteConstraintException) {
//                null
//            }
//        }
//    }
//
//    fun itemInListWith(itemName: String): ShoppingList? {
//        return db.use {
//            select(ShoppingListSchema.TABLE_NAME)
//                .whereSimple("${ShoppingListSchema.Cols.ITEM} = ? ", itemName)
//                .parseSingle(object: MapRowParser<ShoppingList> {
//                    override fun parseRow(columns: Map<String, Any?>): ShoppingList {
//                        val Store = columns[ShoppingListSchema.Cols.STORE] as String
//                        val Id = columns[ShoppingListSchema.Cols.ID] as Number?
//                        val Item = columns[ShoppingListSchema.Cols.ITEM] as String
//                        val Count = columns[ShoppingListSchema.Cols.COUNT] as Number?
//                        val Price = columns[ShoppingListSchema.Cols.PRICE] as Number?
//
//                        return ShoppingList(Store, Id?.toInt(), Item, Count?.toInt(), Price?.toInt())
//
//                    }
//                })
//        }
//    }
//}
