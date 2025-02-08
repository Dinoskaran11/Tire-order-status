package com.dk.prologicassign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dk.prologicassign.ui.theme.PrologicAssignTheme
import com.dk.prologicassign.view.OrderStatusScreen
import com.dk.prologicassign.viewmodels.OrderViewModel

class MainActivity : ComponentActivity() {
    private  var orderViewModel = OrderViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrologicAssignTheme {
                OrderStatusScreen(orderViewModel)
            }
        }
    }
}



