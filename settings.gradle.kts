pluginManagement {
    repositories {
//        includeBuild("convention")
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

rootProject.name = "StarsWar"
include(":app")
include(":core:database")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":core:test-doubles")
include(":sync:work")
include(":core:data:datasource")
include(":core:data:repository")
include(":core:domain")
include(":feature:search")
include(":core:common")
include(":feature:home")
include(":feature:details")
include(":core:data:pagingsource")
