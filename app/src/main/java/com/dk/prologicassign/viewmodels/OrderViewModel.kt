package com.dk.prologicassign.viewmodels

import androidx.lifecycle.ViewModel
import com.dk.prologicassign.models.OrderStatus
import com.dk.prologicassign.models.TireItem

class OrderViewModel : ViewModel() {

    val orderStatusList = listOf(
        OrderStatus("Order Confirmation", "2024-01-10", true),
        OrderStatus("Area Sales Manager", "2024-01-10", true),
        OrderStatus("Product Manager", "2024-01-10", true),
        OrderStatus("Sales Admin", "2024-01-10", true),
        OrderStatus("Credit", "2024-01-10", true),
        OrderStatus("Delivery Created", "2024-01-10", true),
        OrderStatus("Invoice", "Pending", false),
        OrderStatus("Dispatch", "Pending", false),
    )

    val tireList = listOf(
        TireItem("205/55R16 Eternopresa", 50, 5600.00),
        TireItem("205/55R16 Eternopresa", 25, 7600.00),
        TireItem("105/55R16 Eternopresa", 35, 5600.00),
        TireItem("105/55R16 Eternopresa", 35, 5600.00),
    )
}