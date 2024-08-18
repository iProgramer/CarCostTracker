package de.poloczek.carcosttracker.domain.port.`in`

import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.service.RefuelingService

interface GetRefuelingByIdUseCase {
    fun getRefuelingById(id: Long): RefuelingService.Result<Refueling>
}