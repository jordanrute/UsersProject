package com.jr.usersretrofit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "team_members")
data class TeamMemberEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val projectId: Int,
    val role: String,
)