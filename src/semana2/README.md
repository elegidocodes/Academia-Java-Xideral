# Semana 2 — Patrones y Fundamentos de Java

Este módulo contiene ejercicios prácticos sobre manejo de excepciones, estructuras de datos genéricas, enums, interfaces funcionales y patrones de diseño.

---

## Estructura

```
semana2/
├── ejercicio/          # Ejercicios principales de la semana
└── libejercicio/       # Material de referencia por capítulo
    ├── capitulo2/
    └── capitulo3/
```

---

## ejercicio/

Cada archivo `.java` tiene su diagrama de clases exportado como `.svg` con el mismo nombre.

### [BankAccount.java](ejercicio/BankAccount.java) — [diagrama](ejercicio/BankAccount.svg)

Simula una cuenta bancaria con manejo de excepciones personalizadas.

- **`InvalidAmountException`** — excepción no verificada (`RuntimeException`) para montos inválidos (≤ 0).
- **`InsufficientBalanceException`** — excepción verificada para fondos insuficientes; expone el `deficit` exacto.
- **`AccountLockedException`** — excepción verificada que se lanza cuando se intenta operar sobre una cuenta bloqueada.
- **`TransactionLog`** — implementa `AutoCloseable` para usarse en try-with-resources y registrar cada operación.
- **`BankAccount`** — clase principal con `deposit`, `withdraw` y `transfer`; valida bloqueo antes de cualquier operación.

---

### [SimpleStack.java](ejercicio/SimpleStack.java) — [diagrama](ejercicio/SimpleStack.svg)

Implementación genérica de una pila (LIFO) con lista enlazada.

- **`SimpleStack<T>`** — implementa `Iterable<T>`; expone `push`, `pop`, `peek`, `isEmpty` y `size`.
- **`Node<T>`** — inner static class que representa cada nodo de la lista enlazada.
- **`StackIterator`** — inner class que implementa `Iterator<T>` para recorrer la pila en orden LIFO con for-each.

---

### [TicketSystem.java](ejercicio/TicketSystem.java) — [diagrama](ejercicio/TicketSystem.svg)

Sistema de tickets con estados y prioridades modelados con enums.

- **`Priority`** — enum con niveles `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`; cada uno tiene `level` y `responseTimeHours`.
- **`TicketStatus`** — enum con estados `OPEN`, `IN_PROGRESS`, `RESOLVED`, `CLOSED`; define las transiciones válidas en `canTransitionTo`.
- **`Ticket`** — entidad con id, descripción, prioridad y estado; controla transiciones mediante `transitionTo`.
- **`TicketSystem`** — clase principal que demuestra el uso de `EnumMap` para el dashboard y `EnumSet` para filtrar tickets urgentes.

---

### [ProductCatalog.java](ejercicio/ProductCatalog.java) — [diagrama](ejercicio/ProductCatalog.svg)

Pipeline funcional sobre un catálogo de productos usando interfaces de `java.util.function`.

- **`Product`** — record con `name`, `price`, `category` e `inStock`.
- **`ProductPipeline`** — clase fluent que encadena filtros (`Predicate`) y transformaciones (`Function`); expone `where`, `transform`, `forEach` y `count`.
- **`ProductCatalog`** — clase principal; construye el catálogo con un `Supplier` y aplica distintos pipelines.

---

### [PizzaShop.java](ejercicio/PizzaShop.java) — [diagrama](ejercicio/PizzaShop.svg)

Pedidos de pizza usando los patrones **Builder** y **Decorator**.

- **`Size`** / **`Crust`** — enums con precios base y costos extra respectivamente.
- **`PizzaOrder`** — interfaz con `getDescription()` y `getPrice()`.
- **`Pizza`** — implementa `PizzaOrder`; solo se construye a través de su inner class `Builder`, que valida mínimo 1 y máximo 5 toppings.
- **`PizzaDecorator`** — clase abstracta que envuelve un `PizzaOrder` (base del patrón Decorator).
- **`ExtraCheeseDecorator`** / **`GiftBoxDecorator`** — decoradores concretos que añaden costo y descripción al pedido base.

---

### [EventFramework.java](ejercicio/EventFramework.java) — [diagrama](ejercicio/EventFramework.svg)

Framework de eventos con los patrones **Observer** (EventBus) y **Strategy** (notificaciones).

- **`EventType`** — enum con los eventos del dominio: `ORDER_PLACED`, `ORDER_SHIPPED`, `ORDER_CANCELLED`.
- **`EventHandler`** — interfaz funcional (`@FunctionalInterface`) que se suscribe al bus con lambdas.
- **`NotificationStrategy`** — interfaz para el patrón Strategy; implementada por `EmailStrategy`, `SmsStrategy` y `SlackStrategy`.
- **`EventBus`** — mantiene un `Map<EventType, List<EventHandler>>`; permite `subscribe` y `publish`.
- **`OrderProcessingException`** — excepción verificada para órdenes inválidas.
- **`OrderService`** — orquesta las órdenes; recibe `EventBus` y `NotificationStrategy` por inyección de dependencias.

---

## libejercicio/

Material de apoyo organizado por capítulo. Cada capítulo contiene un `README.md` explicativo y una imagen de referencia (`img.png`).

| Carpeta                                          | Contenido                 |
|--------------------------------------------------|---------------------------|
| [`capitulo2/`](libejercicio/capitulo2/README.md) | Referencia del capítulo 2 |
| [`capitulo3/`](libejercicio/capitulo3/README.md) | Referencia del capítulo 3 |