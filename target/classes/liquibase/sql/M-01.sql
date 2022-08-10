CREATE TABLE TEST_ENTITY
(
    ID                    UUID PRIMARY KEY,
    DOCUMENT_ID           UUID,
    DOCUMENT_DATE         DATE,
    DICTIONARY_VALUE_ID   UUID,
    DICTIONARY_VALUE_NAME VARCHAR(255),
    SORT_ORDER            VARCHAR(4),
    TEST_ID               UUID,
    TEST_NAME             VARCHAR(255) NOT NULL DEFAULT 'Test'
);

--Добавим фильтры по ID полям, если подразумевается связь с другими таблицами. В большинстве случаев это даёт выигрыш.
--Но, опять же, надо смотреть каждый конкретный кейс в отдельности.

CREATE INDEX TEST_ENTITY_DOCUMENT_ID_IDX ON TEST_ENTITY(DOCUMENT_ID);

CREATE INDEX TEST_ENTITY_DICTIONARY_VALUE_ID_IDX ON TEST_ENTITY(TEST_ID);

CREATE INDEX TEST_ENTITY_TEST_ID_IDX ON TEST_ENTITY(TEST_ID);
