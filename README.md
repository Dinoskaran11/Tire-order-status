![Image](https://github.com/user-attachments/assets/90bc3b6a-59cd-4cc0-beed-658cdfb14442)

Order Status Screen - Jetpack Compose Implementation

Overview

The Order Status Screen is implemented using Jetpack Compose to display order statuses and tire items while keeping the total price section fixed at the bottom. This ensures a smooth user experience where new items do not push the total price section down, and the order details remain scrollable.

Implementation Approach

1. Using Box as the Parent Layout

- The entire UI is wrapped inside a Box to allow layering elements.

- This allows us to have a scrollable list (LazyColumn) and a fixed bottom section (TotalPrice).

2. Top Section: TopAppBar

- Displays the title and navigation back button.

- Uses TopAppBarDefaults.topAppBarColors for styling.

3. Main Content: Scrollable Order and Tire Lists

- A Column with Modifier.weight(1f) ensures that the content expands to take available space but doesn’t push the bottom section.

- Order Status List (LazyColumn):

   ---- Displays a list of order statuses.

   ---- Uses OrderStatusItem composable to show status icons and labels.

- Tire Items List (LazyColumn):

   ---- Displays a list of ordered tires.

   ---- Uses TireItemCard composable for item representation.

4. Keeping the Total Price Fixed at the Bottom

- The TotalPrice section is wrapped inside a Card.

- Placed inside Box using Modifier.align(Alignment.BottomCenter), ensuring it remains pinned at the bottom.

- Displays the total price dynamically based on the sum of tire prices.


