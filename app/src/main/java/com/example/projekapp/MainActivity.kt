package com.example.projekapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.projekapp.Screens.BelumAdaScreen
import com.example.projekapp.Screens.DiterimaScreen
import com.example.projekapp.ui.theme.ProjekAppTheme
import com.example.projekapp.ui.theme.ProjekAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekAppTheme {
                StatusApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusApp() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Diterima", "Belum Ada")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Status", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.smallTopAppBarColors()
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> DiterimaScreen()
                1 -> BelumAdaScreen()
            }
        }
    }
}