CyberSecure News & CVE

## Borrador del proyecto

**Estudiante:** Ashley Fermín Llano García  
**Proyecto:** CyberSecure News & CVE  
**Tipo de aplicación:** Aplicación móvil  
**Estado:** Borrador del proyecto  

---

## 1. Descripción del proyecto

CyberSecure News & CVE será una aplicación móvil orientada a estudiantes, profesionales y personas interesadas en el área de ciberseguridad. El objetivo principal de la aplicación será centralizar información relacionada con noticias de seguridad informática, vulnerabilidades, amenazas y recursos educativos en una plataforma accesible y organizada.

Actualmente, la información relacionada con ciberseguridad se encuentra distribuida entre diferentes sitios web, bases de datos y fuentes especializadas. Esto puede dificultar el seguimiento de acontecimientos recientes y de vulnerabilidades que pueden representar un riesgo para sistemas y aplicaciones.

La aplicación buscará proporcionar un punto centralizado donde los usuarios puedan consultar información relevante de manera rápida. El proyecto también tendrá un enfoque educativo, permitiendo que los usuarios comprendan mejor las vulnerabilidades y amenazas que afectan al entorno tecnológico.

Durante el desarrollo del proyecto se buscará implementar una interfaz sencilla e intuitiva que permita navegar entre las diferentes categorías de información.

---

## 2. Exposición del problema

La ciberseguridad es un área que cambia constantemente debido a la aparición de nuevas vulnerabilidades, amenazas y técnicas utilizadas por los atacantes.

Una de las principales dificultades para estudiantes y personas que comienzan a desarrollarse en esta área es encontrar información relevante y confiable sin tener que consultar múltiples plataformas de manera independiente.

Por ejemplo, una persona interesada en una vulnerabilidad específica puede necesitar consultar diferentes fuentes para conocer:

- El identificador de la vulnerabilidad.
- La severidad.
- La descripción de la vulnerabilidad.
- Las medidas de mitigación disponibles.

De manera similar, las noticias de ciberseguridad se encuentran distribuidas entre diferentes sitios especializados, lo que puede dificultar mantenerse actualizado.

### Problema identificado

La falta de una plataforma móvil centralizada que permita consultar y organizar información relacionada con noticias de ciberseguridad y vulnerabilidades.

### Solución propuesta

CyberSecure News & CVE buscará solucionar este problema mediante una aplicación móvil que concentre diferentes tipos de información de ciberseguridad en una sola plataforma.

La aplicación permitirá consultar noticias y vulnerabilidades.
---

## 3. Objetivos del proyecto

### Objetivo general

Desarrollar una aplicación móvil que permita centralizar y consultar información relacionada con noticias de ciberseguridad, vulnerabilidades CVE mediante una interfaz sencilla y facil de utilizar.

### Objetivos específicos

- Diseñar una interfaz móvil intuitiva y accesible.
- Permitir la consulta de noticias relacionadas con ciberseguridad.
- Incorporar una sección dedicada a vulnerabilidades CVE.
- Diseñar una interfaz administrativa para la gestión del contenido.
- Aplicar principios básicos de seguridad durante el desarrollo.
- Utilizar GitHub para administrar y documentar el proyecto.
- Desarrollar progresivamente la aplicación durante el término académico.

---

## 4. Plataforma

La aplicación será desarrollada inicialmente para dispositivos móviles Android.

### Plataforma principal

- **Sistema operativo:** Android
- **Entorno de desarrollo:** Android Studio
- **Control de versiones:** Git y GitHub


Durante las primeras etapas del proyecto se utilizarán datos de prueba para desarrollar y validar la interfaz y las funcionalidades principales. Posteriormente, se evaluará la incorporación de fuentes externas de información y servicios relacionados con vulnerabilidades y noticias de ciberseguridad.

---

## 5. Usuarios de la aplicación

La aplicación estará dirigida principalmente a:

- Estudiantes de ciberseguridad.
- Estudiantes de tecnologías de la información.
- Profesionales de ciberseguridad.
- Personas interesadas en seguridad informática.
- Personas que deseen mantenerse actualizadas sobre vulnerabilidades y amenazas.

La aplicación tendrá dos tipos principales de usuarios:

### Usuario general

El usuario general podrá consultar la información disponible en la aplicación.

Entre sus funciones estarán:

- Consultar noticias.
- Consultar vulnerabilidades.

### Administrador

El administrador tendrá acceso a funciones destinadas a la gestión del contenido de la aplicación.

Entre sus funciones estarán:

- Agregar contenido.
- Modificar contenido.
- Eliminar contenido.
- Gestionar información relacionada con vulnerabilidades.
- Administrar usuarios cuando sea necesario.

---

# 6. Interfaz de usuario

La aplicación actualmente cuenta con cuatro pantallas principales.

## 6.1 Pantalla de Inicio

La pantalla de inicio presenta el nombre de la aplicación y una breve descripción de su propósito.

También proporciona acceso a las principales secciones de la aplicación:

- Noticias
- Vulnerabilidades
- Administrador

### Funcionalidad actual

Los tres botones permiten navegar hacia sus respectivas pantallas.

---

## 6.2 Pantalla de Noticias

La pantalla de Noticias está destinada a mostrar información relacionada con acontecimientos y novedades de ciberseguridad.

Actualmente contiene información de ejemplo para representar la estructura que tendrá la sección.

La navegación inferior permite acceder a:

- Inicio
- Vulnerabilidades
- Administrador

### Funcionalidad futura

En futuras versiones se incorporarán noticias reales de ciberseguridad, así como análisis previamente elaborados sobre diferentes acontecimientos, vulnerabilidades y amenazas.

---

## 6.3 Pantalla de Vulnerabilidades

La sección de Vulnerabilidades está destinada a presentar información relacionada con vulnerabilidades identificadas mediante identificadores CVE.

Actualmente se utilizan datos de ejemplo para representar la estructura visual de la sección.

La navegación permite acceder a:

- Inicio
- Noticias
- Administrador

### Funcionalidad futura

Esta sección podrá ampliarse para mostrar información más detallada de las vulnerabilidades, incluyendo:

- Identificador CVE.
- Descripción.
- Nivel de severidad.
- Sistemas o productos afectados.
- Información sobre la vulnerabilidad.
- Análisis realizado.

---

## 6.4 Pantalla de Administrador

La pantalla de Administrador permite representar las funciones necesarias para la gestión de noticias.

Actualmente contiene:

- Campo para el título de la noticia.
- Campo para el contenido de la noticia.
- Botón para agregar una noticia.
- Botón para editar una noticia.

También cuenta con navegación hacia:

- Inicio
- Noticias
- Vulnerabilidades

### Funcionalidad futura

Las funciones de agregar y editar noticias serán conectadas posteriormente con una base de datos para permitir el almacenamiento permanente de la información.

---

# 7. Navegación de la aplicación

La aplicación cuenta actualmente con navegación funcional entre las cuatro pantallas principales.

                    ┌──────────────┐
                    │    INICIO    │
                    └──────┬───────┘
                           │
          ┌────────────────┼────────────────┐
          ↓                ↓                ↓
     ┌──────────┐   ┌───────────────┐   ┌──────────────┐
     │ NOTICIAS │   │VULNERABILIDADES│   │ADMINISTRADOR │
     └────┬─────┘   └───────┬───────┘   └──────┬───────┘
          │                 │                  │
          └─────────────────┼──────────────────┘
                            ↓
                         INICIO

