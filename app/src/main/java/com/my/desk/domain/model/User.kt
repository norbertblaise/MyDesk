package com.my.desk.domain.model

data class User(
    val fName: String,
    val lName: String,
    val email: String,

) {

    var userId: String? = null
}