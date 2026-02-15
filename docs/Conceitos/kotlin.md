# Conceitos de Kotlin

## DSL e Gradle
- **Arquivos** `build.gradle.kts` e `settings.gradle.kts` usam Kotlin como DSL para configuração.
- **DSLs customizadas** permitem configurações mais expressivas e type-safe.
- Type-safe builders para criar estruturas de dados declarativas.

## Null-safety e tipos
- **Tipagem** previne `NullPointerException` na maior parte dos casos.
- Distinção entre `T` (não-nulo) e `T?` (nullable).
- **Operador Elvis** `?:` fornece valor padrão se null.

## Coroutines e concorrência
- **Kotlin Coroutines** oferecem modelo leve para concorrência assíncrona.
- **`suspend`** marca funções que podem ser suspensas.
- **`Flow`** para streams de dados assincronamente.
- `launch`, `async`, e `runBlocking` para diferentes contextos.

## Sealed Classes e Type Hierarchies
- **`sealed class`** restringe herança a subclasses conhecidas.
- Ideal para enums estendidos e expressões algébricas.
- **Pattern matching** com `when` garante exaustividade.

## Delegação e Lazy Properties
- **Propriedades `lazy`** avalia uma vez; eficiente para inicialização cara.
- **Delegação** com `by` permite delegar implementação.
- Exemplo: `class Derived(base: Base) : Base by base { }`.

## Operator Overloading
- **Defina `operator fun plus(other: T): T`** para usar `+` em tipos customizados.
- **Operadores**: `+`, `-`, `*`, `/`, `[]`, `in`, `is`.
- **Melhora legibilidade** quando bem aplicado.

## Interoperabilidade e migração
- **Projetos Java** podem adotar Kotlin gradualmente.
- **Estruturas de pacote** e APIs permanecem compatíveis.
- Java code chama Kotlin naturalmente; Kotlin chama Java sem problemas.

## Padrões e uso prático
- Use `data class` para DTOs simples.
- **Extensions** para utilitários; mantém código claro ao interoperar com Java.
- **Sealed classes** para modelar variações de um tipo com segurança.
- **Delegação** reduz boilerplate em wrappers e decoradores.
- Operator overloading melhora legibilidade quando bem aplicado.
