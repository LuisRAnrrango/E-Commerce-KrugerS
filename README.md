<br />
<div align="center">
  <a href="https://github.com">
    <img src="src/main/resources/img/K-Market-2.png" alt="Logo" width="390" height="180">
  </a>

  <h1 style="font-size: 60px; font-weight: 700" align="center">🛒KMarket Ecommerce</h1>

<h4 align="center">

  <p align="center">https://k-market-ten.vercel.app/</p>
</h4>
 <p align="center">
"Del campo a tu mesa, frescura y calidad sin intermediarios"
    <br />
    <br />
   
Bienvenido a Kmarket, una plataforma de eCommerce diseñada para ofrecerte la mejor experiencia de compra en línea! Como empresa en línea, nos enorgullece ofrecerte una amplia variedad de productos de alta calidad a precios asequibles.
  </p>
</div>

<!-- markdownlint-disable MD051-->

## Tabla de Contenidos

- [🛠️Construido con](#🖥️🛠️Herramientas)
- [📃Requisitos](#📃requisitos)
- [🛠️Instalación](#🛠️instalación)
- [🎞️Capturas](#🎞️capturas)
- [🤝Contacto](#🤝contacto)
- [🙏Agradecimientos](#🙏agradecimientos)
<!-- markdownlint-enable MD051-->

## Construido con

- Spring Boot 3.0.1
- JAVA 17
- Maven
- Eureka Netflix
- Feign Client
- Spring Boot Security
- Spring Boot Gateway
- Postman

## Requisitos

- Java 17
- Maven
- Git (Git Desktop)
- Un editor de código o IDE compatible con los lenguajes mencionados anteriormente(IntelliJ IDEA, STS)
- PotsgresQL

## instalación

### Configuración

- Clona este reposiotrio utilizando `https://github.com/LuisRAnrrango/E-Commerce-KrugerS.git`
- Es necesario tener instalado el JDK para Java 17.
- Postman u otra herramienta como Thunder Client o Insonmia para el test de la API

### Pasos

- Primero abrir el proyecto `config-service`, este tiene centralizado los archivos de configuración de cada microservicio, ejectuar el proyecto con el IDE de confianza, se ejecutará en el puerto `8180`

- Segundo abrir el proyecto `eureka-service`, este microservicio mantiene el registro de los microservicios del proyecto a manos de Eureka, ejectuar el proyecto con el IDE de confianza, se ejecuturá en el puerto `8761`

- Tercero abrir el proyecto `gateway-service`, este microservicio contiene la puerta de enlace para los microservicios, se ejecutará en el puerto `8080`

- Cuarto abrir el proyecto `msvc-producto`, este microservicio contiene la API de los productos, ejecutar el proyecto con el IDE de confianza, se ejecturá en un puerto randómico `????`

- Quinto abrir el proyecto `msvc-negocios`, este microservicio contiene la API de los negocios o Compañia , ejecutar el proyecto con el IDE de confianza , se ejecutará en un puerto randómico `????`

- Sexto abrir el proyecto `msvc-estadopedidos`, este microservicio contiene la API de los diferentes estados de venta, ejecutar el proyecto con el IDE de confianza, se ejecutará en un puerto randómico `????`

- Finalmente abrir el proyecto `backend`, este microservicio contiene los Usuarios de la aplicación , ejecutar el proyecto con el IDE de confianza , se ejecutará en un puerto randómico `????`

## 🎞️Capturas

<table>
    <tr>
        <th><p align="center">Ejecución de Categoria</p></th>
        <th><p align="center">Ejecución de Productos</p></th>
    </tr>
    <tr>
        <td rowspan="3"><img src="src/main/resources/img/CATEGORIAS.png" align="center"></td>
        <td><img src="src/main/resources/img/PRODUCTOS.png" align="center"></td>
    </tr>
</table>

## Contacto

  <table>
    <tbody>
        <tr>
        <td align="center"><a href="https://github.com/LuisRAnrrango"><img src="https://avatars.githubusercontent.com/u/35409654?s=400&u=e531e5a4fe56be8c2e2a0bf10475a205ceb6b8ad&v=4" width="100px;" alt="Jose Andres Gavilanes"/><br /><sub><b>Luis Anrrango</b></sub></a><br /><a href="https://github.com/LuisRAnrrango" title="Code">💻 Desarrollador</a></td>
        </tr>
<tr>
        <td align="center"><a href="https://github.com/Piguave"><img src="https://avatars.githubusercontent.com/u/53985586?v=4" width="100px;" alt="Alexander Cangas"/><br /><sub><b>Ariel Piguave</b></sub></a><br /><a href="https://github.com/Piguave" title="Code">💻 Desarrollador</a></td>
        </tr>
        <tr>
        <td align="center"><a href="https://github.com/jeici21"><img src="https://avatars.githubusercontent.com/u/114098379?v=4" width="100px;" alt="Jorge"/><br /><sub><b></b></sub></a><br /><a href="https://github.com/jeici21" title="Code">💻 Desarrollador</a></td>
        </tr>
        <br/>
    </tbody>
</table>

## 🙏Agradecimientos

- [José Gavilanes](https://github.com/joseandresgavilanes), por su inestimable ayuda embelleciendo la página web.
- [Kenan Al-jaber](https://github.com/KenanAljaber), por ayudarnos a resolver los problemas que teníamos en nuestros microservicios de backend.
- [Ing. Juan Sotomayor](https://github.com/Juanse7793), por las clases de React que nos permitieron enfocarnos en un etorno FrontEnd y además prepararnos para nuestro futuro profesional.
- [Ing. Jaime Sayago](https://github.com/jaimepsayago), por las enseñanzas de Spring Boot tan valiosas para volvernos desarrolladores backend.
