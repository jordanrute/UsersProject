package com.jr.usersretrofit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jr.usersretrofit.data.local.dao.ProjectDao
import com.jr.usersretrofit.data.local.dao.TeamMemberDao
import com.jr.usersretrofit.data.local.dao.UserDao
import com.jr.usersretrofit.data.local.entity.ProjectEntity
import com.jr.usersretrofit.data.local.entity.TeamMemberEntity
import com.jr.usersretrofit.data.local.entity.UserEntity

@Database(
    entities = [ProjectEntity::class, UserEntity::class, TeamMemberEntity::class],
    version = 1
)
abstract class UsersDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val projectDao: ProjectDao
    abstract val teamMemberDao: TeamMemberDao
}