package syst.com.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syst.com.myapplication.ui.theme.LightBlue
import syst.com.myapplication.ui.theme.LightGreen
import syst.com.myapplication.ui.theme.MyApplicationTheme
import syst.com.myapplication.ui.theme.VeryLightGreen

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreendata()
                }
            }
        }
    }
}

@Composable
fun MainScreendata() {

    var selectedview by remember { mutableStateOf(Navitem.Profile) }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.weight(1f)) {

            when (selectedview) {

                Navitem.Home -> Home()
//                Navitem.Profile -> Profile()
                Navitem.Category -> Category()
                Navitem.Favorite -> Favorite()
                else -> {}
            }
        }
        bottomnavigation(selectedview) {
            selectedview = it
        }
    }
}

@Composable
fun bottomnavigation(selectedItem: Navitem, onItemClick: (Navitem) -> Unit) {

    var item = listOf(
        Navitem.Home, Navitem.Profile, Navitem.Category, Navitem.Favorite
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item.forEach {

            NavigarionItem(it, selectedItem) {
                onItemClick(it)
            }
        }
    }
}

@Composable
fun RowScope.NavigarionItem(currentItem: Navitem, selectedItem: Navitem, onItemClick: () -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .clickable { onItemClick() }) {
        Image(
            imageVector = currentItem.icon,
            contentDescription = "Action",
            colorFilter = ColorFilter.tint(if (selectedItem == currentItem) Color.Blue else Color.Gray)
        )
        Text(
            text = currentItem.title,
            color = if (selectedItem == currentItem) Color.Blue else Color.Gray
        )
    }
}


enum class Navitem(val route: String, var icon: ImageVector, var title: String) {

    Home("Home", Icons.Default.Home, "Home"), Profile(
        "profile", Icons.Default.Person, "Profile"
    ),
    Category("Category", Icons.Default.List, "Category"), Favorite(
        "favorite", Icons.Default.Favorite, "Favorite"
    )
}

@Composable
fun Home() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            LoginForm()
        }
    }
}

@Composable
fun LoginForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle action */ })
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle action */ }),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle login */ }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

//@Composable
//fun Profile() {
//
//    var selectedCard by remember { mutableStateOf("Yearly") }
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//    )
//    {
//        Column(
//            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Top
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.payment),
//                contentDescription = "Profile Image",
//                modifier = Modifier.size(175.dp)
//            )
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Choose the Right plan",
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.SansSerif
//                )
//            }
//            Text(
//                text = "Access to all premium features",
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.SansSerif,
//                color = Color.Gray
//            )
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(10.dp)
//            )
//
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Card(
//                    shape = RoundedCornerShape(15.dp), modifier = Modifier
//                        .width(200.dp)
//                        .height(40.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(50.dp),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .fillMaxSize(),
//                            horizontalArrangement = Arrangement.SpaceEvenly,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Card(
//                                shape = RoundedCornerShape(15.dp),
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(top = 2.dp, bottom = 2.dp)
//                                    .fillMaxHeight()
//                                    .fillMaxWidth()
//                                    .clickable { selectedCard = "Yearly" },
//                                colors = CardDefaults.cardColors(
//                                    containerColor = if (selectedCard == "Yearly") LightGreen else Color.LightGray
//                                )
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .padding(top = 5.dp, bottom = 5.dp),
//                                    contentAlignment = Alignment.Center
//                                ) {
//                                    Text(
//                                        fontSize = 15.sp,
//                                        text = "Yearly",
//                                        textAlign = TextAlign.Center,
//                                        color = Color.Black,
//                                        fontFamily = FontFamily.SansSerif,
//                                        style = MaterialTheme.typography.labelLarge
//                                    )
//                                }
//                            }
//                            Spacer(modifier = Modifier.width(10.dp))
//                            Card(
//                                shape = RoundedCornerShape(15.dp),
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(top = 2.dp, bottom = 2.dp)
//                                    .clickable { selectedCard = "Monthly" },
//                                colors = CardDefaults.cardColors(
//                                    containerColor = if (selectedCard == "Monthly") LightGreen else Color.LightGray
//                                )
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .padding(top = 5.dp, bottom = 5.dp),
//                                    contentAlignment = Alignment.Center
//                                ) {
//                                    Text(
//                                        fontSize = 15.sp,
//                                        text = "Monthly",
//                                        textAlign = TextAlign.Center,
//                                        color = Color.Black,
//                                        fontFamily = FontFamily.SansSerif,
//                                        style = MaterialTheme.typography.labelLarge
//
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//            ) {
//
//                Card(
//                    shape = RoundedCornerShape(15.dp), modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp)
//                        .height(400.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .wrapContentHeight()
//                    )
//                    {
//                        Column {
//                            Text(
//                                fontSize = 25.sp,
//                                text = "Plus",
//                                color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                modifier = Modifier.padding(15.dp).wrapContentHeight()
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//
//                            Text(
//                                text = "Powerful tools to the way your team", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                modifier = Modifier.padding(15.dp)
//                            )
//
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .background(VeryLightGreen)
//                                    .padding(15.dp),
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(
//                                    text = "$ ", color = Color.Gray,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 15.sp
//                                )
//                                Text(
//                                    text = "55", color = Color.Black,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 25.sp
//                                )
//                                Text(
//                                    text = " Per month", color = Color.Gray,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 15.sp
//                                )
//                            }
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//                            Text(
//                                text = "• Private Slide", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(10.dp)
//                            )
//                            Text(
//                                text = "• Access manage", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(10.dp)
//                            )
//                            Text(
//                                text = "• Private mode", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//
//                        }
//
//                    }
//                }
//                Card(
//                    shape = RoundedCornerShape(15.dp), modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp).height(400.dp),
//                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
//                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .wrapContentHeight()
//                    ) {
//                        Column {
//                            Text(
//                                fontSize = 25.sp,
//                                text = "Pro",
//                                color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                modifier = Modifier
//                                    .padding(15.dp)
//                                    .wrapContentHeight()
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//
//                            Text(
//                                text = "Powerful tools to the way your team", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                modifier = Modifier.padding(15.dp)
//                            )
//
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .background(VeryLightGreen)
//                                    .padding(15.dp),
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(
//                                    text = "$ ", color = Color.Gray,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 15.sp
//                                )
//                                Text(
//                                    text = "80", color = Color.Black,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 25.sp
//                                )
//                                Text(
//                                    text = " Per month", color = Color.Gray,
//                                    fontFamily = FontFamily.SansSerif,
//                                    style = MaterialTheme.typography.labelLarge,
//                                    fontSize = 15.sp,
//                                    textAlign = TextAlign.End
//                                )
//                            }
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(15.dp)
//                            )
//                            Text(
//                                text = "• Private Slide", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(10.dp)
//                            )
//                            Text(
//                                text = "• Access manage", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//                            Spacer(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .height(10.dp)
//                            )
//                            Text(
//                                text = "• Private mode", color = Color.Black,
//                                fontFamily = FontFamily.SansSerif,
//                                style = MaterialTheme.typography.labelLarge,
//                                fontSize = 15.sp,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(15.dp)
//                            )
//
//                        }
//
//                    }
//
//                }
//            }
//
//            Button(
//                onClick = { /* Handle button click */ },
//                modifier = Modifier
//                    .padding(top = 8.dp , start = 8.dp, end = 8.dp, bottom = 2.dp)
//                    .fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors( LightBlue// Set background color to navy blue
//                )
//            ) {
//                Text(text = "Continue",
//                    color = Color.Black
//                )
//            }
//
//                Text(text = "Cancel",
//                    color = Color.Gray,
//                    fontSize = 15.sp
//                , modifier = Modifier.padding(10.dp))
//
//        }
//    }
//}
//

data class Fruit(val name: String, val imageResId: Int)

// Sample list of fruits
val fruits = listOf(
    Fruit("Apple", R.drawable.apple),
    Fruit("Banana", R.drawable.banana),
    Fruit("Orange", R.drawable.orange),
    Fruit("Grapes", R.drawable.straberry),

    Fruit("Pineapple", R.drawable.pineapple),
)

@Composable
fun FruitItem(fruit: Fruit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = fruit.imageResId),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = fruit.name, fontWeight = FontWeight.Bold, fontSize = 18.sp
        )
    }
}


@Composable
fun Category() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(fruits) { fruit ->
            FruitItem(fruit)
        }
    }

}

@Composable
fun Favorite() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(favoriteItems) { item ->
            FavoriteItemRow(item)
        }
    }
}

data class FavoriteItem(val name: String, val imageResId: Int)

// Sample list of favorite items
val favoriteItems = listOf(
    FavoriteItem("The Shawshank Redemption", R.drawable.apple),
    FavoriteItem("Inception", R.drawable.banana),
    FavoriteItem("The Dark Knight", R.drawable.pineapple),
    FavoriteItem("Forrest Gump", R.drawable.straberry)
    // Add more items as needed
)

@Composable
fun FavoriteItemRow(item: FavoriteItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Mainscreenpreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        MainScreendata()
    }
}
