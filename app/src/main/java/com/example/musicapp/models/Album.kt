package com.example.musicapp.models
import java.io.Serializable

data class Album(
    val id: Int,
    val title: String,
    val artist: String,
    val image: String
) : Serializable

data class DataAlbum(
    val id: Int,
    val title: String,
    val artist: String,
    val image: String,
    val description: String
) : Serializable

data class ArgAlbum(val id: Int) : Serializable
