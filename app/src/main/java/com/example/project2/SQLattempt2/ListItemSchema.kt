package com.example.project2.SQLattempt2

object ListItemSchema {
    const val TABLE_NAME = "ListItem"
    object Cols {
        const val ID = "id"
        const val NAME = "name"
        const val COUNT = "count"
        const val SHOP_LIST_ID = "shop_list_id"
    }

    fun sqlCreateString() : String {
        return """
            CREATE TABLE $TABLE_NAME(
                ${Cols.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${Cols.NAME} TEXT UNIQUE NOT NULL,
                ${Cols.COUNT} INTEGER NOT NULL DEFAULT(1),
                ${Cols.SHOP_LIST_ID} INTEGER NOT NULL,
                UNIQUE (${Cols.ID}, ${Cols.SHOP_LIST_ID}),
                FOREIGN KEY (${Cols.SHOP_LIST_ID})
                    REFERENCES ${ShoppingListSchema.TABLE_NAME}(${ShoppingListSchema.Cols.ID})
                    ON DELETE CASCADE
            );
        """.trimIndent()
    }
}