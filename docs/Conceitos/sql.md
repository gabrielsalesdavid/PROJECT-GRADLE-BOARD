# Conceitos de SQL e Migrations

## Modelagem e normalização
- **Normalização (1NF, 2NF, 3NF)** ajuda a evitar redundância e inconsistência dos dados.
- **Desnormalização controlada** pode melhorar performance em casos OLAP (Online Analytical Processing).
- **Entity-Relationship (ER)** modelagem para design de esquema.

## Integridade e chaves
- **Chaves primárias (`PRIMARY KEY`)** e **estrangeiras (`FOREIGN KEY`)** garantem relacionamentos.
- **Cascata**: `ON DELETE CASCADE`, `ON UPDATE CASCADE` propaga mudanças.
- **Integridade referencial**: previne orfandade de dados.

## Transações e isolamento
- **Níveis de isolamento**: `READ UNCOMMITTED`, `READ COMMITTED`, `REPEATABLE READ`, `SERIALIZABLE`.
- **Trade-off**: isolamento alto reduz concorrência; isolamento baixo risco inconsistência.
- **ACID**: Atomicity, Consistency, Isolation, Durability.

## Window Functions
- **ROW_NUMBER(), RANK(), DENSE_RANK()**: ranking sem agrupamento.
- **LAG(), LEAD()**: acessa linhas anteriores/posteriores.
- **Útil para**: análise temporal, running totals, ranking.
- Permite cálculos sem agrupar result set.

## Recursive Queries e CTEs
- **Common Table Expressions (CTEs)**: `WITH cte AS (SELECT ...) SELECT ... FROM cte`.
- **Recursivas**: para hierarquias, trees, grafos.
- Melhora legibilidade e manutenibilidade.

## Performance Tuning
- **Índices**: aceleram `SELECT` mas desaceleram `INSERT`, `UPDATE`, `DELETE`.
- **`EXPLAIN` ou `EXPLAIN ANALYZE`**: profile queries; identifique gargalos.
- **Evite `SELECT *`**: seja específico com colunas necessárias.
- **Denormalização controlada** em OLAP; manter normalização em OLTP.

## Particionamento e Sharding
- **Particionamento**: dividir tabela grande (range, lista, hash).
- **Sharding**: distribuir dados entre múltiplos servidores.
- Considere complexity; use quando volume justifique.

## Migrações com Liquibase
- **Changelogs**: YAML/SQL (vê-se `db.changelog-master.yml` no repositório).
- **Estratégia**: mudanças incrementais, versionadas, em controle de versão.
- **Rollback capability**: facilita desfazer mudanças.

## Boas práticas para produção
- **Teste migrações** em staging antes de aplicar em produção.
- **Operações DDL pesadas**: evite em janelas de pico.
- **Scripts seguros e idempotentes** para re-execução sem erro.
- **Documente esquema** com comentários; ferramentas como SchemaCrawler geram docs.
- **Backups regulares** e testes de recovery.
- **Monitoramento**: query logs, índices não utilizados, espaço em disco.
