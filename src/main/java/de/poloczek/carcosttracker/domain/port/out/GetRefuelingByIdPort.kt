package de.poloczek.carcosttracker.domain.port.out

import de.poloczek.carcosttracker.domain.model.Refueling

interface GetRefuelingByIdPort {
    fun getRefuelingById(id: Long): Refueling?
}