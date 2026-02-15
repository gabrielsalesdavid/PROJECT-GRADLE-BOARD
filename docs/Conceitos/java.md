# Conceitos de Java

## Paradigmas e arquitetura
- **Orientação a objetos (OOP)** como fundamento: modelagem por entidades, responsabilidades e contratos.
- **Camadas**: apresentação (UI), serviço (`service`), persistência (`persistence/dao`) — padronizado no repositório.
- **MVC e versionamento de BD**: separação de responsabilidades.

## Gerenciamento de dependências e build
- **Gradle** (DSL Kotlin) para build e gestão de dependências. 
- Arquivos: `build.gradle.kts`, `settings.gradle.kts`.
- Resoluição de dependências: arquivo `libs.versions.toml` centraliza versões.

## Persistência e mapeamento
- **JPA/Hibernate**: entidades com `@Entity`, conversores (`AttributeConverter`) e DAOs/Repositories.
- **Transações**: `@Transactional` gerencia escopo de transação.
- Gerenciamento de conexão na camada de persistência.
- **Lazy loading vs Eager loading**: estratégias de carregamento de relacionamentos.

## Concorrência e desempenho
- **Threads nativas**, executors, e APIs concorrentes (`java.util.concurrent`).
- **ConcurrentHashMap** quando necessário; prefira imutabilidade.
- **ExecutorService** para pool de threads; `CompletableFuture` para composição assíncrona.
- **Sincronização**: `synchronized`, `volatile`, locks finos.

## Testes e qualidade
- **Testes unitários** com JUnit; separar testes unitários e de integração.
- **Análise estática**: SpotBugs, PMD, CheckStyle.
- **Cobertura de testes**: JaCoCo; busque alto percentual de cobertura.
- **TDD**: Test-Driven Development melhora design.

## SOLID e Design Patterns
- **S**ingle Responsibility: cada classe tem uma responsabilidade.
- **O**pen/Closed: aberta para extensão, fechada para modificação.
- **L**iskov Substitution: subtipos devem substituir supertipo sem quebrar contrato.
- **I**nterface Segregation: interfaces pequenas e específicas.
- **D**ependency Inversion: dependa de abstrações, não implementações.
- **Patterns**: Singleton, Factory, Strategy (visto em `MigrationStrategy`), Observer, Builder, Decorator.

## Generics avançados
- **Bounded wildcards**: `List<? extends Number>`, `List<? super Number>`.
- **PECS**: Producer Extends, Consumer Super — regra para definir wildcards.
- Resolução de variância em compilação.

## Annotations e metaprogramação
- **Anotações customizadas** com `@Target` e `@Retention`.
- **Processadores de anotação** para geração de código em tempo de compilação.
- **Spring** usa anotações extensivamente (@Service, @Repository, @Transactional).

## Reflexão e Introspection
- **APIs**: `Class`, `Method`, `Field`, `Constructor` permitem análise dinâmica.
- **Casos de uso**: frameworks de DI, serialização, testes.
- **Impacto de desempenho**: reflexão é lenta; cache quando possível.

## Observações relacionadas ao repositório
- A estrutura do projeto organiza `dto`, `service`, `persistence`, `ui`.
- Use strategy pattern para operações variáveis (ex.: `OffsetDateTimeConverter` é converter strategy).
- Anotações JPA (@Entity, @Column, @Id) definem metadados de mapeamento.
- **DAO genérico** reduz duplicação: `T findById(Long)`, `void save(T)`.
