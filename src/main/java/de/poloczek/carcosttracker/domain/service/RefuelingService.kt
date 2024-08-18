package de.poloczek.carcosttracker.domain.service

import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.port.`in`.CreateRefuelingUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetAllRefuelingsUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetRefuelingByIdUseCase
import de.poloczek.carcosttracker.domain.port.out.RefuelingRepository

class RefuelingService(
    private val refuelingRepository: RefuelingRepository,
) : CreateRefuelingUseCase, GetAllRefuelingsUseCase, GetRefuelingByIdUseCase {

    override fun createRefueling(refueling: Refueling): Long {
        return refuelingRepository.createRefueling(refueling)
    }

    override fun getAllRefuelings(): List<Refueling> {
        return refuelingRepository.getAllRefuelings()
    }

    override fun getRefuelingById(id: Long): Result<Refueling> {
        val result = refuelingRepository.getRefuelingById(id)
        return if (result != null) {
            Result.Success(result)
        } else {
            Result.Error(ErrorCode.NOT_FOUND, "Refueling not found")
        }
    }

    sealed class Result<out T> {
        data class Success<out T>(val value: T) : Result<T>()
        data class Error(val errorCode: ErrorCode, val message: String? = null) : Result<Nothing>()
    }

    enum class ErrorCode {
        NOT_FOUND,
    }

}
