# 📊 PROJECT-GRADLE-BOARD

Um **sistema de gerenciamento de tarefas tipo Kanban** desenvolvido em **Java** com suporte a **Kotlin** e integração com **SQL** para persistência de dados. O projeto demonstra arquitetura em camadas, padrões de design e boas práticas modernas.

## 📋 Tabela de Conteúdo

- [Visão Geral](#visão-geral)
- [Status do Projeto](#status-do-projeto)
- [Linguagens e Tecnologias](#linguagens-e-tecnologias)
- [Java](#-java)
- [Kotlin](#-kotlin)
- [SQL](#-sql)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Quick Start](#quick-start)
- [Próximos Passos](#próximos-passos)

---

## 🎯 Visão Geral

O **PROJECT-GRADLE-BOARD** é uma aplicação educacional que integra:

- ✅ **Backend em Java**: Lógica de negócio, camadas de serviço e persistência
- ✅ **Suporte Kotlin**: DSL Gradle, possibilidade de migração gradual
- ✅ **Banco de Dados**: Migrações versionadas com Liquibase
- ✅ **Testes**: Infraestrutura JUnit para qualidade de código
- ✅ **Build Gradle**: Gerenciamento moderno de dependências com Kotlin DSL

### Funcionalidades Principais

1. **Quadros (Boards)**: Crie e organize seus quadros de trabalho
2. **Colunas**: Defina etapas do workflow (Todo, In Progress, Done)
3. **Cards**: Representam tarefas individuais
4. **Bloqueios**: Marque cards como bloqueados com motivo

---

## 📊 Status do Projeto

| Aspecto | Status | Detalhes |
|--------|--------|----------|
| **Repositório** | ✅ Ativo | Branch: `main` |
| **Commits** | 1 | Commit inicial: `6ba1230` |
| **Documentação** | ✅ Completa | Fundamentos + Conceitos para cada linguagem |
| **Migrações BD** | ✅ Configuradas | Liquibase pronto |
| **Status Atual** | 📝 Em desenvolvimento | Pronto para desenvolvimento |

### ⚠️ Arquivos Pendentes de Commit
Os seguintes arquivos estão **não rastreados** e prontos para serem adicionados ao repositório:

```
📁 docs/                   - Documentações completas
   ├── Fundamentos/
   │   ├── java.md        - Guia de fundamentos Java
   │   ├── kotlin.md      - Guia de fundamentos Kotlin
   │   └── sql.md         - Guia de fundamentos SQL
   └── Conceitos/
       ├── java.md        - Guia avançado Java
       ├── kotlin.md      - Guia avançado Kotlin
       └── sql.md         - Guia avançado SQL

📁 src/                    - Código fonte do projeto
   ├── main/
   │   ├── java/org/example/  - Classes Java
   │   └── resources/         - Migrações Liquibase
   └── test/
       └── java/org/example/  - Testes unitários

📁 gradle/                 - Configurações Gradle
   ├── wrapper/
   └── libs.versions.toml

📁 app/                    - Módulo de aplicação
└── build.gradle.kts

📄 build.gradle.kts        - Build script principal
📄 settings.gradle.kts     - Configuração multi-módulo
📄 gradle.properties       - Propriedades do build
📄 gradlew                 - Gradle wrapper (Linux/Mac)
📄 gradlew.bat             - Gradle wrapper (Windows)
📄 .gitattributes          - Atributos Git
📄 README.md               - Este arquivo
```

### ✅ Como Fazer Commit

```bash
# Adicionar todos os arquivos
git add .

# Criar commit com mensagem descritiva
git commit -m "Adicionar documentação completa, estrutura de projeto e configuração Gradle

- Documentação de Fundamentos: Java, Kotlin, SQL
- Documentação de Conceitos Avançados: Java, Kotlin, SQL
- Estrutura de camadas: DTO, Service, DAO, UI
- Configuração Gradle com Kotlin DSL
- Migrações Liquibase
- README principal consolidado"

# Enviar para repositório remoto
git push origin main
```

---

## 🛠️ Linguagens e Tecnologias

### 🔷 JAVA ☕

**Linguagem principal do projeto**. Implementa a lógica de negócio, camadas de serviço e persistência.

#### 📖 Fundamentos de Java
- **Visão geral**: Java OOP, tipada estaticamente, multiplataforma
- **Ambiente**: JDK, compilação com `javac`, execução com `java`
- **Sintaxe básica**: Pacotes, classes, tipos primitivos, referências
- **Controle de fluxo**: if/else, switch, loops, try/catch
- **Conceitos essenciais**: Herança, polimorfismo, encapsulamento, interfaces
- **Collections API**: List, Set, Map com operações funcionais
- **Lambdas e Streams**: Programação funcional fluente
- **Generics**: Type safety com `List<String>`, `Map<K,V>`
- **Anotações**: @Override, @FunctionalInterface, @Deprecated
- **Reflexão**: Inspeção dinâmica de classes em runtime
- **Gerenciamento de Memória**: Garbage collection, try-with-resources
- **Boas Práticas**: Imutabilidade, Optional, camadas arquiteturais

Para mais detalhes: 📚 [docs/Fundamentos/java.md](docs/Fundamentos/java.md)

#### 🎓 Conceitos Avançados de Java
- **Paradigmas**: OOP, arquitetura em camadas (UI, Service, Persistence)
- **Gradle DSL**: Build com Kotlin, `build.gradle.kts`, `settings.gradle.kts`
- **Persistência**: JPA/Hibernate, @Entity, conversores, DAOs
- **Transações**: @Transactional, gerenciamento de conexão
- **Concorrência**: Threads, ExecutorService, CompletableFuture, ConcurrentHashMap
- **Testes**: JUnit, análise estática (SpotBugs, PMD), cobertura (JaCoCo)
- **SOLID**: Single Responsibility, Open/Closed, Liskov, Interface Segregation, Dependency Inversion
- **Design Patterns**: Singleton, Factory, Strategy, Observer, Builder, Decorator
- **Generics Avançados**: Bounded wildcards, PECS (Producer Extends, Consumer Super)
- **Metaprogramação**: Anotações customizadas, processadores de anotação, Spring annotations
- **Reflexão**: APIs java.lang.reflect, casos de uso, impacto de desempenho

Para mais detalhes: 📚 [docs/Conceitos/java.md](docs/Conceitos/java.md)

#### 🛠️ Tecnologias
| Ferramenta | Versão | Propósito |
|-----------|--------|----------|
| Gradle | Kotlin DSL | Build e gerenciamento de dependências |
| JDK | 11+ | Compilação e execução |
| JUnit | 4/5 | Testes unitários |
| Liquibase | Latest | Migrações de BD |
| JPA/Hibernate | Latest | ORM |

#### 📁 Estrutura de Pacotes
```
org/example/
├── dto/                  # Data Transfer Objects
│   ├── RBoardColumnDTO.java
│   ├── RBoardColumnInfoDTO.java
│   ├── RBoardDetailsDTO.java
│   └── RCardDetailsDTO.java
├── entity/               # Entidades JPA
│   ├── BlockEntity.java
│   ├── BoardColumnEntity.java
│   ├── BoardEntity.java
│   └── CardEntity.java
├── exception/            # Exceções customizadas
│   ├── CardBlockedException.java
│   ├── CardFinishedException.java
│   └── EntityNotFoundException.java
├── persistence/          # Camada de persistência
│   ├── dao/              # Data Access Objects
│   │   ├── BlockDAO.java
│   │   ├── BoardColumnDAO.java
│   │   ├── BoardDAO.java
│   │   └── CardDAO.java
│   ├── entity/           # Mapeamento relacional
│   ├── converter/        # Conversores customizados
│   │   └── OffsetDateTimeConverter.java
│   ├── config/           # Configurações de conexão
│   │   └── ConnectionConfig.java
│   ├── _enum/            # Enumerações
│   │   └── EBoardColumnKindEnum.java
│   └── migration/        # Estratégias de migração
│       └── MigrationStrategy.java
├── service/              # Camada de serviço
│   ├── BoardColumnQueryService.java
│   ├── BoardQueryService.java
│   ├── BoardService.java
│   ├── CardQueryService.java
│   └── CardService.java
├── ui/                   # Interface com usuário
│   ├── BoardMenu.java
│   └── MainMenu.java
└── Main.java             # Ponto de entrada
```

---

### 🟣 KOTLIN 🎯

**Linguagem moderna**, concisa e totalmente interoperável com Java. Desenvolvida pela JetBrains, é oficial para Android.

#### 📖 Fundamentos de Kotlin
- **Visão geral**: Moderna, concisa, null-safe, interoperável com Java
- **Ambiente**: Compilador `kotlinc`, integração Gradle, arquivos `.kt` e `.kts`
- **Sintaxe básica**: `fun`, `val` (imutável), `var` (mutável), tipos nullable `T?`
- **Operadores**: Safe call `?.`, Elvis `?:`, not-null assertion `!!`
- **String Templates**: Interpolação com `$variavel`
- **Funções**: Primeira classe, parâmetros padrão, named arguments
- **Collections**: `listOf()`, `mapOf()`, funções `filter()`, `map()`, `fold()`
- **Lambdas**: Sintaxe concisa `{ x -> x * 2 }`, trailing lambda
- **Scope Functions**: `let`, `run`, `apply`, `also`, `with` para transformações
- **Extension Functions**: Adicionar métodos a tipos existentes
- **Data Classes**: Boilerplate mínimo para DTOs
- **Boas Práticas**: Prefira `val`, evite `!!`, use extensions

Para mais detalhes: 📚 [docs/Fundamentos/kotlin.md](docs/Fundamentos/kotlin.md)

#### 🎓 Conceitos Avançados de Kotlin
- **DSL e Gradle**: `build.gradle.kts` com type-safe builders
- **Null-safety**: Design previne NullPointerException
- **Coroutines**: `suspend`, `Flow`, concorrência leve, assincronismo
- **Sealed Classes**: Restrição de herança, pattern matching com `when`
- **Delegação**: `by` para delegar implementação, reduz boilerplate
- **Lazy Properties**: Inicialização uma única vez
- **Operator Overloading**: Usar `+`, `-`, `[]` com tipos customizados
- **Interoperabilidade**: Java → Kotlin transparente, Kotlin → Java natural
- **Migração Gradual**: Projetos Java adotam Kotlin incrementalmente

Para mais detalhes: 📚 [docs/Conceitos/kotlin.md](docs/Conceitos/kotlin.md)

#### 💡 Exemplo: De Java para Kotlin

**Java:**
```java
public class User {
    private String name;
    private int age;
    
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}
```

**Kotlin:**
```kotlin
data class User(val name: String, val age: Int)
```

#### 🛠️ Uso em Gradle

```kotlin
// build.gradle.kts
plugins {
    kotlin("jvm") version "1.9.0"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
```

---

### 🗄️ SQL

**Gerenciamento de dados** com SQL e Liquibase para migrações versionadas.

#### 📖 Fundamentos de SQL
- **Visão geral**: Linguagem padrão para bancos relacionais (MySQL, PostgreSQL, SQL Server)
- **DDL**: `CREATE TABLE`, `ALTER TABLE`, `DROP TABLE`
- **DML**: `SELECT`, `INSERT`, `UPDATE`, `DELETE`
- **DCL**: `GRANT`, `REVOKE` para controle de acesso
- **Tipos de Dados**: INT, VARCHAR, DATE, TIMESTAMP, BOOLEAN
- **Constraints**: PRIMARY KEY, FOREIGN KEY, UNIQUE, NOT NULL, CHECK, DEFAULT
- **Cláusulas**: WHERE, GROUP BY, HAVING, ORDER BY, JOIN (INNER/LEFT/RIGHT/FULL)
- **String Functions**: UPPER, LOWER, TRIM, SUBSTRING, LENGTH, LIKE
- **Funções de Agregação**: COUNT, SUM, AVG, MIN, MAX
- **Transações**: BEGIN, COMMIT, ROLLBACK para consistência
- **Índices e Performance**: Aceleram SELECT, impactam INSERT/UPDATE/DELETE
- **Migrações**: Liquibase com changelogs YAML/SQL

Para mais detalhes: 📚 [docs/Fundamentos/sql.md](docs/Fundamentos/sql.md)

#### 🎓 Conceitos Avançados de SQL
- **Normalização**: 1NF, 2NF, 3NF evitam redundância
- **Integridade Referencial**: Foreign keys, CASCADE, relacionamentos
- **Transações**: Níveis de isolamento (READ UNCOMMITTED, READ COMMITTED, etc), ACID
- **Window Functions**: ROW_NUMBER, RANK, DENSE_RANK, LAG, LEAD
- **CTEs Recursivas**: `WITH cte AS (...)` para hierarquias e árvores
- **Performance Tuning**: EXPLAIN, índices, denormalização estratégica
- **Particionamento**: Dividir tabelas grandes por range, lista, hash
- **Sharding**: Distribuir dados entre servidores
- **Liquibase**: Migrações incrementais, versionadas, rollback capability
- **Boas Práticas Produção**: Teste staging, scripts idempotentes, backups

Para mais detalhes: 📚 [docs/Conceitos/sql.md](docs/Conceitos/sql.md)

#### 📊 Modelagem de Dados do Projeto

```sql
-- Quadros de trabalho
CREATE TABLE board (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_title (title)
);

-- Colunas do quadro (Todo, In Progress, Done)
CREATE TABLE board_column (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    board_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    position INT NOT NULL,
    kind VARCHAR(50),
    FOREIGN KEY (board_id) REFERENCES board(id) ON DELETE CASCADE,
    UNIQUE KEY uk_title_board (title, board_id)
);

-- Cards/Tarefas
CREATE TABLE card (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    column_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    position INT NOT NULL,
    finished BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (column_id) REFERENCES board_column(id) ON DELETE CASCADE
);

-- Bloqueios de cards
CREATE TABLE block (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    card_id BIGINT NOT NULL,
    reason VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (card_id) REFERENCES card(id) ON DELETE CASCADE
);
```

#### 📁 Estrutura de Migrações

```
src/main/resources/db/changelog/
├── db.changelog-master.yml              # Arquivo master
└── migrations/
    ├── db.changelog-202602021345.sql    # Migration 1
    ├── db.changelog-202602021442.sql    # Migration 2
    ├── db.changelog-202602021454.sql    # Migration 3
    ├── db.changelog-202602021501.sql    # Migration 4
    └── db.changelog-202602062004.sql    # Migration 5
```

#### 🔄 Padrão de Migração

```sql
-- Migration: 20260215101500
-- Description: Create initial schema

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_email ON users(email);
```

---

## 📁 Estrutura do Projeto

```
PROJECT-GRADLE-BOARD/
│
├── docs/                                  # Documentação completa
│   ├── Fundamentos/
│   │   ├── java.md                       # Java: Sintaxe, OOP, Collections
│   │   ├── kotlin.md                     # Kotlin: Sintaxe, Null-safety
│   │   └── sql.md                        # SQL: DDL, DML, Constraints
│   │
│   └── Conceitos/
│       ├── java.md                       # Java: Padrões, Arquitetura, SOLID
│       ├── kotlin.md                     # Kotlin: DSL, Coroutines
│       └── sql.md                        # SQL: Normalização, Performance
│
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── Main.java                 # Ponto de entrada
│   │   │   ├── dto/                      # Data Transfer Objects
│   │   │   ├── entity/                   # Entidades JPA
│   │   │   ├── exception/                # Exceções customizadas
│   │   │   ├── persistence/              # DAOs, Conversores, Config
│   │   │   ├── service/                  # Serviços de negócio
│   │   │   └── ui/                       # Interface com usuário
│   │   │
│   │   └── resources/
│   │       └── db/changelog/             # Migrações Liquibase
│   │           ├── db.changelog-master.yml
│   │           └── migrations/
│   │
│   └── test/
│       └── java/org/example/             # Testes unitários
│
├── gradle/
│   ├── wrapper/                          # Gradle Wrapper
│   └── libs.versions.toml                # Centralize versões
│
├── app/                                  # Módulo principal
│   └── build.gradle.kts                  # Configuração build
│
├── build.gradle.kts                      # Build script Gradle
├── settings.gradle.kts                   # Configuração multi-módulo
├── gradlew                               # Gradle wrapper (Linux/Mac)
├── gradlew.bat                           # Gradle wrapper (Windows)
├── gradle.properties                     # Propriedades Gradle
└── README.md                             # Este arquivo
```

---

## 🚀 Quick Start

### ✅ Pré-requisitos

- **JDK 11+**: [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **Git**: Para clonar/gerenciar repositório
- **IDE** (opcional): IntelliJ IDEA, Eclipse, VS Code

### 📥 Clonar Repositório

```bash
git clone https://github.com/gabrielsalesdavid/PROJECT-GRADLE-BOARD.git
cd PROJECT-GRADLE-BOARD
```

### 🔨 Build

```bash
# Build completo
./gradlew build

# Build sem testes
./gradlew build -x test

# Listar tasks disponíveis
./gradlew tasks
```

### ✅ Testes

```bash
# Executar todos os testes
./gradlew test

# Executar testes com relatório
./gradlew test --info
```

### ▶️ Executar Aplicação

```bash
./gradlew run
```

### 🔄 Migrações Banco de Dados

```bash
# Aplicar migrações Liquibase
./gradlew liquibaseUpdate

# Verificar status
./gradlew liquibaseStatus
```

---

## 🎯 Próximos Passos

### Para Desenvolvedores

- [ ] Implementar testes unitários adicionais
- [ ] Adicionar novos ServiçosDTO (quando aplicável)
- [ ] Considerar migração de código para Kotlin
- [ ] Implementar novos Design Patterns

### Para Aprendizado

- [ ] Estudar padrões SOLID aplicados no projeto
- [ ] Experimentar com Kotlin Coroutines
- [ ] Criar consultas SQL otimizadas
- [ ] Implementar novos Discovery Patterns

### Para Produção

- [ ] Configurar CI/CD (GitHub Actions, Jenkins)
- [ ] Adicionar monitoramento e logs estruturados
- [ ] Implementar cache (Redis)
- [ ] Documentar deployment
- [ ] Configurar variáveis de ambiente

---

## 📖 Recursos de Aprendizado

| Recurso | Links |
|---------|-------|
| **Java Oficial** | [oracle.com/java](https://www.oracle.com/java/) |
| **Kotlin Docs** | [kotlinlang.org](https://kotlinlang.org) |
| **SQL Reference** | [mysql.com/docs](https://dev.mysql.com/doc/) |
| **Gradle** | [gradle.org](https://gradle.org) |
| **JUnit** | [junit.org](https://junit.org) |
| **Liquibase** | [liquibase.org](https://www.liquibase.org) |

---

## 📧 Contato

Desenvolvido como parte da **Formação Java - DIO.me**

- Autor: Gabriel Sales David
- GitHub: [gabrielsalesdavid](https://github.com/gabrielsalesdavid)

---

## 📄 Licença

Este projeto é fornecido como material educacional.

---

---

## 📝 Histórico de Atualizações

| Data | Descrição | Status |
|------|-----------|--------|
| 15/02/2026 | Criação de documentação completa (Fundamentos + Conceitos) para Java, Kotlin e SQL | ✅ Concluído |
| 15/02/2026 | Estruturação de camadas: DTO, Service, DAO, UI | ✅ Concluído |
| 15/02/2026 | Configuração Gradle com Kotlin DSL | ✅ Concluído |
| 15/02/2026 | Setup de migrações Liquibase | ✅ Concluído |
| 15/02/2026 | README principal consolidado | ✅ Concluído |
| 15/02/2026 | **Aguardando**: Commit de arquivos para repositório remoto | ⏳ Pendente |

---

**Última atualização**: 15 de fevereiro de 2026  
**Branch**: `main`  
**Última sincronização remota**: Commit `6ba1230` (Initial commit)  
**Arquivos pendentes**: 13 arquivos não rastreados  
**Status**: ✅ Pronto para commit e push
