pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StarWars"
include(":app")
include(":core:data:datasource")
include(":feature:search")
include(":sync:work")
include(":feature:details")
include(":feature:home")
include(":core:data:repository")
include(":core:common")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":core:domain")
include(":core:test-doubles")
