package de.poloczek.carcosttracker.domain.service

import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.port.`in`.CreateRefuelingUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetAllRefuelingsUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetRefuelingByIdUseCase
import de.poloczek.carcosttracker.domain.port.out.GetRefuelingByIdPort
import de.poloczek.carcosttracker.infrastructure.database.inmomery.RefuelingListDatabase
import java.time.LocalDate

class RefuelingService(
    private val refuelingListDatabase: RefuelingListDatabase,
) : CreateRefuelingUseCase, GetAllRefuelingsUseCase, GetRefuelingByIdUseCase {

    override fun createRefueling(refueling: Refueling): Long {
        return refuelingListDatabase.createRefueling(refueling)
    }

    override fun getAllRefuelings(): List<Refueling> {
        return refuelingListDatabase.getAllRefuelings()
    }

    override fun getRefuelingById(id: Long): Result<Refueling> {
        val result = refuelingListDatabase.getRefuelingById(id)
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
