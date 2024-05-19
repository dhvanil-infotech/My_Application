package syst.com.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import syst.com.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen(){

    var selectedScreen by remember { mutableStateOf(BottomNavItem.Home) }

    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            when(selectedScreen) {
                BottomNavItem.Home -> HomeScreen()
                BottomNavItem.Profile -> ProfileScreen()
                BottomNavItem.Favorite -> FavoriteScreen()
                BottomNavItem.Category -> CategoryScreen()
            }
        }
        BottomNavigationView(selectedScreen) {
            selectedScreen = it
        }
    }
}

@Composable
fun BottomNavigationView(selectedItem: BottomNavItem, onItemClick: (BottomNavItem) -> Unit) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Favorite,
        BottomNavItem.Category
    )
    Row(modifier =  Modifier.fillMaxWidth().height(56.dp), verticalAlignment = Alignment.CenterVertically) {
        items.forEach {
            NavigationItemButton(it, selectedItem) {
                onItemClick(it)
            }
        }
    }
}

@Composable
fun RowScope.NavigationItemButton(currentItem: BottomNavItem, selectedItem: BottomNavItem, onItemClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .weight(1f)
        .clickable { onItemClick() }) {
        Image(imageVector = currentItem.icon, contentDescription = "Action", colorFilter = ColorFilter.tint(if (selectedItem == currentItem) Color.Blue else Color.Gray))
        Text(text = currentItem.title, color = if (selectedItem == currentItem) Color.Blue else Color.Gray)
    }
}

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Screen", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ProfileScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Profile Screen", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun FavoriteScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Favorite Screen", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun CategoryScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Category Screen", modifier = Modifier.padding(16.dp))
    }
}

enum class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    Home("home", Icons.Default.Home, "Home"),
    Profile("profile", Icons.Default.Person, "Profile"),
    Favorite("favorite", Icons.Default.Favorite, "Favorite"),
    Category("category", Icons.Default.List, "Category")
}


@Composable
fun LoginScreen(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Screen 1")
            Button(
                onClick = { navController.navigate("screen2") },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Next Screen")
            }
        }

    }

}

@Composable
fun Dashboardscreen(navController: NavController) {

    val nameList = arrayListOf<String>().apply {
        for (number in 0..10) {
            add("$number User")
        }
    }

    val name = arrayListOf<String>().apply {

        for (name in 0..10) {

            add("$name name")
        }
    }
    val nametreding = arrayListOf<TrendingItem>().apply {
        for (index in 1..9) {
            add(TrendingItem(name = "$index Trending", price = "${index * 100}"))
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Transparent)

    ) {

        Column {
            Card(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Column(Modifier.padding(15.dp)) {
                    Row {
                        Text(
                            text = "Tops Authers",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .weight(1f)

                        )
                        Text(
                            text = "See All",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .weight(1f),
                            textAlign = TextAlign.End
                        )
                    }
                    LazyRow(Modifier.fillMaxWidth()) {
                        items(nameList) {
                            UserProfileIcon(name = it)
                        }
                    }

                }
            }
            LazyRow(Modifier.fillMaxWidth()) {
                items(name) {
                    button(name = it)
                }
            }
            Card(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Column(Modifier.padding(15.dp)) {
                    Row {
                        Text(
                            text = "Tops Treading",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                                .weight(1f)

                        )
                        Text(
                            text = "See All",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .weight(1f),
                            textAlign = TextAlign.End
                        )
                    }
                    LazyRow(Modifier.fillMaxWidth()) {
                        items(nametreding) { item ->
                            Contain(item = item, Modifier)
                        }
                    }
                    Button(
                        onClick = { navController.navigate("screen1") },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Next Screen")
                    }

                }
            }

        }

    }
}
@Composable
fun button(name: String) {

    Card(
        Modifier.padding(start = 0.dp, end = 10.dp, top = 15.dp, bottom = 15.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            Text(text = name,
                style = MaterialTheme.typography.labelLarge)
        }
    }
}
@Composable
fun Contain(item: TrendingItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth(),
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Profile Image",
                modifier = Modifier.size(80.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp)) // Add some space between elements if needed
        Text(
            text = item.name,
            textAlign = TextAlign.Center
        )
        Text(
            text = item.price,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun UserProfileIcon(name: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier.size(80.dp)
            )
        }

        Text(text = name,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp))

    }
}

@Preview(
    showBackground = true, showSystemUi = true, device = "spec:parent=pixel_5,orientation=portrait"
)
@Composable
fun DashboardPreview() {
  MainScreen()
}


