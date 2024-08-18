package de.poloczek.carcosttracker.domain.model

sealed class Identity {

    fun getIdOrNull(): Long? {
        return when (this) {
            is LongIdentity -> this.id
            is NoIdentity -> null
        }
    }

    fun getIdOrThrow(): Long {
        return when (this) {
            is LongIdentity -> this.id
            is NoIdentity -> error("No id available.")
        }
    }

    class LongIdentity(val id: Long) : Identity()
    object NoIdentity : Identity()

}