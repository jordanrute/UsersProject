package com.jr.usersretrofit.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jr.usersretrofit.data.local.entity.TeamMemberEntity

@Dao
interface TeamMemberDao {

    @Query("SELECT * FROM team_members WHERE projectId == :projectId")
    suspend fun getTeamMembersForProject(projectId: Int): List<TeamMemberEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMiembro(teamMember: TeamMemberEntity)
}