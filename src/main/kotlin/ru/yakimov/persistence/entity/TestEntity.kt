package ru.yakimov.persistence.entity

import ru.yakimov.constants.SortOrder
import ru.yakimov.persistence.AbstractJpaEntity
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
open class TestEntity(
        entityId: UUID = UUID.randomUUID(),
        new: Boolean = true,
        open val documentId: UUID? = null,
        open val documentDate: LocalDate? = null,
        open val dictionaryValueId: UUID? = null,
        open val dictionaryValueName: String? = null,
        @Enumerated(EnumType.STRING)
        open val sortOrder: SortOrder? = null,
        open var testId: UUID? = null,
        open var testName: String? = "Test"
) : AbstractJpaEntity<UUID>(entityId = entityId, new = new) {

}

