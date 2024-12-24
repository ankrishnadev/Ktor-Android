package com.krishna.ktor_android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.krishna.ktor_android.data.model.SearchResults
import com.krishna.ktor_android.data.viewmodel.MainViewModel
import com.krishna.ktor_android.ui.theme.KtorAndroidTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel = ViewModelProvider.create(this)[MainViewModel::class]
        viewModel.getSearchMoviesResult()

        setContent {
            KtorAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current
    var searchQueryResults by remember { mutableStateOf(SearchResults()) }

    LaunchedEffect(Unit) {
        viewModel.searchResults.observe(lifecycleOwner) { result ->
            result?.let {
                searchQueryResults = it
            }
        }
    }

    Text(
        text = searchQueryResults.description.toString(),
        modifier = modifier
    )
}