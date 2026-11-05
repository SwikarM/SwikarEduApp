package com.example.swikareduapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for managing database operations on the "users" table.
 */
@Dao
interface AppDao {

    /**
     * Inserts a new user into the database.
     * Runs asynchronously on a background thread via Kotlin Coroutines.
     */
    @Insert
    suspend fun insert(user: User)

    /**
     * Retrieves all users from the "users" table, ordered by ID descending.
     * Returns a Flow that emits updated user lists automatically whenever table data changes.
     */
    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): Flow<List<User>>

    /**
     * Deletes all user records from the "users" table.
     * Runs asynchronously on a background thread via Kotlin Coroutines.
     */
    @Query("DELETE FROM users")
    suspend fun deleteAll()

}
