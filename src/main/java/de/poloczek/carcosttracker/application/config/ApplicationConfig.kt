package de.poloczek.carcosttracker.application.config

import de.poloczek.carcosttracker.domain.service.RefuelingService
import de.poloczek.carcosttracker.infrastructure.database.inmomery.RefuelingListDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfig {

    @Bean
    open fun createRefuelService() = RefuelingService(RefuelingListDatabase())

}