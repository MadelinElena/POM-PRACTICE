# POM Practice - Selenium Test Automation

Este proyecto es una práctica de automatización de pruebas web utilizando Java, Selenium WebDriver, TestNG y el patrón Page Object Model (POM). Las pruebas están dirigidas al sitio web de ejemplo [SauceDemo](https://www.saucedemo.com/).

## Tecnologías utilizadas

- Java 11
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory

## Objetivo

El propósito de este proyecto es demostrar habilidades prácticas en la automatización de pruebas funcionales mediante una estructura organizada, mantenible y escalable. Incluye la simulación de una compra completa en el sitio, desde el login hasta la confirmación final.

## Estructura del proyecto

pom-practice/
├── pom.xml
├── src/
│ ├── main/
│ │ └── java/
│ │ └── saucedemo/
│ │ ├── base/
│ │ │ └── BasePage.java
│ │ └── pages/
│ │ ├── LoginPage.java
│ │ ├── ProductsPage.java
│ │ ├── CartPage.java
│ │ ├── CheckoutPage.java
│ │ └── ThankYouPage.java
│ └── test/
│ └── java/
│ └── saucedemo/
│ └── test/
│ └── SaucedemoTest.java


## Escenarios implementados

- Ingreso al sistema con usuario y contraseña válidos
- Agregado de productos al carrito
- Proceso completo de checkout con llenado de formulario
- Eliminación de productos del carrito
- Verificación del mensaje final de agradecimiento
- Validación de estados de la UI usando `WebDriverWait`

## Cómo ejecutar el proyecto

### Requisitos previos

- Java 11 o superior
- Maven
- Google Chrome
- ChromeDriver compatible con tu versión de Chrome

### Clonar y ejecutar

```bash
git clone https://github.com/MadelinElena/POM-PRACTICE.git
cd POM-PRACTICE
mvn test

Notas adicionales
El sitio utilizado (saucedemo.com) es una plataforma pública de práctica para automatización.

Las clases están organizadas siguiendo el patrón Page Object Model con PageFactory.

Se emplean buenas prácticas como la separación de lógica y la reutilización de código.

Las pruebas se ejecutan con maven-surefire-plugin y están escritas con TestNG.

Autor
Proyecto desarrollado por Madelin Elena como ejercicio práctico de automatización con Selenium y Java.
