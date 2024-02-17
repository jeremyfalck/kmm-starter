package com.jfalck.kmmstarter.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jfalck.kmmstarter.android.presentation.MainActivity.Companion.ROUTE_GREETING
import com.jfalck.kmmstarter.android.presentation.MainActivity.Companion.ROUTE_TEXT
import com.jfalck.kmmstarter.android.presentation.app.MyApplicationTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    companion object {
        const val ROUTE_GREETING = "ROUTE_GREETING"
        const val ROUTE_TEXT = "ROUTE_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        setContent {
            val navController = rememberNavController()
            KoinAndroidContext() {
                AppTheme {
                    /*val text by mainViewModel.greetingStateFlow.collectAsState()
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(text)
                    }*/
                    AppNavHost()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Text("Hello !")
    }
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_GREETING
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_GREETING) {
            Greeting()
        }
        composable(ROUTE_TEXT) {
            Text(text = "This is a text")
        }
    }
}

@Composable
fun Greeting(greetingViewModel: GreetingViewModel = koinViewModel()) {
    val text by greetingViewModel.greetingStateFlow.collectAsState()
    Text(text)
}

