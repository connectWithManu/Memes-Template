package com.manu.memeappretrofitmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manu.memeappretrofitmvvm.repository.MemesRepository
import com.manu.memeappretrofitmvvm.viewmodel.MemesViewModel

class MemesViewModelFactory(private val memesRepository: MemesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepository) as T
    }

}