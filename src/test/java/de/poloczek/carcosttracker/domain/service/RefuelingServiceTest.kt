package de.poloczek.carcosttracker.domain.service

import de.poloczek.carcosttracker.domain.model.Identity
import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.port.out.RefuelingRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
class RefuelingServiceTest {

    @Mock
    private lateinit var refuelingRepository: RefuelingRepository

    @InjectMocks
    private lateinit var refuelingService: RefuelingService

    @Test
    fun `should return all refuelings`() {
        // Arrange
        val refuelings = listOf(
            Refueling(date = LocalDate.of(2024, 2, 23), odometer = 114752, cost = 50.12),
            Refueling(date = LocalDate.of(2024, 3, 17), odometer = 115218, cost = 20.56)
        )
        `when`(refuelingRepository.getAllRefuelings()).thenReturn(refuelings)

        // Act
        val result = refuelingService.getAllRefuelings()

        // Assert
        assertEquals(listOf<Refueling>(), result)
    }
}