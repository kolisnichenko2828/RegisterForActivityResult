package com.staskokoc.registerforactivityresult.presentatijon

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.staskokoc.registerforactivityresult.presentatijon.theme.RegisterForActivityResultTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var textFromLauncher by mutableStateOf("text from another activity")
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                textFromLauncher = result.data?.getStringExtra("text") ?: textFromLauncher
            }
        }

        setContent {
            RegisterForActivityResultTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = textFromLauncher)
                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, MyActivity::class.java)
                                launcher.launch(intent)
                            }
                        ) {
                            Text(text = "GET RESULT FROM ANOTHER ACTIVITY")
                        }
                    }
                }
            }
        }

    }
}