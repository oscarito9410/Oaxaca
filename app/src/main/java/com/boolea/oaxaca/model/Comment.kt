package com.boolea.oaxaca.model

/**

Created by oscar on 15/05/19
operez@na-at.com.mx
 */
class Comment {
    var place_id: String? = ""
    var text: String? = ""
    var rating: Long = 0

    constructor(

    )

    constructor(place_id: String?, text: String?, rating: Long) {
        this.place_id = place_id
        this.text = text
        this.rating = rating
    }
}


