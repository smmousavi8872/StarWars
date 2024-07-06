package com.github.smmousavi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.smmousavi.model.Character
import com.github.smmousavi.test_doubles.character.Faker

@Composable
fun CharacterDetailsItem(
    modifier: Modifier = Modifier,
    character: Character,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Name: ${character.name}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))
        Text("Height: ${character.height} cm")
        Text("Hair Color: ${character.hairColor}")
        Text("Skin Color: ${character.skinColor}")
        Text("Eye Color: ${character.eyeColor}")
        Text("Birth Year: ${character.birthYear}")
        Text("Gender: ${character.gender}")

        Spacer(Modifier.height(16.dp))

        Text("Species: ${character.species.name}")
        Text("Language: ${character.species.language}")

        Spacer(Modifier.height(16.dp))

        Text("Homeworld: ${character.species.homeWorld.name}")
        Text("Population: ${character.species.homeWorld.population}")

        Spacer(Modifier.height(16.dp))

        Text("Films:")

        Spacer(Modifier.height(4.dp))

        character.films.forEach { film ->
            Text(
                "•  ${film.title}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                film.openingCrawl,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterDetailsItemPreview() {
    CharacterDetailsItem(character = Faker.character())
}
