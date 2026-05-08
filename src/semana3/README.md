# Semana 3 — Concurrencia, Colecciones y Programación Funcional

Este módulo contiene ejercicios prácticos sobre concurrencia con `CompletableFuture`, colecciones genéricas, caché con TTL, análisis de datos con Streams y validación funcional.

---

## Estructura

```
semana3/
├── ejercicio/          # Ejercicios principales de la semana
└── libejercicio/       # Material de referencia por capítulo
    ├── capitulo4/
    └── capitulo5/
```

---

## ejercicio/

Cada archivo `.java` tiene su diagrama de clases exportado como `.svg` con el mismo nombre.

### [ConcurrentScraper.java](ejercicio/ConcurrentScraper.java) — [diagrama](ejercicio/ConcurrentScraper.svg)

Scraper web concurrente que simula peticiones HTTP en paralelo usando `CompletableFuture`.

- **`PageResult`** — record que almacena el resultado de una petición: `url`, `statusCode`, `title` y `responseTimeMs`.
- **`ConcurrentScraper`** — clase principal con un `ExecutorService` de hilo fijo; expone `fetchAll` para ejecución paralela y `fetchWithTimeout` para cancelar peticiones lentas con código `408`;
  incluye `printReport` con estadísticas de tiempo, página más rápida/lenta y conteo por status.

---

### [Contact.java](ejercicio/Contact.java) — [diagrama](ejercicio/Contact.svg)

Agenda de contactos con ordenamiento natural y búsqueda funcional sobre un `TreeSet`.

- **`Contact`** — entidad con `name`, `email` y `phone`; implementa `Comparable<Contact>` (orden por nombre, insensible a mayúsculas) y `equals`/`hashCode` basados en email.
- **`ContactManager`** — gestiona un `Set<Contact>` ordenado; expone `addContact`, `findByEmail`, `findByNamePrefix` y `getAllSortedBy` con `Comparator` arbitrario.

---

### [ExpiringCache.java](ejercicio/ExpiringCache.java) — [diagrama](ejercicio/ExpiringCache.svg)

Caché genérica con expiración por TTL, limpieza lazy y evicción explícita.

- **`ExpiringCache<K, V>`** — almacena entradas en un `HashMap`; soporta TTL por defecto y TTL personalizado por entrada; realiza limpieza lazy en `get` y limpieza activa en `evictExpired`.
- **`CacheEntry<V>`** — record interno que encapsula el valor y el timestamp de expiración; expone `isExpired()`.

---

### [SalesAnalyzer.java](ejercicio/SalesAnalyzer.java) — [diagrama](ejercicio/SalesAnalyzer.svg)

Análisis de ventas con pipelines de Streams y colectores avanzados.

- **`Sale`** — record con `product`, `category`, `amount`, `region` y `date`.
- **`SalesAnalyzer`** — clase principal que calcula ingreso total, ingresos y promedios por categoría, top 3 productos, ranking de regiones, producto más caro por región y conteo de ventas por mes;
  usa `groupingBy`, `summingDouble`, `averagingDouble`, `maxBy` y `counting`.

---

### [TextAnalyzer.java](ejercicio/TextAnalyzer.java) — [diagrama](ejercicio/TextAnalyzer.svg)

Análisis estadístico de texto con Streams y expresiones regulares.

- **`TextAnalyzer`** — recibe una lista de líneas y expone `wordCount`, `uniqueWords`, `topN` (palabras más frecuentes), `averageWordLength` y `wordsByFirstLetter`; usa streams privados `words()` y
  `cleanWords()` para normalizar y tokenizar el texto.

---

### [ValidatorDemo.java](ejercicio/ValidatorDemo.java) — [diagrama](ejercicio/ValidatorDemo.svg)

Framework de validación funcional y componible con interfaz funcional genérica.

- **`Validator<T>`** — interfaz funcional con factory estático `from(Predicate, String)` y método `default and` para componer validadores en cadena.
- **`ValidationResult`** — record que acumula el estado de validez y la lista de errores; expone `valid()`, `invalid()` y `merge` para combinar resultados.
- **`User`** — record con `name`, `email` y `age` usado como sujeto de validación.
- **`ValidatorDemo`** — clase principal que construye validadores individuales y compuestos para strings, enteros y objetos `User` completos.

---

## libejercicio/

Material de apoyo organizado por capítulo. Cada capítulo contiene un `README.md` explicativo.

| Carpeta                                          | Contenido                 |
|--------------------------------------------------|---------------------------|
| [`capitulo4/`](libejercicio/capitulo4/README.md) | Referencia del capítulo 4 |
| [`capitulo5/`](libejercicio/capitulo5/README.md) | Referencia del capítulo 5 |