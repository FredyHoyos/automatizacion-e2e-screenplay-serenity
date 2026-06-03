# Automatizacion E2E con Screenplay y Serenity

Para la materia de Calidad de Software 2026-1. Profesor Robinson. 

Ejecutar prueba con: .\gradlew clean test aggregate --info

Proyecto de automatizacion end-to-end desarrollado con **Java 17**, **Gradle**, **Serenity BDD**, **Cucumber** y el patron **Screenplay**. El objetivo es validar flujos reales de la aplicacion **Automation Exercise** a traves de pruebas funcionales, separando escenarios de exito y de error.

## Proposito del proyecto

Este repositorio contiene una suite de pruebas E2E que cubre:

- Registro de usuario en Automation Exercise.
- Validaciones de formularios con datos faltantes o invalidos.
- Flujo happy path de compra de un producto.
- Integracion con Serenity para generar reportes HTML de ejecucion.

El proyecto fue estructurado para que cada accion de negocio quede separada en:

- `tasks` o `interactions`: acciones que realiza el actor.
- `questions`: validaciones sobre el estado de la interfaz.
- `stepdefinitions`: puente entre Cucumber y Screenplay.
- `userinterfaces`: localizadores y elementos de la pagina.
- `models`: datos del dominio usados en las pruebas.

## Tecnologias usadas

- Java 17
- Gradle
- Serenity BDD
- Cucumber JVM
- Screenplay Pattern
- Selenium WebDriver
- JUnit 4
- Hamcrest

## Estructura principal

```text
src/
  main/
    java/
      co/edu/udea/certificacion/taller/moduloauthycompra/
        interactions/
        models/
        questions/
        tasks/
        userinterfaces/
        utils/
  test/
    java/
      co/edu/udea/certificacion/taller/moduloauthycompra/
        runners/
        stepdefinitions/
    resources/
      features/
        e2eHappyPath.feature
        e2eUnhappyRegister.feature
```

## Escenarios cubiertos

### Happy path

El escenario de exito valida el flujo completo de compra:

1. Abrir la pagina de Automation Exercise.
2. Registrar un usuario nuevo.
3. Completar el formulario de registro.
4. Confirmar la cuenta.
5. Navegar a productos.
6. Agregar un producto al carrito.
7. Proceder al checkout.
8. Completar el pago.
9. Verificar la confirmacion de orden.

### Unhappy path

Los escenarios de error validan que el sistema no permita continuar cuando:

- El correo ya existe.
- Falta `name` o `email` en el primer formulario.
- Faltan campos obligatorios en la segunda parte del registro.

## Runner principal

El runner de Cucumber/Serenity es:

- `src/test/java/co/edu/udea/certificacion/taller/moduloauthycompra/runners/AutomatizacionRunner.java`

Este runner no tiene metodo `main`, por eso debe ejecutarse como prueba JUnit/Cucumber y no como aplicacion Java normal.

## Requisitos previos

- Java 17 instalado.
- Gradle Wrapper disponible en el proyecto.
- Navegador Chrome instalado.
- Conexion a internet para acceder a Automation Exercise.
- Driver gestionado por la dependencia de WebDriverManager o por Serenity segun la configuracion local.

## Ejecucion

### Ejecutar toda la suite

```powershell
.\gradlew.bat clean test --stacktrace
```

### Ejecutar solo el runner

```powershell
.\gradlew.bat test --tests "co.edu.udea.certificacion.taller.moduloauthycompra.runners.AutomatizacionRunner" --stacktrace
```

### Generar reporte Serenity

Al finalizar la ejecucion, el reporte HTML se genera en:

```text
target/site/serenity/index.html
```

## Configuracion de la suite

La configuracion general de Serenity se encuentra en:

- `serenity.properties`
- `src/test/resources/serenity.conf`

Los features estan en:

- `src/test/resources/features/e2eHappyPath.feature`
- `src/test/resources/features/e2eUnhappyRegister.feature`

## Notas importantes

- Si ejecutas la clase runner como "Java Application", fallara porque no existe `main`.
- Para correrla correctamente, usa Gradle o la vista de pruebas de VS Code.
- Las validaciones de los escenarios unhappy fueron ajustadas para devolver `false` cuando el elemento no aparece, evitando que Serenity lance errores por aserciones internas.

## Resultado esperado

Al ejecutar la suite correctamente deberias obtener:

- Pasos reportados por Serenity.
- Evidencia visual en el reporte HTML.
- Validacion del flujo de compra y de los casos de error.

## Autor

Proyecto academico de automatizacion E2E para practicas de calidad de software.
