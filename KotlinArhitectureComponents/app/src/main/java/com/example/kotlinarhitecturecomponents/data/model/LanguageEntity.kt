package com.example.kotlinarhitecturecomponents.data.model


class LanguageEntity(){
    var id: Int = 0
    var languageName: String? = null
    var created_at: String? = null
    var updated_at: String? = null

    constructor(id: Int, languageName: String?, created_at: String?, updated_at: String?) : this(){
        this.id = id
        this.languageName = languageName
        this.created_at = created_at
        this.updated_at = updated_at
    }

    constructor(languageName: String): this(){
        this.languageName = languageName
    }
}

