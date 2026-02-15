# Fundamentos de SQL

## Visão geral
- **SQL (Structured Query Language)** é a linguagem padrão para comunicação com bancos relacionais.
- Operações: consultas, inserções, atualizações e exclusões.
- Dialetos: MySQL, PostgreSQL, SQL Server, Oracle diferem em sintaxe e features.

## Comandos básicos
- **DDL (Data Definition Language)**: `CREATE TABLE`, `ALTER TABLE`, `DROP TABLE`.
- **DML (Data Manipulation Language)**: `SELECT`, `INSERT`, `UPDATE`, `DELETE`.
- **DCL (Data Control Language)**: `GRANT`, `REVOKE` para controle de acesso.

## Tipos de Dados
- **Numéricos**: `INT`, `BIGINT`, `DECIMAL(p,s)`, `FLOAT`, `DOUBLE`.
- **Strings**: `VARCHAR(n)` (comprimento variável), `CHAR(n)` (fixo), `TEXT` (grande texto).
- **Temporais**: `DATE`, `TIME`, `TIMESTAMP`, `DATETIME`.
- **Booleano**: `BOOLEAN` (algumas BD usam `TINYINT`).

## Constraints e Integridade
- **`PRIMARY KEY`**: identifica unicidade; uma por tabela.
- **`FOREIGN KEY`**: referencia PK de outra tabela.
- **`UNIQUE`**: força unicidade em coluna(s).
- **`NOT NULL`**: proíbe valores nulos.
- **`CHECK`**: valida condições em inserções/atualizações.
- **`DEFAULT`**: valor padrão para coluna se omitida.

## Cláusulas importantes
- **`WHERE`**: filtro de linhas.
- **`GROUP BY`**: agrupa resultados por coluna(s).
- **`HAVING`**: filtra grupos após agregação.
- **`ORDER BY`**: ordena resultados; `ASC` (padrão) ou `DESC`.
- **`JOIN`** (INNER, LEFT, RIGHT, FULL): combina dados de múltiplas tabelas.
- **`DISTINCT`**: remove duplicatas.
- **`LIMIT`**: restringe número de linhas retornadas.

## String Functions
- **Case**: `UPPER()`, `LOWER()`.
- **Trim**: `TRIM()`, `LTRIM()`, `RTRIM()`.
- **Substring**: `SUBSTR()`, `SUBSTRING()` (dialeto-dependente).
- **Concatenação**: `CONCAT()`, operador `||`.
- **Comprimento**: `LENGTH()`, `LEN()`.
- **Pattern matching**: `LIKE` com wildcards `%` (qualquer), `_` (um char).

## Funções de Agregação
- **`COUNT()`**: número de linhas.
- **`SUM()`**: soma de valores.
- **`AVG()`**: média de valores.
- **`MIN()`, `MAX()`**: menor e maior valor.
- **Use `GROUP BY`** para agrupar e agregar.

## Transações
- **`BEGIN`**: inicia transação.
- **`COMMIT`**: confirma mudanças.
- **`ROLLBACK`**: desfaz mudanças.
- **Isolamento**: `SET TRANSACTION ISOLATION LEVEL` controla comportamento.

## Índices e desempenho
- **Índices** aceleram `SELECT` mas desaceleram `INSERT`, `UPDATE`, `DELETE`.
- **Trade-off**: espaço em disco vs velocidade de leitura.
- **`EXPLAIN` ou `EXPLAIN ANALYZE`**: inspeciona plano de execução.

## Migrações
- **Liquibase**: ferramenta presente no repositório para controlar versões de esquema.
- Scripts SQL/YAML: mudanças incrementais e versionadas.
- **Sempre teste** migrações em ambiente de staging antes de produção.

## Boas práticas
- Scripts seguros e idempotentes para evitar erros em re-execução.
- Backup regularmente; teste recovery.
- Use `ALTER TABLE` com cautela em produção.
