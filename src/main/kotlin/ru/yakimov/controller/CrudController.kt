package ru.yakimov.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface CrudController<E, ID> {
    @PostMapping
    fun save(@RequestBody dto: E): ID?

    @PatchMapping(path = ["{id}"])
    fun update(@PathVariable("id") id: ID, @RequestBody dto: E): E?

    @GetMapping(path = ["{id}"])
    fun findById(@PathVariable("id") id: ID): ResponseEntity<E?>

    @GetMapping
    fun findAll(): Iterable<E?>?

    @DeleteMapping(path = ["{id}"])
    fun deleteById(@PathVariable("id") id: ID)
}
