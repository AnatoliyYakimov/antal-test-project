package ru.yakimov.service

import java.util.*

interface CrudService<E, ID> {

    fun save(dto: E): ID?

    fun update(id: ID, dto: E): E?

    fun findById(id: ID): Optional<E?>

    fun findAll(): Iterable<E?>?

    fun deleteById(id: ID)

}
