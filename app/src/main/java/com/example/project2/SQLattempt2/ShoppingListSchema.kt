package com.example.project2.SQLattempt2

object ShoppingListSchema {
    const val TABLE_NAME = "ShoppingList"
    object Cols {
        const val ID = "Id"
        const val NAME = "Name"
    }

    fun sqlCreateString() : String {
        return """
        CREATE TABLE $TABLE_NAME (
            ${ShoppingListSchema.Cols.ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            ${ShoppingListSchema.Cols.NAME} TEXT UNIQUE NOT NULL
        );
        """.trimIndent()
    }
}


//object ShoppingListSchema {
//    const val TABLE_NAME = "list"
//    object Cols {
//        const val STORE = "Store"
//        const val ID = "Id"
//        const val ITEM = "Item"
//        const val COUNT = "Count"
//        const val PRICE = "Price"
//    }
//
//    fun sqlCreateString() : String {
//        return """
//        CREATE_TABLE $TABLE_NAME (
//            ${Cols.STORE} TEXT,
//            ${Cols.ID} INTEGER,
//            ${Cols.ITEM} TEXT,
//            ${Cols.COUNT} INTEGER,
//            ${Cols.PRICE} INTEGER
//        );
//        """.trimIndent()
//    }
//}

//const val TABLE_NAME = "ListItem"
//    object Cols {
//        const val ID = "id"
//        const val NAME = "name"
//        const val COUNT = "count"
//        const val PRICE = "price"
//        const val LIST_ID = "list_id"
//    }
//
//    fun sqlCreateString() : String {
//        return """
//            ${Cols.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
//            ${Cols.NAME} TEXT UNIQUE NOT NULL,
//            ${Cols.COUNT} INTEGER NOT NULL DEFAULT(1),
//            ${Cols.PRICE} DOUBLE NOT NULL DEFAULT(1.0),
//            ${Cols.LIST_ID} INTEGER NOT NULL,
//            UNIQUE (${Cols.ID}, ${Cols.LIST_ID}),
//            FOREIGN KEY (${Cols.LIST_ID})
//                REFERENCES ${ShoppingListSchema.TABLE_NAME}(${ShoppingListSchema.Cols.ID})
//                ON DELETE CASCADE
//        """.trimIndent()
//    }

//object ShoppingListSchema {
//    const val TABLE_NAME = "ShoppingList"
//    object Cols {
//        const val ID = "id"
//        const val NAME = "name"
//    }
//
//    fun sqlCreateString() : String {
//        return """
//            CREATE TABLE $TABLE_NAME {
//                ${Cols.ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
//                ${Cols.NAME} TEXT UNIQUE NOT NULL
//            };
//        """.trimIndent()
//    }
//}

//const val TABLE_NAME = "ListItem"
//    object Cols {
//        const val ID = "id"
//        const val NAME = "name"
//        const val COUNT = "count"
//        const val PRICE = "price"
//        const val LIST_ID = "list_id"
//    }
//
//    fun sqlCreateString() : String {
//        return """
//            ${Cols.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
//            ${Cols.NAME} TEXT UNIQUE NOT NULL,
//            ${Cols.COUNT} INTEGER NOT NULL DEFAULT(1),
//            ${Cols.PRICE} DOUBLE NOT NULL DEFAULT(1.0),
//            ${Cols.LIST_ID} INTEGER NOT NULL,
//            UNIQUE (${Cols.ID}, ${Cols.LIST_ID}),
//            FOREIGN KEY (${Cols.LIST_ID})
//                REFERENCES ${ShoppingListSchema.TABLE_NAME}(${ShoppingListSchema.Cols.ID})
//                ON DELETE CASCADE
//        """.trimIndent()
//    }