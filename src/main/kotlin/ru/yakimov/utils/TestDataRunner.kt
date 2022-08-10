package ru.yakimov.utils

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ru.yakimov.constants.SortOrder
import ru.yakimov.persistence.entity.TestEntity
import ru.yakimov.persistence.repository.TestRepository
import java.time.LocalDate
import java.util.Random
import java.util.UUID
import java.util.stream.Collectors
import java.util.stream.Stream

@Component
class TestDataRunner(
        private val testRepository: TestRepository
) : CommandLineRunner {
    private val rnd : Random = Random()

    override fun run(vararg args: String?) {
        val entities = Stream.generate(this::generateRandomEntity)
                .limit(25)
                .collect(Collectors.toList())
        testRepository.saveAll(entities);
    }

    private fun generateRandomEntity(): TestEntity {

        val dictionaryId = UUID.randomUUID()
        val testId = UUID.randomUUID()
        return TestEntity(
                dictionaryValueId = dictionaryId,
                dictionaryValueName = "Document $dictionaryId",
                documentId = UUID.randomUUID(),
                documentDate = LocalDate.of(2022,rnd.nextInt(12) + 1,rnd.nextInt(28) + 1),
                sortOrder = if (rnd.nextBoolean()) SortOrder.ASC else SortOrder.DESC,
                testId = testId,
                testName = "Test $testId"
        )
    }
}
