package com.jr.usersretrofit.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jr.usersretrofit.data.UsersRepository
import com.jr.usersretrofit.data.local.entity.ProjectEntity
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: UsersRepository,
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            addProjects()
            val projects = repository.getProjects()
            state = state.copy(
                projects = projects
            )
        }
    }

    private fun saveProjects(projects: List<ProjectEntity>) {
        viewModelScope.launch {
            repository.saveProjects(projects)
        }
    }

    fun addProjects() {
        val projects = listOf(
            ProjectEntity(
                id = 1,
                name = "Proyecto Alpha",
                desc = "Desarrollo de una nueva funcionalidad."
            ),
            ProjectEntity(
                id = 2,
                name = "Proyecto Beta",
                desc = "Mejora del rendimiento del sistema."
            ),
            ProjectEntity(
                id = 3,
                name = "Proyecto Gamma",
                desc = "Investigación y desarrollo de nuevas tecnologías."
            ),
            ProjectEntity(
                id = 4,
                name = "Proyecto Delta",
                desc = "Implementación de pruebas automatizadas."
            ),
            ProjectEntity(
                id = 5,
                name = "Proyecto Epsilon",
                desc = "Rediseño de la interfaz de usuario."
            ),
            ProjectEntity(
                id = 6,
                name = "Proyecto Zeta",
                desc = "Integración de sistemas externos."
            ),
        )
        saveProjects(projects = projects)
    }
}