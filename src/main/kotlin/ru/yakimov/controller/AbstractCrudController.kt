package ru.yakimov.controller

import org.springframework.http.ResponseEntity
import ru.yakimov.service.CrudService

abstract class AbstractCrudController<E, ID>(
        protected val crudService: CrudService<E, ID>
) : CrudController<E, ID> {
    override fun save(dto: E): ID? {
        return crudService.save(dto);
    }

    override fun update(id: ID, dto: E): E? {
        return crudService.update(id, dto);
    }

    override fun findById(id: ID): ResponseEntity<E?> {
        return ResponseEntity.of(crudService.findById(id))

    }

    override fun findAll(): Iterable<E?>? {
        return crudService.findAll()
    }

    override fun deleteById(id: ID) {
        return crudService.deleteById(id)
    }
}
