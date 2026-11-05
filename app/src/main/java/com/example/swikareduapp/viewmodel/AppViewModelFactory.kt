package com.example.swikareduapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swikareduapp.database.AppDao

/**
 * Factory class for instantiating [AppViewModel] with a [AppDao] parameter.
 */
class AppViewModelFactory(private val dao: AppDao) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppViewModel(dao) as T
    }
}
