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

La interfaz de usuario estará diseñada buscando mantener una estructura sencilla, clara y fácil de navegar.

La aplicación contará con una pantalla principal desde la cual el usuario podrá acceder a las diferentes secciones.

### Secciones principales

- Inicio
- Noticias
- Vulnerabilidades CVE
- Amenazas
- Recursos educativos



La navegación se diseñará de manera que el usuario pueda acceder rápidamente a las funciones principales sin tener que recorrer múltiples pantallas.

### Pantalla de inicio

La pantalla principal mostrará información destacada y las noticias más recientes.

---

# 7. Interfaz de administrador
┌─────────────────────────────────┐
│      PANEL DE ADMINISTRADOR      │
├─────────────────────────────────┤
│                                 │
│ [ + Nueva noticia ]             │
│                                 │
│ Noticias                        │
│ ┌─────────────────────────────┐ │
│ │ Noticia 1                   │ │
│ │ [Editar]       [Eliminar]  │ │
│ └─────────────────────────────┘ │
│                                 │
│ Vulnerabilidades                │
│ ┌─────────────────────────────┐ │
│ │ CVE-XXXX-XXXXX              │ │
│ │ [Editar]       [Eliminar]  │ │
│ └─────────────────────────────┘ │
│                                 │
│ Categorías                      │
│ Usuarios                        │
└─────────────────────────────────┘

---

# 8. Funcionalidad

La aplicación contará con diferentes funcionalidades que serán desarrolladas progresivamente durante el término académico.

8.1 Consulta de noticias

Los usuarios podrán consultar noticias relacionadas con ciberseguridad.

Cada noticia podrá mostrar información como:

Título.
Fecha de publicación.
Fuente.
Descripción.
Categoría.
Enlace a la fuente original.

![Wireframe de la pantalla de inicio](Docs/Wireframes/inicio.png)

8.2 Consulta de vulnerabilidades CVE

La aplicación contará con una sección para consultar vulnerabilidades identificadas mediante identificadores CVE.

La información podrá incluir:

Identificador CVE.
Descripción.
Severidad.
Producto afectado.
Versiones afectadas.
Impacto.
Información de mitigación.

El objetivo será proporcionar al usuario una explicación comprensible de las vulnerabilidades y no únicamente mostrar el identificador técnico.

![Wireframe de la pantalla de noticias](Docs/Wireframes/noticias.png)

8.7 Administración del contenido

El administrador tendrá funciones para mantener actualizado el contenido de la aplicación.

Entre las operaciones principales se contemplan:

Crear registros.
Consultar registros.
Modificar registros.
Eliminar registros.
Administrar categorías.

![Wireframe del panel de administrador](Docs/Wireframes/administrador.png)
