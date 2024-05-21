package com.jr.usersretrofit.data

import com.jr.usersretrofit.data.local.dao.ProjectDao
import com.jr.usersretrofit.data.local.dao.TeamMemberDao
import com.jr.usersretrofit.data.local.dao.UserDao
import com.jr.usersretrofit.data.local.entity.ProjectEntity
import com.jr.usersretrofit.data.remote.UsersApi
import com.jr.usersretrofit.ui.User

class UsersRepository(
    val api: UsersApi,
    val usersDao: UserDao,
    val projectDao: ProjectDao,
    val teamMemberDao: TeamMemberDao,
) {
    suspend fun getUsers(): Result<List<User>> {
        return try {
            Result.success(
                api.getUsers().map { v -> User(id = v.id, name = v.name, phone = v.phone) })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun saveProjects(projects: List<ProjectEntity>) {
        projectDao.insertProjects(projects)
    }

    suspend fun getProjects(): List<ProjectEntity> {
        return projectDao.getAllProjects()
    }

}