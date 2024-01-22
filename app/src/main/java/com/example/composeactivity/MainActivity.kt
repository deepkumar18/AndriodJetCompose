package com.example.composeactivity

import android.annotation.SuppressLint
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeactivity.ui.theme.ComposeActivityTheme
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.modifier.modifierLocalConsumer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeActivityTheme {
                // A surface container using the 'background' color from the theme
             Column(modifier = Modifier.fillMaxSize(),
                 verticalArrangement = Arrangement.Center,
                 horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 Text(text = "0",
                     fontSize = 30.sp
                 )
                 Button(onClick = { 
                     
                 }) {
                     Text(text = "Click Me")
                 }
             }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeActivityTheme {
        var name by remember {
            mutableStateOf("")
        }
        var names by remember {
            mutableStateOf(listOf<String>())
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
               OutlinedTextField(value = name, onValueChange = { text ->
                   name = text
               },
                   modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.width(18.dp))
                Button(onClick = {
                    if(name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }) {
                    Text(text = "Add")
                }
            }
            LazyColumn {
               items(names) {nameOf ->
                   Text(text = nameOf,
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(16.dp)
                   )
                   Divider()
               }
            }

        }
    }
}




