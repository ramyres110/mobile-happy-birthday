package com.ramyres.curso.android.basic.compose.happybirthday

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramyres.curso.android.basic.compose.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var state_name: String by rememberSaveable {
                        mutableStateOf("")
                    }

                    var state_from: String by rememberSaveable {
                        mutableStateOf("")
                    }

                    val template_message = stringResource(R.string.happy_birthday_text)
                    val template_from = stringResource(R.string.signature_text);

                    if (state_name.isEmpty()) {
                        FormSettings(onClickBuildCard = { name, from ->
                            state_name = name
                            state_from = from
                        })
                    } else {
                        GreetingImage(
                            message = "$template_message $state_name",
                            from = "$template_from $state_from",
                            modifier = Modifier.padding(8.dp),
                            onClickBack = {
                                state_name = "Parabéns"
                                state_from = ""
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(
    message: String,
    from: String,
    onClickBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
        OutlinedButton(
            modifier = Modifier.padding(top = 50.dp, start = 10.dp),
            onClick = {
                onClickBack()
            }
        ) {
            Text(text = "<")
        }
    }
}

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    Text(text = "Hello")
}

@Composable
fun FormSettings(
    onClickBuildCard: (name: String, from: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name: String by remember {
        mutableStateOf("")
    }

    var from: String by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Settings",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 30.dp, top = 90.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(text = "Birthday name:",
            fontSize = 20.sp)
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(text = "From name:",
            fontSize = 20.sp)
        TextField(
            value = from,
            onValueChange = { from = it },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedButton(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            onClick = {
                onClickBuildCard(name, from)
            }) {
            Text(
                text = "Build Birthday Card",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Greeting",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun BirthdayCardPreview() {
    val template_message = stringResource(R.string.happy_birthday_text)
    val template_from = stringResource(R.string.signature_text)
    val message = "$template_message Mamãe"
    val from = "$template_from Papai"

    HappyBirthdayTheme {
        GreetingImage(
            message,
            from
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun FormSettingsPreview() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            FormSettings(
                onClickBuildCard = { name, from -> }
            )
        }
    }
}