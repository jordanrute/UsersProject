package com.jr.usersretrofit.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.jr.usersretrofit.data.UsersRepository
import com.jr.usersretrofit.data.local.UsersDatabase
import com.jr.usersretrofit.data.remote.UsersApi
import com.jr.usersretrofit.main.MainViewModel
import com.jr.usersretrofit.main.MainScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(this,UsersDatabase::class.java,"users_db").build()
        val userDao = db.userDao
        val projectDao = db.projectDao
        val teamMemberDao = db.teamMemberDao
        val repository = UsersRepository(UsersApi.instance,userDao,projectDao,teamMemberDao)
        val viewModel = MainViewModel(repository)
        setContent {
            MainScreen(viewModel)
        }
    }
}
