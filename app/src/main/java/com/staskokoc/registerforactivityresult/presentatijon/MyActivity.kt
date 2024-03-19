package com.staskokoc.registerforactivityresult.presentatijon

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staskokoc.registerforactivityresult.presentatijon.theme.RegisterForActivityResultTheme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                        var text by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            value = text,
                            onValueChange = { newText -> text = newText },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(all = 4.dp),
                            textStyle = TextStyle(fontSize = 18.sp),
                            singleLine = true,
                            placeholder = { Text("Enter some text") },
                            shape = RoundedCornerShape(4.dp),
                        )
                        Button(
                            onClick = {
                                val intent = Intent()
                                intent.putExtra("text", text)
                                setResult(RESULT_OK, intent)
                                finish() // закрываем активити
                            }
                        ) {
                            Text(text = "SEND TO ANOTHER ACTIVITY")
                        }
                    }
                }
            }
        }
    }
}