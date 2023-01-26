package com.example.jetpackcomposeinlegacyprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.jetpackcomposeinlegacyprojects.databinding.ActivityMainBinding
import com.example.jetpackcomposeinlegacyprojects.databinding.XmlResourceFileBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.composeView.setContent {
            DemoComposeView()

        }
    }
}

@Preview
@Composable
fun DemoComposeView(){
    var counter = remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top) {
        Text(
            text = "This view is in compose ${counter.value}",
            textAlign = TextAlign.Center,
            fontSize = 28.sp
        )

        AndroidViewBinding(XmlResourceFileBinding::inflate){
            this.button.setOnClickListener {
                this.textView2.text = "Looks like this works ${++counter.value}"
            }
        }
    }
}