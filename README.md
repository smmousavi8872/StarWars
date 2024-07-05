# StarWars

## Handing Nested API

The API Requests from SWAPI are nested apis, so to handle them GraphQL was used.
[Here](https://www.apollographql.com/docs/kotlin) is the full documentation of How to use GraphQL in Android.

To Download graphql schema use the following gradle command
```
 ./gradlew :core:network:downloadApolloSchema --endpoint='https://swapi-graphql.netlify.app/.netlify/functions/index' --schema=core/network/src/main/graphql/schema
```