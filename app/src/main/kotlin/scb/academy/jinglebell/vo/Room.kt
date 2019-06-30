package scb.academy.jinglebell.vo

import androidx.annotation.DrawableRes

data class Room(
    val name: String,
    val price: Float,
    val location: String,
    @DrawableRes val imagePath: Int
)