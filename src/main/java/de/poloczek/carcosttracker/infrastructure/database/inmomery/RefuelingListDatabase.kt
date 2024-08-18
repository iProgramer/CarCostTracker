package de.poloczek.carcosttracker.infrastructure.database.inmomery

import de.poloczek.carcosttracker.domain.model.Identity
import de.poloczek.carcosttracker.domain.model.Refueling
import de.poloczek.carcosttracker.domain.port.out.RefuelingRepository
import org.springframework.stereotype.Repository

@Repository
class RefuelingListDatabase : RefuelingRepository {

    companion object {
        private val refuelingMap: MutableMap<Long, Refueling> = mutableMapOf()
        private var counter: Long = 1
    }

    override fun createRefueling(refueling: Refueling): Long {
        refuelingMap[counter] = refueling.copy(id = Identity.LongIdentity(counter))
        return counter++
    }

    override fun getAllRefuelings(): List<Refueling> {
        return refuelingMap.values.toList()
    }

    override fun getRefuelingById(id: Long): Refueling? {
        return refuelingMap[id]
    }

}