# Parcial - Backend

Backend en Java + Spring Boot para la gestión de bodegas y sus productos asociados.

## Requisitos

- Java 17
- Maven (o usar el wrapper incluido `./mvnw`)

## Ejecución

Desde la carpeta `Parcial-Back/parcial`:

En Linux/macOS:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

## Endpoints

- `POST /bodegas`: registra una bodega.
  - Body JSON: `{ "nombre": "...", "ubicacion": "..." }`
- `GET /bodegas`: lista las bodegas incluyendo sus productos asociados.

## Datos de prueba

Al iniciar la aplicación se cargan bodegas y productos de ejemplo desde `src/main/java/com/example/parcial/config/DataInitializer.java`.

| Producto            | Precio     | Cantidad | Bodega       |
|---------------------|------------|----------|--------------|
| Computador portátil | 2.500.000  | 15       | Bodega Norte |
| Monitor             | 750.000    | 20       | Bodega Norte |
| Impresora           | 1.200.000  | 8        | Bodega Sur   |

## Base de datos

Se usa H2 en memoria (`jdbc:h2:mem:parcialdb`) con `ddl-auto=create-drop`.

Para ver la base de datos mientras la app corre:

1. Ir a `http://localhost:8080/h2-console`
2. JDBC URL: `jdbc:h2:mem:parcialdb`
3. User: `sa`
4. Password: *(vacío)*
