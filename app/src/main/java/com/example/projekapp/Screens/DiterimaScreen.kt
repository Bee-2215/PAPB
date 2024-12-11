package com.example.projekapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projekapp.Components.ListItemCard

@Composable
fun DiterimaScreen() {
    var itemName by remember { mutableStateOf("") }
    val itemList = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Nama Barang Diterima") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (itemName.isNotEmpty()) {
                    itemList.add(itemName)
                    itemName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tambah Barang")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(itemList.size) { index ->
                ListItemCard(
                    title = itemList[index],
                    buttonText = "Barang Diterima",
                    backgroundColorHex = 0xFF4CAF50
                )
            }
        }
    }
}