package com.example.bark

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bark.data.Puppy
import com.example.bark.ui.theme.BarkTheme


class ProfileActivity : ComponentActivity() {
    private val puppy:Puppy by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as Puppy
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarkTheme {
              ProfileScreen(puppy = puppy)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, puppy: Puppy) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID,puppy)
            }
    }
}