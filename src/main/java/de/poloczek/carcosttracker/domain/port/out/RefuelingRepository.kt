package de.poloczek.carcosttracker.domain.port.out

import de.poloczek.carcosttracker.domain.model.Refueling

interface RefuelingRepository {

    fun createRefueling(refueling: Refueling): Long
    fun getAllRefuelings(): List<Refueling>
    fun getRefuelingById(id: Long): Refueling?

}