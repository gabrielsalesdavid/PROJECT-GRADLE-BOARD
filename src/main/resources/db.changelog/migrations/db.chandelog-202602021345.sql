--liquibase formatted sql
--changeset gabriel:202602021345
--comment: boards table create

CREATE TABLE BOARDS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (255) NOT NULL
) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS