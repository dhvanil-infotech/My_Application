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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syst.com.myapplication.ui.theme.LightBlue
import syst.com.myapplication.ui.theme.LightGreen
import syst.com.myapplication.ui.theme.MyApplicationTheme
import syst.com.myapplication.ui.theme.VeryLightGreen

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile1()
                }
            }
        }
    }
}

@Composable
fun Profile1() {

    var selectedCard by remember { mutableStateOf("Yearly") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_logo),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Choose the Right plan",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Text(
                text = "Access to all premium features",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                modifier = Modifier.padding(top = 15.dp)
            )

            Row(

                modifier = Modifier.padding(top = 15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    shape = RoundedCornerShape(15.dp), modifier = Modifier
                        .width(200.dp)
                        .height(40.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 2.dp, bottom = 2.dp)
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .clickable { selectedCard = "Yearly" },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedCard == "Yearly") LightGreen else Color.LightGray
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 5.dp, bottom = 5.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        fontSize = 12.sp,
                                        text = "Yearly",
                                        textAlign = TextAlign.Center,
                                        color = Color.Black,
                                        fontFamily = FontFamily.SansSerif,
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Card(
                                shape = RoundedCornerShape(15.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 2.dp, bottom = 2.dp)
                                    .clickable { selectedCard = "Monthly" },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedCard == "Monthly") LightGreen else Color.LightGray
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 5.dp, bottom = 5.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        fontSize = 12.sp,
                                        text = "Monthly",
                                        textAlign = TextAlign.Center,
                                        color = Color.Black,
                                        fontFamily = FontFamily.SansSerif,
                                        style = MaterialTheme.typography.labelLarge

                                    )
                                }
                            }
                        }
                    }
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {

                Card(
                    shape = RoundedCornerShape(15.dp), modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                    ,
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 24.dp)
                ) {
                    Box(modifier = Modifier) {
                        Column (){
                            Text(
                                fontSize = 22.sp,
                                text = "Plus",
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 8.dp)
                                    .wrapContentHeight()
                            )

                            Text(
                                text = "Powerful tools to the way your team", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)
                            )



                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(VeryLightGreen)
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "$ ", color = Color.Gray,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(start = 7.dp)
                                )
                                Text(
                                    text = "55", color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = " Per month", color = Color.Gray,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 12.sp
                                )
                            }
                            Text(
                                text = "• Private Slide", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)

                            )
                            Text(
                                text = "• Access manage", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)

                            )

                            Text(
                                text = "• Private mode", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp, end = 20.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                        }

                    }
                }
                Card(
                    shape = RoundedCornerShape(15.dp), modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(modifier = Modifier) {
                        Column() {
                            Text(
                                fontSize = 22.sp,
                                text = "Pro",
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 8.dp)
                                    .wrapContentHeight()
                            )

                            Text(
                                text = "Powerful tools to the way your team", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)
                            )


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(VeryLightGreen)
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "$ ", color = Color.Gray,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 12.sp,
                                    modifier = Modifier.padding(start = 7.dp)
                                )
                                Text(
                                    text = "80", color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = " Per month", color = Color.Gray,
                                    fontFamily = FontFamily.SansSerif,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.End
                                )
                            }
                            Text(
                                text = "• Private Slide", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)
                            )
                            Text(
                                text = "• Access manage", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp)
                            )
                            Text(
                                text = "• Private mode", color = Color.Black,
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 15.dp, top = 8.dp,end = 20.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                        }

                    }

                }
            }

//            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .padding(top = 20.dp, start = 8.dp, end = 8.dp, bottom = 2.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors( LightBlue// Set background color to navy blue
                )
            ) {
                Text(text = "Continue",
                    color = Color.Black
                )
            }

            Text(text = "Cancel",
                color = Color.Gray,
                fontSize = 15.sp
                , modifier = Modifier.padding(10.dp))

        }
    }
}


@Preview(showBackground = true,showSystemUi = true, device = "spec:parent=pixel_5,orientation=portrait")
@Composable
fun GreetingPreview() {
    Profile1()
}