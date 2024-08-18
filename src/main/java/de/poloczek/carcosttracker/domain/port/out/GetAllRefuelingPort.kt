package de.poloczek.carcosttracker.domain.port.out

import de.poloczek.carcosttracker.domain.model.Refueling

interface GetAllRefuelingPort {
    fun getAllRefuelings(): List<Refueling>
}