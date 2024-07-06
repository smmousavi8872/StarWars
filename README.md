# StarsWar

StarsWar is a Star Wars API client application leveraging modern Android development technologies and architectural principles. This project is structured to maximize cohesion and minimize coupling, ensuring maintainability and scalability.

## Technologies Used

- **Hilt**: For dependency injection, streamlining and simplifying the process.
- **GraphQL**: Handles nested API requests from SWAPI, providing efficient and flexible data retrieval.
- **Paging 3**: Manages large datasets and provides seamless pagination.
- **Flow**: Handles asynchronous data streams in a reactive way.
- **Clean Architecture**: Promotes separation of concerns and maintainability.
- **Modular Structure**: Organizes the codebase into modules for better scalability and reusability.

## Project Structure

### Modules

1. **App Module**
    - **Purpose**: Main entry point of the application.
    - **Contents**: Application-wide configurations, main activity, Hilt initialization.
    - **Coupling**: Minimal coupling with other modules via interfaces and dependency injection.

2. **Core Module**
    - **Purpose**: Contains core functionalities and shared components.
    - **Contents**: Network configurations, base classes, common utilities.
    - **Coupling**: Provides services without depending on feature-specific details.

3. **Feature Modules**
    - **Purpose**: Encapsulate different features of the application.
    - **Contents**: Feature-specific UI components, ViewModels, use cases.
    - **Coupling**: Communicate with the core module and other feature modules through defined interfaces.

4. **Gradle Module**
    - **Purpose**: Manages build configurations and dependencies.
    - **Contents**: Centralized dependency management using Kotlin DSL.
    - **Coupling**: Isolated from application logic, focuses on build-time configurations.

### Clean Architecture Layers

1. **Presentation Layer**
    - **Components**: Activities, Fragments, ViewModels, UI components.
    - **Coupling**: Interacts with the domain layer via ViewModel; independent of data layer details.

2. **Domain Layer**
    - **Components**: Use cases, domain models.
    - **Coupling**: Independent of other layers, ensuring business logic is decoupled from data and presentation concerns.

3. **Data Layer**
    - **Components**: Repositories, data sources, network services.
    - **Coupling**: Depends on the core module for network configurations but provides interfaces to the domain layer.

## Loose Coupling Strategies

- **Dependency Injection**: Using Hilt to inject dependencies, reducing direct instantiation and enhancing testability.
- **Interface Segregation**: Modules communicate through well-defined interfaces, hiding implementation details and allowing interchangeability.
- **Modularization**: Isolating features and services into distinct modules, making the codebase more manageable and navigable.

## Note
The API requests from SWAPI are nested APIs, so to handle them GraphQL was used. [Here](https://www.apollographql.com/docs/kotlin) is the full documentation on how to use GraphQL in Android.

To download the GraphQL schema, use the following Gradle command:
```bash
 ./gradlew :core:network:downloadApolloSchema --endpoint='https://swapi-graphql.netlify.app/.netlify/functions/index' --schema=core/network/src/main/graphql/schema
```

## How to Run

1. Clone the repository: `git clone https://github.com/smmousavi8872/StarsWar`
2. Open the project in Android Studio.
3. Build and run the application on an emulator or device.


