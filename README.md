Actividad 1. CRUD con Room

Descripción Breve
Este proyecto es una aplicación de demostración para Android que implementa un CRUD (Crear, Actualizar, Eliminar) básico para gestionar tareas simples.
Utiliza Java como lenguaje principal y Room Persistence Library como capa de abstracción sobre SQLite para la gestión eficiente de la base de datos local

Instalacion
1. Clonar el Repositorio
Abre la terminal de Git en tu computadora y clona el proyecto:

Bash

git clone https://github.com/AlexisLopez22/CrudConRomFinal.git
2. Abrir en Android Studio
Abre Android Studio.

Selecciona File > Open y navega hasta la carpeta CrudConRomFinal que acabas de clonar.

Espera a que Android Studio descargue y sincronice todas las dependencias de Gradle.

3. Verificar Dependencias (build.gradle)
Asegúrate de que el archivo build.gradle (Módulo: app) contenga las librerías necesarias para Room y RecyclerView

Base de Datos
Entidad: Task.java
Esta clase define la tabla de la base de datos
DAO Data Access Object
Database: AppDatabase.java




