package com.example.sportsync.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.sportsync.models.AppDatabase
import User
import kotlinx.coroutines.launch


class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "app_database"
    ).build()

    fun registerUser(username: String, email: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            val existingUser = db.userDao.getUserByUsername(username)
            if (existingUser == null) {
                val user = User(username = username, email = email, password = password)
                db.userDao.insertUser(user)
                callback(true)
            } else {
                callback(false)
            }
        }
    }

    fun loginUser(username: String, password: String, callback: (User?) -> Unit) {
        viewModelScope.launch {
            val user = db.userDao.getUser(username, password)
            callback(user)
        }
    }
}
