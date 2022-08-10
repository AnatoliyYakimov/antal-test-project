package ru.yakimov.mapper;

import org.springframework.stereotype.Component
import ru.yakimov.dto.TestDto
import ru.yakimov.persistence.entity.TestEntity
import java.util.*

@Component
class TestMapper {
    fun toDto(entity: TestEntity): TestDto {
        return TestDto(
                documentId = entity.documentId,
                documentDate = entity.documentDate,
                dictionaryValueId = entity.dictionaryValueId,
                dictionaryValueName = entity.dictionaryValueName,
                sortOrder = entity.sortOrder,
                testId = entity.testId,
                testName = entity.testName
        )
    }
    fun toEntity(dto: TestDto): TestEntity {
        return TestEntity(
                documentId = dto.documentId,
                documentDate = dto.documentDate,
                dictionaryValueId = dto.dictionaryValueId,
                dictionaryValueName = dto.dictionaryValueName,
                sortOrder = dto.sortOrder,
                testId = dto.testId,
                testName = dto.testName
        )
    }
    fun toEntity(id: UUID, dto: TestDto): TestEntity {
        return TestEntity(
                entityId = id,
                new = false,
                documentId = dto.documentId,
                documentDate = dto.documentDate,
                dictionaryValueId = dto.dictionaryValueId,
                dictionaryValueName = dto.dictionaryValueName,
                sortOrder = dto.sortOrder,
                testId = dto.testId,
                testName = dto.testName
        )
    }
}
