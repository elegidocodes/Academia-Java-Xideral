# Ejercicios de Java - Capítulo 4

---

## 1. ¿Qué imprime el siguiente código?

**Respuesta: F – The code does not compile.**

`numFish + 1` produce un `int`, no un `String`, por lo que la asignación a `String anotherFish` falla en compilación.

---

## 2. ¿Cuáles declaraciones de array NO son legales?

**Respuesta: C, E, F**

- **C** `new beans[6]` — `beans` no es un tipo válido.
- **E** `new int[]` — falta especificar el tamaño o los corchetes correctos.
- **F** `new int[][]` — no se puede omitir la primera dimensión en arrays multidimensionales.

---

## 3. ¿Cuáles pueden llenar el espacio sin lanzar excepción?

**Respuesta: A, C, D**

Las tres son fechas válidas. Aunque `2022-03-13` es el día del spring forward, `ZonedDateTime` ajusta la hora automáticamente sin lanzar excepción.

---

## 4. ¿Cuáles se imprimen?

**Respuesta: A, C, D**

- **A** `"Hello".equals(s)` → `true` → imprime **one**
- **C** `t.intern() == s` → `true`, `intern()` devuelve la referencia del pool → imprime **three**
- **D** `"Hello" == s` → `true`, ambos son literales del pool → imprime **four**

---

## 5. ¿Cuál es el output?

**Respuesta: A – abbaaccc**

Partiendo de `"aaa"`, `insert(1, "bb")` produce `"abbaa"` y luego `insert(4, "ccc")` produce `"abbaaccc"`.

---

## 6. ¿Cuántas líneas tienen error de compilación?

**Respuesta: C – 2 errores**

`Math.pow()` devuelve `double`, no `int`, por lo que asignarlo directamente a `int` sin cast genera error. Las dos líneas con ese patrón fallan.

---

## 7. ¿Cuál es verdadero sobre las dos fechas?

**Respuesta: A, E**

- `2022-08-28T05:00 GMT-04:00` equivale a las `09:00 UTC`.
- `2022-08-28T09:00 GMT-06:00` equivale a las `15:00 UTC`.

La primera fecha es anterior y están separadas por 6 horas.

---

## 8. ¿Cuáles devuelven el carácter `'5'`?

**Respuesta: A, F**

- **A** `builder.charAt(4)` sobre `"12345"` → índice 4 = `'5'`.
- **F** `string.replace("123", "1")` produce `"145"`, y `charAt(2)` = `'5'`.

---

## 9. ¿Cuáles son verdaderas sobre los arrays?

**Respuesta: A, C, G**

- **A** El primer elemento está en el índice 0.
- **C** Los arrays tienen tamaño fijo una vez creados.
- **G** `equals()` en arrays compara por referencia (hereda de `Object`), no por contenido.

---

## 10. ¿Cuántas líneas tienen error de compilación?

**Respuesta: A – 0 errores**

`Math.min()` devuelve `int`, `Math.round(double)` devuelve `long`, `Math.floor()` devuelve `double`, y el array acepta widening de `int` y `long` a `double`. Todo compila.

---

## 11. ¿Cuál es el output?

**Respuesta: E – The code does not compile.**

`LocalDate` no tiene el método `plusHours()`, ese método pertenece a `LocalTime` y `LocalDateTime`.

---

## 12. ¿Qué incluye el output?

**Respuesta: A, E**

`indent(1)` agrega un espacio al inicio y un `\n` al final. `stripLeading()` elimina el espacio, dejando `"012345678\n"`. `substring(1, 3)` produce `"12"` y `substring(7, 7)` produce una cadena vacía
que se imprime como línea en blanco.

---

## 13. ¿Cuál es el resultado?

**Respuesta: B – roar roar!!!**

`String` es inmutable, por lo que `concat()` no modifica `roar1`. `StringBuilder` es mutable, por lo que `append("!!!")` sí modifica `roar2`.

---

## 14. ¿Cuáles pueden llenar el espacio correctamente?

**Respuesta: A, F**

- **A** `Instant.now()` es válido.
- **F** `zonedDateTime.toInstant()` es válido.

Las demás opciones fallan porque `LocalDate`, `LocalDateTime` y `LocalTime` no tienen `toInstant()` sin zona horaria, y `Instant` no tiene constructor público.

---

## 15. ¿Cuál es el output?

**Respuesta: C, E**

`Arrays.sort()` ordena en orden Unicode: números → mayúsculas → minúsculas, produciendo `[123, PIG, pig]`. `binarySearch(arr, "Pippa")` no encuentra el elemento; el punto de inserción es el índice 2,
por lo que retorna `-(2+1) = -3`.

---

## 16. ¿Qué se incluye en el output?

**Respuesta: A, C, G**

- `length()` sobre `"ewe\nsheep\\t"` → **12** caracteres.
- `indent(2)` agrega 2 espacios a cada línea y asegura `\n` al final → **16** caracteres.
- `translateEscapes()` convierte `\\t` en `\t` real → **10** caracteres.

---

## 17. ¿Cuáles son verdaderas?

**Respuesta: A, G**

- **A** `substring(1, 2)` sobre `"abcdefg"` devuelve `"b"` (1 carácter).
- **G** `substring(6, 5)` lanza `StringIndexOutOfBoundsException` porque el índice de inicio es mayor que el de fin.

---

## 18. ¿Cuál es el resultado?

**Respuesta: C, F**

El text block `purr` produce `"purr"` (4 caracteres). Las operaciones intermedias no modifican `s1` porque `String` es inmutable. Tras `s1 += "two"`, `s1.length()` es **7**. `s2` se construye por
concatenación, por lo que `s2 == "2cfalse"` es `false`, pero `s2.equals("2cfalse")` es `true`, imprimiendo **equals**.

---

## 19. ¿Cuáles imprimen un entero positivo?

**Respuesta: A, B, D**

- **A** `compare(s1, s2)`: "Peacock" > "Llama" → retorna positivo.
- **B** `mismatch(s1, s2)`: primer elemento distinto en el índice 1 → retorna **1**.
- **D** `mismatch(s3, s4)`: `s3` es más corto, el mismatch ocurre en el índice 1 → retorna **1**.

---

## 20. ¿Cuál es el output?

**Respuesta: A, D**

El 13 de marzo se adelanta el reloj (spring forward): la 1:30 AM EST más 1 hora resulta en las 3:30 AM EDT. La diferencia en `ChronoUnit.HOURS` es **1** y la hora de `dateTime2` es **3**.

---

## 21. ¿Cuáles imprimen "avaJ"?

**Respuesta: A, C**

- **A** `reverse()` sobre `"Java"` produce directamente `"avaJ"`.
- **C** `append("vaJ$")` produce `"JavavaJ$"`, `delete(0, 3)` deja `"avaJ$"`, y `deleteCharAt(length()-1)` elimina el `$`, dejando `"avaJ"`.

---

## 22. ¿Cuál es el output?

**Respuesta: A – 2022 APRIL 30**

`LocalDate` es inmutable. `plusDays(2)` y `plusYears(3)` devuelven nuevos objetos que no se reasignan, por lo que `date` sigue siendo `2022-04-30`.