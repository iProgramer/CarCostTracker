package de.poloczek.carcosttracker.application.controller

import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.port.`in`.CreateRefuelingUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetAllRefuelingsUseCase
import de.poloczek.carcosttracker.domain.port.`in`.GetRefuelingByIdUseCase
import de.poloczek.carcosttracker.domain.service.RefuelingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/refueling")
class RefuelingController(
    private val createRefuelingUseCase: CreateRefuelingUseCase,
    private val getAllRefuelingsUseCase: GetAllRefuelingsUseCase,
    private val getRefuelingByIdUseCase: GetRefuelingByIdUseCase,
) {

    @PostMapping("")
    fun createRefueling(@RequestBody refueling: Refueling): Long {
        return createRefuelingUseCase.createRefueling(refueling)
    }

    @GetMapping("")
    fun getAllRefuelings(): List<RefuelingResponse> {
        return getAllRefuelingsUseCase.getAllRefuelings()
            .map { refueling -> RefuelingResponse.fromRefueling(refueling) }
    }

    @GetMapping("/{id}")
    fun getRefuelingById(@PathVariable id: Long): ResponseEntity<Any> {
        return when (val refuelingResult = getRefuelingByIdUseCase.getRefuelingById(id)) {
            is RefuelingService.Result.Success -> ResponseEntity.ok(refuelingResult.value)
            is RefuelingService.Result.Error -> {
                ResponseEntity(refuelingResult.message, HttpStatus.NOT_FOUND)
            }
        }
    }
}

data class RefuelingResponse(
    val id: Long,
    val date: LocalDate,
    var odometer: Int,
    val cost: Double,
) {
    companion object {
        fun fromRefueling(refueling: Refueling): RefuelingResponse {
            return RefuelingResponse(
                id = refueling.id.getIdOrThrow(),
                date = refueling.date,
                odometer = refueling.odometer,
                cost = refueling.cost,
            )
        }
    }
}
