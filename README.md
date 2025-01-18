# GeekTora Store

GeekTora Store es un proyecto de desarrollo de una página web para la visualización y gestión de un catálogo de productos de figuras de colección y otros artículos relacionados con anime de diferentes franquicias. Este proyecto se caracteriza por un enfoque ágil, utilizando la metodología Scrum con dos sprints para su implementación.

## Tecnologías Utilizadas

### Backend
- **Framework**: Java Spring Boot 21
- **Descripción**: Se utiliza para manejar la lógica del servidor, incluyendo la gestión de datos, integración con la base de datos y creación de APIs RESTful.

### Frontend
- **Framework**: Angular 19
- **Descripción**: Proporciona una interfaz de usuario interactiva y dinámica, permitiendo a los usuarios explorar y gestionar el catálogo de productos.

### Despliegue
- **Plataforma**: AWS
  - **EC2**: Servidor de aplicación.
  - **S3**: Almacenamiento de activos estáticos.

## Diagramas

### Diagrama de Base de Datos
![BD - INSANO JUGUETES drawio](https://github.com/user-attachments/assets/217028b2-8c9a-4059-8e31-8ce8fb95a587)


### Diagrama de Clases
![DIAGRAMA DE CLASES drawio](https://github.com/user-attachments/assets/c4a6033e-1265-4c16-876d-187eaf977c3d)


## Características Principales
- **Catálogo de Productos**: Permite a los usuarios explorar una amplia variedad de figuras de colección y productos relacionados con anime.
- **Búsqueda y Filtrado**: Los usuarios pueden buscar productos por franquicia, tipo de figura, precio y otras características.
- **Interfaz Dinámica**: Diseño responsivo y atractivo desarrollado con Angular 19.
- **Seguridad y Escalabilidad**: Implementadas en el backend con Java Spring Boot 21.

## Metodología de Desarrollo
El desarrollo de GeekTora Store sigue la metodología Scrum, estructurándose en dos sprints:
1. **Sprint 1**: Configuración inicial del proyecto, implementación de la estructura del backend y creación de las primeras vistas del frontend.
2. **Sprint 2**: Integración completa del backend y frontend, refinamiento de funcionalidades y despliegue en AWS.

## Requisitos Previos
Para ejecutar el proyecto localmente, asegúrate de tener instalados:
- **Java**: Versión 21.0.4
- **Node.js**: Versión 22.11.0
- **Angular CLI**: Versión 19.
- **AWS**: Deploy.

## Estrucutra del proyecto
```bash
src
└── main
    ├── java
    │   └── com.geektora.geektora_api
    │       ├── config/        
    │       ├── controller/        
    │       ├── dto/            
    │       ├── entity/
    │       ├── repository/
    │       ├── service/
    │       ├── service/impl/
    │       ├── util/
    │       ├── exception/
    │       ├── security/
    │       └── mapper/
    └── resources
        ├── templates/
        ├── static/
        ├── application.properties
        └── schema.sql
   ```
## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/CharlieMB391823891239/GeekTora-Store.git
   ```

2. Configura el backend:
   ```bash
   cd geektora-api
   ```

3. Configura el frontend:
   ```bash
   cd frontend
   npm install
   ng serve
   ```

4. Accede a la aplicación en tu navegador:

## Despliegue en AWS
Los detalles del despliegue en AWS se encuentran en la documentación adicional del repositorio.

---

Este proyecto es mantenido y desarrollado por el equipo de GeekTora. Las contribuciones son bienvenidas mediante pull requests.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT.
