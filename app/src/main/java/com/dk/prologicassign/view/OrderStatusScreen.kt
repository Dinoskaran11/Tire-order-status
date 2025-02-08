package com.dk.prologicassign.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dk.prologicassign.R
import com.dk.prologicassign.models.OrderStatus
import com.dk.prologicassign.models.TireItem
import com.dk.prologicassign.viewmodels.OrderViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderStatusScreen(viewModel: OrderViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Order Status")
                },
                navigationIcon = {
                    Icon(
                        Icons.Default.KeyboardArrowLeft, contentDescription = "back"
                    )
                }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                LazyColumn {
                    itemsIndexed(viewModel.orderStatusList) { index, status ->
                        OrderStatusItem(
                            status,
                            isLastItem = index == viewModel.orderStatusList.lastIndex
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    "Tires",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    items(viewModel.tireList) { tire ->
                        TireItemCard(tire)
                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${viewModel.tireList.size} Tires", fontSize = 16.sp)
                Text(
                    "Rs ${viewModel.tireList.sumOf { it.pricePerUnit * it.quantity }}0",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Composable
fun OrderStatusItem(status: OrderStatus, isLastItem: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 4.dp, bottom = 4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Icon(
                painter = if (status.status) painterResource(R.drawable.check_circle) else painterResource(
                    R.drawable.radio_unchecked
                ),
                contentDescription = null,
                tint = if (status.status) Color.Black else Color.Gray,
                modifier = Modifier.size(20.dp)
            )
            if (!isLastItem) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(24.dp)
                        .background(if (status.status) Color.Black else Color.Gray.copy(alpha = 0.5f))
                )
            }
        }
        Column {
            Text(
                text = status.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                text = "Date: ${status.date}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun TireItemCard(tire: TireItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, bottom = 6.dp, top = 6.dp, end = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (name, quantity, unit, price) = createRefs()
                Text(
                    tire.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.constrainAs(name) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    })

                Text(
                    " ${tire.quantity}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.constrainAs(quantity) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    })

                Text(
                    "Rs ${tire.pricePerUnit * tire.quantity}0",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.constrainAs(price) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(quantity.bottom, 10.dp)

                    })

                Row(
                    modifier = Modifier.constrainAs(unit) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(name.bottom, 10.dp)
                    }, horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painterResource(R.drawable.car_svgrepo),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text("Rs ${tire.pricePerUnit}0", fontWeight = FontWeight.SemiBold)
                }


            }


        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    OrderStatusScreen(viewModel = OrderViewModel())
//}