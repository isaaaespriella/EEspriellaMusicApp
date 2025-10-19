package com.example.musicapp.services
import com.example.musicapp.models.Album
import com.example.musicapp.models.DataAlbum
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("api/albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("api/albums/{id}")
    suspend fun getAlbumById(@Path("id") id: Int): DataAlbum
}