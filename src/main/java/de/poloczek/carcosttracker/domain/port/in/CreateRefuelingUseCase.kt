package de.poloczek.carcosttracker.domain.port.`in`

import de.poloczek.carcosttracker.domain.model.Refueling

interface CreateRefuelingUseCase {
    fun createRefueling(refueling: Refueling): Long
}