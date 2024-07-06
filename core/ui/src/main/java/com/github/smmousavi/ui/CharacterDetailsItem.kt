package com.github.smmousavi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.smmousavi.model.Character

@Composable
fun CharacterDetailsItem(
    modifier: Modifier = Modifier,
    character: Character,
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("Name: ${character.name}", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(10.dp))
        Text("Height: ${character.height}")
        Text("Mass: ${character.mass}")
        Text("Hair Color: ${character.hairColor}")
        Text("Skin Color: ${character.skinColor}")
        Text("Eye Color: ${character.eyeColor}")
        Text("Birth Year: ${character.birthYear}")
        Text("Gender: ${character.gender}")
        Spacer(Modifier.height(10.dp))
//        Text("Homeworld: ${character.homeworld}", style = MaterialTheme.typography.subtitle1)
        Spacer(Modifier.height(20.dp))
        Text("Films:")
//        person.films.forEach { film ->
//            Text("• $film")
//        }
    }
}