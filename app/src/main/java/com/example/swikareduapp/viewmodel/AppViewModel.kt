package com.example.swikareduapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swikareduapp.database.AppDao
import com.example.swikareduapp.database.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for preparing and managing data for the UI layer,
 * delegating database operations to [AppDao].
 */
class AppViewModel(private val dao: AppDao) : ViewModel() {

    /**
     * Observable stream emitting the list of all users from the database in real-time.
     */
    val users: Flow<List<User>> = dao.getAllUsers()

    /**
     * Adds a new user record to the database with the given username.
     *
     * @param username The name of the user to insert.
     */
    fun addUser(username: String) {
        viewModelScope.launch {
            val user = User(username = username)
            dao.insert(user)
        }
    }

    /**
     * Clears all user records from the database.
     */
    fun clearUsers() {
        viewModelScope.launch {
            dao.deleteAll()
        }
    }
}
