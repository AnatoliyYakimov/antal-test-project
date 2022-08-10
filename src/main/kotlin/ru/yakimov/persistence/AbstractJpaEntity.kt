package ru.yakimov.persistence

import org.springframework.data.domain.Persistable
import java.io.Serializable
import java.util.Objects
import javax.persistence.*

@MappedSuperclass
abstract class AbstractJpaEntity<ID : Serializable>(
        @Id
        @Column(name = "ID")
        protected val entityId: ID,
        @Transient
        protected var new: Boolean = true
) : Persistable<ID> {

    @PostLoad
    @PostPersist
    fun setNotNew() {
        new = false
    }

    override fun getId(): ID? {
        return entityId
    }

    override fun isNew(): Boolean {
        return new
    }

    /**
     * Поле new не участвует в equals
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractJpaEntity<*>) return false

        if (entityId != other.entityId) return false

        return true
    }

    /**
     * Поле new не участвует в hashCode
     */
    override fun hashCode(): Int {
        return Objects.hashCode(entityId);
    }


}
