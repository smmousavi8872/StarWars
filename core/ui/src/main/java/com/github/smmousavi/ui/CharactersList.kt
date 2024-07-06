package com.github.smmousavi.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.github.smmousavi.model.Character


@Composable
fun CharacterList(characters: LazyPagingItems<Character>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(characters.itemCount) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                characters[index]?.let {
                    CharacterItem(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    val sampleProducts = listOf(
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        ),
        Character(
            id = "1",
            name = "Mohsen",
            birthYear = "2000",
            height = 180,
            gender = "male",
            skinColor = "White",
            hairColor = "Black",
            eyeColor = "Brown",
            mass = 70.3,
        )
    )
//    CharacterList(characters = sampleProducts)
}
