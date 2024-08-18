package de.poloczek.carcosttracker.domain.port.out

import de.poloczek.carcosttracker.domain.model.Refueling

interface CreateRefuelingPort {
    fun createRefueling(refueling: Refueling): Long
}