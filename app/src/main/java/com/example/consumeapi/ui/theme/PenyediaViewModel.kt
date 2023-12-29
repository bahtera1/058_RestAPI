package com.example.consumeapi.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.consumeapi.KontakAplication
import com.example.consumeapi.ui.kontak.viewmodel.DetailsViewModel
import com.example.consumeapi.ui.kontak.viewmodel.EditViewModel
import com.example.consumeapi.ui.kontak.viewmodel.HomeViewModel
import com.example.consumeapi.ui.kontak.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasiKontak().container.kontakRepository)
        }
        initializer {
            InsertViewModel(aplikasiKontak().container.kontakRepository)
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                kontakRepository = aplikasiKontak().container.kontakRepository
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                kontakRepository = aplikasiKontak().container.kontakRepository
            )
        }


    }
}
fun CreationExtras.aplikasiKontak(): KontakAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as KontakAplication)