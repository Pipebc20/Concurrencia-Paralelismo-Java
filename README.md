# Taller de Concurrencia y Paralelismo en Java

### 1. ¿Qué diferencia hay entre paralelismo y concurrencia?

**Respuesta:**  
El **paralelismo** ocurre cuando varias tareas se dividen para ejecutarse al mismo tiempo y así terminar más rápido. En el ejercicio 1, los 4 hilos trabajan en paralelo sumando diferentes partes del rango de 1 a 1,000,000.

La **concurrencia** ocurre cuando varios hilos intentan usar o compartir un mismo recurso y por eso deben coordinarse. En el ejercicio 2, los 3 clientes quieren retirar dinero de la misma cuenta bancaria, por lo que todos comparten el mismo saldo y necesitan control para no generar errores.


### 2. ¿Qué problema ocurre cuando varios hilos acceden al mismo recurso?

**Respuesta:**  
Cuando varios hilos acceden al mismo recurso al mismo tiempo, se pueden producir errores o resultados incorrectos. En el ejercicio de la cuenta bancaria, si varios clientes retiraran dinero exactamente al mismo tiempo sin control, el saldo podría actualizarse mal y quedar con un valor negativo o incorrecto.


### 3. ¿Qué es una condición de carrera (Race Condition)?

**Respuesta:**  
Una **condición de carrera** ocurre cuando dos o más hilos intentan modificar un mismo recurso compartido al mismo tiempo, y el resultado depende del orden en que se ejecuten. En el ejercicio 2, si no se usara `synchronized`, varios clientes podrían revisar el saldo al mismo tiempo y también retirar dinero, aunque realmente solo uno debería hacerlo primero.

### 4. ¿Por qué es importante sincronizar el acceso a recursos compartidos?

**Respuesta:**  
Es importante porque evita que varios hilos entren al mismo tiempo a modificar un recurso compartido. En el ejercicio 2, la palabra clave `synchronized` hace que un solo cliente pueda retirar dinero a la vez, lo cual protege el saldo de la cuenta y evita inconsistencias.


## Concepto clave usado en el ejercicio 2

### `synchronized`



`synchronized` es una **palabra clave de Java** que permite sincronizar el acceso de varios hilos a un recurso compartido. Su función es hacer que solo un hilo pueda entrar a un método o bloque de código a la vez, evitando errores en la ejecución concurrente.


## Autor 🖋️

- [@Pipebc20](https://github.com/Pipebc20) - (Juan Felipe Bahamon Castillo)
