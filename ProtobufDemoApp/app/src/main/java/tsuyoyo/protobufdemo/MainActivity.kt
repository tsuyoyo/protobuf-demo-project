package tsuyoyo.protobufdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import tsuyoyo.protobuf.demo.Book
import tsuyoyo.protobufdemo.ui.theme.ProtobufDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProtobufDemoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    coroutineScope {
                        async(Dispatchers.Default) {
                            val request = Request
                                .Builder()
                                .url("http://10.0.2.2:3000/books/1")
                                .build()
                            val response = OkHttpClient().newCall(request).execute()
                            val bookObj = response.body?.let {
                                Book.ADAPTER.decode(it.byteStream())
                            }
                            if (bookObj == null) {
                                Log.d("TestTestTest", "Failed to decode")
                            } else {
                                Log.d("TestTestTest", bookObj.id.toString())
                                Log.d("TestTestTest", bookObj.title)
                                Log.d("TestTestTest", bookObj.genre.name)
                                Log.d("TestTestTest", bookObj.author?.id?.toString() ?: "No author ID")
                                Log.d("TestTestTest", bookObj.author?.name ?: "No author name")
                                Log.d("TestTestTest", bookObj.author?.penName ?: "No author penName")
                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.d("TestTestTest", "Error - ${e.message}")
                }
            }
        },
    ) {
        Text(text = "Call API")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProtobufDemoAppTheme {
        Greeting("Android")
    }
}
