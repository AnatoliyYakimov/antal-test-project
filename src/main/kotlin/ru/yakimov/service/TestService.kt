package ru.yakimov.service

import org.springframework.stereotype.Service
import ru.yakimov.dto.TestDto
import ru.yakimov.mapper.TestMapper
import ru.yakimov.persistence.repository.TestRepository
import java.util.*

@Service
class TestService(
        private val testRepository: TestRepository,
        private val testMapper: TestMapper
) : CrudService<TestDto, UUID> {
    override fun save(dto: TestDto): UUID? {
        return testRepository.save(testMapper.toEntity(dto)).id
    }

    override fun update(id: UUID, dto: TestDto): TestDto {
        var entity = testMapper.toEntity(id, dto)
        entity = testRepository.save(entity)
        return testMapper.toDto(entity)
    }

    override fun findById(id: UUID): Optional<TestDto?> {
        return testRepository.findById(id)
                .map(testMapper::toDto)
    }

    override fun findAll(): Iterable<TestDto?> {
        return testRepository.findAll()
                .map(testMapper::toDto)
                .toList()
    }

    override fun deleteById(id: UUID) {
        testRepository.deleteById(id)
    }

}
