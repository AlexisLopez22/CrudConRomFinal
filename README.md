Actividad 1. CRUD con Room

Descripción

Aplicación que permite gestionar tareas (agregar, editar, eliminar y listar) usando Room y SQLite, con validaciones básicas.

Instalacion
1. Clonar el Repositorio
Abre la terminal de Git en tu computadora y clona el proyecto:

git clone https://github.com/AlexisLopez22/CrudConRomFinal.git

2. Abrir en Android Studio
Abre Android Studio.

Selecciona File > Open y navega hasta la carpeta CrudConRomFinal que acabas de clonar.

Espera a que Android Studio descargue y sincronice todas las dependencias de Gradle.

3. Verificar Dependencias (build.gradle)
Asegúrate de que el archivo build.gradle (Módulo: app) contenga las librerías necesarias para Room y RecyclerView

4- Sincronizar el Proyecto Android Studio comenzará a configurar el proyecto automáticamente.
Espera a que termine la barra de carga en la parte inferior derecha.

Si ves un botón que dice "Sync Now" o un elefante gris en la barra de herramientas, dale clic para descargar las dependencias necesarias.

5- Ejecutar la App Conecta tu celular por USB o inicia un Emulador en Android Studio.


Estructura de la base de datos

Entidad Task (tabla: tasks)
id, task_title, task_description, created_at ,is_completed

DAO – Operaciones

Insertar tarea

Actualizar tarea

Eliminar tarea

Obtener todas las tareas



