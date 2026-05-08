# Ejercicios de Java - Capítulo 5

---

## 1. ¿Cuáles afirmaciones sobre `final` son correctas?

**Respuesta: A, E**

- **A** Variables de instancia y estáticas pueden marcarse `final`.
- **E** Un primitivo marcado `final` no puede ser modificado.

---

## 2. ¿Cuáles pueden llenar el espacio para que compile?

**Respuesta: B, C**

- **B** `final` — Modificador de método válido.
- **C** `private` — Modificador de acceso válido.

---

## 3. ¿Cuáles métodos compilan?

**Respuesta: A, D**

- **A** `final static void rain() {}` — Orden de modificadores válido.
- **D** `static final void sleet() {}` — Orden de modificadores válido.

---

## 4. ¿Cuáles pueden llenar el espacio?

**Respuesta: A, B, C, D, E, F**

El literal `6` es un `int` que puede asignarse (con widening o autoboxing) a `int`, `Integer`, `long`, `Long`, `double` y `Double`.

---

## 5. ¿Cuáles métodos compilan?

**Respuesta: A, C, D**

- **A** `return` vacío es válido en un método `void`.
- **C** Un método `void` sin `return` explícito es válido.
- **D** `return 9` en un método `int` es correcto.

---

## 6. ¿Cuáles métodos compilan?

**Respuesta: A, B, F**

- **A** `public void violin(int... nums) {}`
- **B** `public void viola(String values, int... nums) {}` — Vararg al final, válido.
- **F** `public void oboe(String[] values, int[] nums) {}` — Arrays regulares, sin vararg, válido.

---

## 7. ¿Cuáles llamadas retornan 2?

**Respuesta: D, F**

- **D** `juggle(true, true, true)` → `b2 = {true, true}` → length = **2**.
- **F** `juggle(true, new boolean[2])` → `b2` = array de tamaño 2 → length = **2**.

---

## 8. ¿Cuál afirmación es correcta?

**Respuesta: D**

Se pueden marcar todos los métodos como `public` y todas las variables de instancia como `private`.

---

## 9. ¿Cuáles líneas generan error de compilación?

**Respuesta: B, C, D, F**

`Classroom.floor` no genera error porque `floor` es `public static` y es accesible directamente por clase.

---

## 10. ¿Cuál es el output de Chimp?

**Respuesta: B – swing swing 10**

`Rope.swing()` y `new Rope().swing()` ambos invocan el método estático, imprimiendo `"swing "` cada uno. El bloque estático establece `LENGTH = 10`, que se imprime al final.

---

## 11. ¿Cuáles son verdaderas?

**Respuesta: B, E**

- **B** Llamar a `climb()` (método de instancia) dentro del método estático `play()` genera exactamente un error de compilación.
- **E** Eliminando esa línea, `play()` solo llama a `swing()`, por lo que el output sería `swing-swing`.

---

## 12. ¿Cuántas variables son *effectively final*?

**Respuesta: B – 2**

`giraffe` y `name` (interior del `if`) solo se asignan una vez. Las demás se modifican o reasignan en algún punto.

---

## 13. ¿Cuál es el output?

**Respuesta: D – 8**

`length` es un campo estático compartido. `rope1.length = 2` y luego `rope2.length = 8` modifican el mismo campo, por lo que `rope1.length` imprime **8**.

---

## 14. ¿Cuántas líneas tienen errores de compilación?

**Respuesta: D – 3 errores**

- `name` es `final` y ya fue inicializado en la declaración; reasignarlo en el bloque `static` es ilegal.
- `rightRope` ya fue asignado en el primer bloque `static`; reasignarlo en el segundo es ilegal.
- `bench` es `final static` y no puede asignarse dentro de un método como `main()`.

---

## 15. ¿Cuál reemplaza la línea 2 para que compile?

**Respuesta: B**

`import static java.util.Collections.*;` importa todos los miembros estáticos, incluyendo `sort`. Las demás opciones usan sintaxis incorrecta (`static import` en lugar de `import static`, o incluyen
parámetros en el import).

---

## 16. ¿Cuál es el resultado?

**Respuesta: E – int-Object-Object**

- `print(s)`: `short` hace widening a `int` → imprime `int`.
- `print(true)`: `boolean` no tiene conversión numérica → va a `Object`.
- `print(6.789)`: `double` no hace widening a `float` (es al revés) → va a `Object`.

---

## 17. ¿Cuál es el resultado?

**Respuesta: B – 9**

Los primitivos se pasan por valor. `x = -1` dentro de `square()` solo modifica la copia local; `value` en `main()` sigue siendo **9**.

---

## 18. ¿Cuáles son el output?

**Respuesta: B, D, E**

Dentro de `work()`, reasignar `a` no afecta a `s1`, pero `b.append("b")` modifica el objeto original de `s2`. El método retorna un nuevo `StringBuilder("a")`.

- `s1` → **s1**
- `s2` → **s2b**
- `s3` → **a**

---

## 19. ¿Cuáles compilarán insertados en el código?

**Respuesta: B, C, E**

- **B** `value2 = "purple"` en bloque de instancia — campo estático, accesible desde contexto de instancia.
- **C** `value3 = "orange"` en bloque de instancia — campo de instancia normal.
- **E** `value2 = "cyan"` en bloque estático — campo estático no `final`.

Las demás fallan porque `value1` es `final`, o porque intentan acceder a campos de instancia desde un contexto estático.

---

## 20. ¿Cuáles son verdaderas?

**Respuesta: A, E**

- **A** Con todos los métodos presentes: `execute(100)` → `execute(int)` → `2-`; `execute(100L)` → `execute(Object)` → `4-` → imprime `2-4-`.
- **E** Sin `execute(int num)`: `execute(100)` hace autoboxing a `Integer` → `3-`; `execute(100L)` → `execute(Object)` → `4-` → imprime `3-4-`.

---

## 21. ¿Cuáles son sobrecargas válidas de `public void moo(int m, int... n)`?

**Respuesta: B, D**

- **B** `public int moo(char ch)` — Mismo nombre, parámetros diferentes, retorno diferente no impide la sobrecarga.
- **D** `private void moo(int... x)` — Mismo nombre, lista de parámetros distinta.