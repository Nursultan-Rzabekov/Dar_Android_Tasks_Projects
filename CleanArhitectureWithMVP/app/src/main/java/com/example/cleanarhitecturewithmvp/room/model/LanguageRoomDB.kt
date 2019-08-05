package com.example.cleanarhitecturewithmvp.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "languages_data_database")
class LanguageRoomDB() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "language_id")
    var id: Int = 0
    @ColumnInfo(name = "language_name")
    var languageName: String? = null

    var created_at: String? = null

    var updated_at: String? = null

    constructor(id: Int, languageName: String?) : this(){
        this.id = id
        this.languageName = languageName
    }

    constructor(languageName: String): this(){
        this.languageName = languageName
    }
}
