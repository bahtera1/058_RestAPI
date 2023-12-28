package com.example.consumeapi.ui.theme


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumeapi.KontakAplication
import com.example.consumeapi.ui.kontak.home.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory= viewModelFactory {

        initializer {
            HomeViewModel(aplikasiMars().container.kontakRepository)
        }
    }
}

fun CreationExtras.aplikasiMars(): KontakAplication=
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplication)