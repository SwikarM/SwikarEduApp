package com.example.swikareduapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * The Room database holder class serving as the main access point to the application data.
 * Declares all database entities and the database schema version.
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Returns the DAO for executing database operations.
     */
    abstract fun appDao(): AppDao

}
