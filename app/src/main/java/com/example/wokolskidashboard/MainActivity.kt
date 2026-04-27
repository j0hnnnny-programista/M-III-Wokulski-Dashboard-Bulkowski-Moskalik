package com.example.wokolskidashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wokolskidashboard.ui.MainScreen
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WokolskiDashBoardTheme {
                MainScreen()
            }
        }
    }
}