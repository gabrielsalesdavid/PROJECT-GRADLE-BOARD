# Fundamentos de Kotlin

## Visão geral
- **Kotlin** é uma linguagem moderna, concisa e interoperável com Java.
- Muito usada para Android, como DSL (ex.: Gradle Kotlin DSL) e backend.
- Null-safe por design; elimina muitas classes de bugs comuns em Java.

## Ambiente e execução
- **Compilador**: `kotlinc` e integração com Gradle (plugins Kotlin).
- **Arquivos**: `.kt` (código fonte) e `.kts` (scripts).
- **Interoperabilidade**: Kotlin → Java é transparente; Java → Kotlin requer pouca adaptação.

## Sintaxe básica
- **Declaração**: `fun main() {}`; funções como blocos de código.
- **Variáveis**: `val` (imutável) e `var` (mutável).
- **Tipos e inferência**: `val x: Int = 1` ou `val x = 1` (tipo inferido).
- **Null-safety**: tipos nullable `String?` e operadores `?.` (safe call), `?:` (elvis), `!!` (not-null assertion).
- **String templates**: `"Hello, $name"` interpola variáveis diretamente.

## Funções e orientação a objetos
- **Funções de primeira classe**, extensões, data classes (`data class`), sealed classes.
- **Classes**: `class Nome(val propriedade: Type)` — construtores primários.
- **Modificadores**: similar a Java; `open` permite override por padrão (diferente de Java).

## Collections em Kotlin
- **Syntactic sugar**: `listOf()`, `setOf()`, `mapOf()`.
- **Funções de alta ordem**: `filter()`, `map()`, `reduce()`, `fold()`, `any()`, `all()`.
- **Diferença**: coleções imutáveis por padrão; use `mutableListOf()` etc. se necessário.
- **Destructuring**: decomposição de pares e listas via `(a, b) = pair`.

## Lambdas e Funções de Ordem Superior
- **Sintaxe**: `{ parametros -> resultado }` é mais concisa que Java.
- **Passagem de lambdas**: último argumento poder ser lambda fora dos parênteses.
- **Trailing lambdas**: `list.map { it * 2 }` em vez de `list.map({ it * 2 })`.

## Scope Functions
- **`let`**: executa bloco e retorna resultado.
- **`run`**: executa bloco em contexto do objeto e retorna resultado.
- **`apply`**: executa bloco e retorna o objeto (útil para inicialização).
- **`also`**: executa bloco e retorna o objeto (efeitos colaterais).
- **`with`**: similar a `run` mas sem nullable safety.

## Extension Functions
- **Extend tipos existentes** sem herança: `fun String.isValidEmail(): Boolean { ... }`.
- **Permitem código mais legível** e fluente.
- **Sem sobrecarga do método** em tipo original; apenas na chamada.

## Interoperabilidade com Java
- **Chamadas e uso de bibliotecas Java** sem grandes mudanças.
- **Configure corretamente o classpath** no Gradle.
- Conversão de tipos: listas Kotlin para Java e vice-versa são transparentes.

## Boas práticas rápidas
- Prefira `val` quando possível; use `data class` para DTOs simples.
- Evite `!!` salvo quando tiver certeza absoluta.
- Use scope functions para transformações; prefira `let` e `apply` em dados fluentes.
- Crie extensions para lógica reutilizável em tipos existentes.
- Reduz boilerplate em relação a Java; código mais limpo e expressivo.
