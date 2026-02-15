--liquibase formatted sql
--changeset gabriel:202602021345
--comment: set unblock_reason nullable

ALTER TABLE boar.BLOCKS MODIFY
COLUMN unblock-reason VARCHAR(255) NULL;

--rollback ALTER TABLE boar.BLOCKS MODIFY COLUMN unblock-reason VARCHAR(255) NULL;