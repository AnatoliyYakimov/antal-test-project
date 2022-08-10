package ru.yakimov.persistence.repository

import org.springframework.data.repository.CrudRepository
import ru.yakimov.persistence.entity.TestEntity
import java.util.*

interface TestRepository : CrudRepository<TestEntity, UUID>
