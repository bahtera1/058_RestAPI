package com.example.consumeapi.ui.kontak.screen

import com.example.consumeapi.navigation.DestinasiNavigasi

object EditDestination : DestinasiNavigasi {
    override val route ="edit"
    override val titleRes= "Edit Kontak"
    const val kontakId ="itemId"
    val routeWithArgs= "$route/{$kontakId}"
}