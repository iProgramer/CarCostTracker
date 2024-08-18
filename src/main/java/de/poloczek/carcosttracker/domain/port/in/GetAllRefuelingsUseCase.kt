package de.poloczek.carcosttracker.domain.port.`in`

import de.poloczek.carcosttracker.domain.model.Refueling

interface GetAllRefuelingsUseCase {
    fun getAllRefuelings(): List<Refueling>
}