package ru.yakimov.dto

import ru.yakimov.constants.SortOrder
import java.time.LocalDate
import java.util.*

data class TestDto(
        val documentId: UUID? = null,
        val documentDate: LocalDate? = null,
        val dictionaryValueId: UUID? = null,
        val dictionaryValueName: String? = null,
        val sortOrder: SortOrder? = null,
        var testId: UUID? = null,
        var testName: String? = null
)
