# Fundamentos de Java

## Visão geral
- Java é uma linguagem de programação orientada a objetos, tipada estaticamente e multiplataforma.
- "Write Once, Run Anywhere" (WORA): código compilado funciona em qualquer JVM.

## Ambiente e execução
- **JDK (Java Development Kit)** é necessário; compile com `javac` e execute com `java`.
- Em projetos Gradle, use `./gradlew build` e `./gradlew run` (quando configurado).
- Versões: Java 8, 11, 17, 21 são LTS (Long-term Support).

## Sintaxe básica
- **Pacotes**: `package br.com.exemplo;` organiza código em namespaces.
- **Classes**: declaração com `class Nome {}`; métodos e campos são membros da classe.
- **Tipos primitivos**: `int`, `long`, `double`, `boolean`, `char`.
- **Referências**: `String`, coleções (`List`, `Map`), classes customizadas.
- **Modificadores**: `public`, `private`, `protected`, `static`, `final`.

## Controle de fluxo
- `if / else`, `switch`, `for`, `while`, `do while`, `try / catch / finally`.
- `break` e `continue` para controle de loops.

## Conceitos essenciais
- **Orientação a objetos**: classes, objetos, herança, polimorfismo, encapsulamento.
- **Interfaces e classes abstratas** para contratos e extensibilidade.
- **Exceções**: checked vs unchecked; lance com `throw` e trate com `catch`.
- **Herança**: `extends` para classes; `implements` para interfaces.

## Collections API
- **Interfaces**: `List`, `Set`, `Map` definem contratos.
- **Implementações comuns**: 
  - `ArrayList`, `LinkedList` para `List`
  - `HashSet`, `TreeSet` para `Set`
  - `HashMap`, `TreeMap` para `Map`
- **Operações**: `add()`, `remove()`, `get()`, `forEach()`, `stream()`.
- **Evite iterações manuais**; prefira streams quando possível.

## Lambdas e Streams
- **Expressões lambda**: `(parametros) -> { corpo }` facilitam código funcional.
- **Streams**: `collection.stream().filter(...).map(...).collect(...)` para transformações eficientes.
- **Optional<T>**: encapsula valores que podem estar ausentes; métodos `map()`, `filter()`, `orElse()`.

## Generics e Type Erasure
- **Genéricos** permitem segurança de tipo em tempo de compilação: `List<String>`, `Map<String, Integer>`.
- **Type erasure**: genéricos são removidos em runtime; não é possível fazer `instanceof List<String>`.
- Preserva compatibilidade com código pré-genéricos.

## Anotações e Reflexão
- **Anotações**: `@Override`, `@FunctionalInterface`, `@Deprecated` marcam código.
- **Reflexão**: permite inspeção e manipulação de classes em runtime via APIs em `java.lang.reflect`.
- **Cuidado**: reflexão afeta desempenho; cache quando possível.

## Gerenciamento de Memória
- **Garbage collection** automático; objetos sem referência são coletados.
- **Evite memory leaks**: desacople listeners, feche recursos (`try-with-resources`).
- **Try-with-resources**: automaticamente fecha implementações de `AutoCloseable`.

## Ferramentas comuns
- **Build**: Gradle (arquivo `build.gradle.kts` no repositório).
- **Testes**: JUnit, executados via Gradle.
- **IDEs**: IntelliJ IDEA, Eclipse, NetBeans.

## Boas práticas rápidas
- Prefira imutabilidade quando possível; minimize efeitos colaterais.
- Use `Optional` para valores que podem faltar (quando apropriado).
- Separe camadas: `service`, `persistence/dao`, `ui` como visto no repositório.
- Use try-with-resources para fechar streams e conexões automaticamente.
- Siga convenções de nomenclatura: classes PascalCase, métodos camelCase.
