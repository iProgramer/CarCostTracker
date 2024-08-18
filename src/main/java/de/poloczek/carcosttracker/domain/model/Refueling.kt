package de.poloczek.carcosttracker.domain.model

import java.time.LocalDate

data class Refueling(
    val id: Identity = Identity.NoIdentity,
    val date: LocalDate,
    var odometer: Int,
    val cost: Double,
)
