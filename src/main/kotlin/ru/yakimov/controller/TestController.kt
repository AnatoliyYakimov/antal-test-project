package ru.yakimov.controller;

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController;
import ru.yakimov.dto.TestDto
import ru.yakimov.service.TestService
import java.util.UUID

@RestController
@RequestMapping(path = ["/api/test"])
class TestController(
        testService: TestService
) : AbstractCrudController<TestDto, UUID>(testService)
