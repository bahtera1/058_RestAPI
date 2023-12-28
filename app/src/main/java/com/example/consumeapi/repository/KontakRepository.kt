package com.example.consumeapi.repository

import com.example.consumeapi.model.Kontak
import com.example.consumeapi.network.KontakService
import java.io.IOException
import java.lang.Exception

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>

    suspend fun insertKontak(Kontak:Kontak)

    suspend fun updateKontak(id:Int, Kontak: Kontak)

    suspend fun deleteKontak(id: Int)

    suspend fun getKontakById(id:Int):Kontak
}


class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun insertKontak(Kontak: Kontak) {
        kontakApiService.insertKontak(Kontak)
    }

    //update
    override suspend fun updateKontak(id: Int, Kontak: Kontak) {
        kontakApiService.updateKontak(id,Kontak)
    }

    override suspend fun deleteKontak(id: Int) {
        try{
            val response =kontakApiService.deleteKontak(id)
            if(!response.isSuccessful){
                throw IOException("Failed to delete kontak. HTTP status code: ${response.code()}")
            }
            else{
                response.message()
            }
        }catch (e:Exception){
            throw e
        }
    }

    override suspend fun getKontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }
}