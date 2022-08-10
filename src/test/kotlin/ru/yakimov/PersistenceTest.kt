package ru.yakimov

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.yakimov.persistence.entity.TestEntity
import ru.yakimov.persistence.repository.TestRepository
import java.util.*

@SpringBootTest
class PersistenceTest

@Autowired
constructor(private val repository: TestRepository)
{

    @Test
    fun testSaveEntity() {
        val uuid = UUID.randomUUID()
        val entity = TestEntity(entityId = uuid)
        val savedEntity = repository.save(entity)
        assertEquals(entity, savedEntity)
        assertEquals(entity.hashCode(), savedEntity.hashCode())
        assertThat(repository.findAll()).hasSize(1);
    }

}
