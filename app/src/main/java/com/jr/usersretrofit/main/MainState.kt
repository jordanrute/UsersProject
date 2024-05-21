package com.jr.usersretrofit.main

import com.jr.usersretrofit.data.local.entity.ProjectEntity
import com.jr.usersretrofit.ui.User

data class MainState(
    val selectedProject: ProjectEntity? = null,
    val users: List<User> = emptyList(),
    val projects: List<ProjectEntity> = emptyList()
)
