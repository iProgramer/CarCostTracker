package de.poloczek.carcosttracker.application.config

import de.poloczek.carcosttracker.domain.model.Identity
import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.infrastructure.database.inmomery.RefuelingListDatabase
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AppDataSetup(val database: RefuelingListDatabase) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        database.createRefueling(Refueling(date = LocalDate.of(2024, 2, 23), odometer = 114752, cost = 50.12))
        database.createRefueling(Refueling(date = LocalDate.of(2024, 3, 17), odometer = 115218, cost = 20.56))
        database.createRefueling(Refueling(date = LocalDate.of(2024, 5, 9), odometer = 115863, cost = 10.89))

    }
}
