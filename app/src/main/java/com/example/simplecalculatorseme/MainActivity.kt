package com.example.simplecalculatorseme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecalculatorseme.ui.theme.SimpleCalculatorSemeTheme
import com.example.simplecalculatorseme.ui.theme.SimpleCalculatorSemeTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorSemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SimpleCalculator()
                }
            }
        }
    }
}

@Composable
fun SimpleCalculator() {
    val context= LocalContext.current

    var x by remember {mutableStateOf("")}
    var y by remember {mutableStateOf("")}
    var sum by remember {mutableStateOf("")}
    var subtraction by remember {mutableStateOf("")}
    var product by remember {mutableStateOf("")}
    var division by remember {mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = x, onValueChange ={x=it},
            placeholder = { Text(text = "Enter first number")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = y, onValueChange ={y=it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Enter Second number")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            Button(onClick = {
                var x1=x.toInt()
                var y1=y.toInt()
                sum=(x1+y1).toString()
                Toast.makeText(context,"Sum=$sum",Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "+")

            }
            Button(onClick = {
                var x1=x.toInt()
                var y1=y.toInt()
                subtraction=(x1-y1).toString()
                Toast.makeText(context,"Substraction=$subtraction",Toast.LENGTH_SHORT).show()}) {
                Text(text = "-")

            }
            Button(onClick = {
                var x1=x.toInt()
                var y1=y.toInt()
                product=(x1*y1).toString()
                Toast.makeText(context,"Product=$product",Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "*")

            }
            Button(onClick = {
                var x1=x.toInt()
                var y1=y.toInt()
                product=(x1/y1).toString()
                Toast.makeText(context,"Division=$division",Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "/")

            }
        }

        Text(text = "Sum=$sum")
        Text(text = "Subtraction=$subtraction")
        Text(text = "Product=$product")
        Text(text = "Division=$division")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleCalculatorSemeTheme {
        SimpleCalculator()
    }
}