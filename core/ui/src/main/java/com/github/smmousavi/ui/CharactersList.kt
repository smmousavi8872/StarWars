package com.github.smmousavi.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.github.smmousavi.model.Character
import com.github.smmousavi.test_doubles.character.Faker


@Composable
fun CharacterList(characters: LazyPagingItems<Character>, onClick: (String) -> Unit = {}) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
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
                    CharacterItem(it) { id ->
                        onClick(id)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    val characters = Faker.characterList()
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        items(characters.size) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                characters[index].let {
                    CharacterItem(it) { id ->
                    }
                }
            }
        }
    }
}
