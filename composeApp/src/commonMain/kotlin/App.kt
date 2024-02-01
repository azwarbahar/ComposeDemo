import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    val playerList = listOf(
        PlayerGoatData(
            name = "Leo Messi",
            image = "messi.png"
        ),
        PlayerGoatData(
            name = "C. Ronaldo",
            image = "ronaldo.png"
        ),
        PlayerGoatData(
            name = "Mo Salah",
            image = "salah.png"
        ),
        PlayerGoatData(
            name = "Harry Maguire",
            image = "maguire.png"
        ),
        PlayerGoatData(
            name = "Andre Onana",
            image = "onana.png"
        ),
        PlayerGoatData(
            name = "Alejandro Garnacho",
            image = "garnacho.png"
        ),
        PlayerGoatData(
            name = "Ousmane Dembele",
            image = "dembele.png"
        ),
        PlayerGoatData(
            name = "Egy Maulana Vikri",
            image = "egy.png"
        ),
        PlayerGoatData(
            name = "Witan Sulaeman",
            image = "witan.png"
        ),
        PlayerGoatData(
            name = "Hokky Caraka",
            image = "caraka.png"
        ),
        PlayerGoatData(
            name = "Oktovianus Maniani",
            image = "okto.png"
        )
    )
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
            Text(
                "List Best Footbal Player", modifier = Modifier.padding(24.dp),
                fontSize = 24.sp,
                textAlign = Center
            )
            GridWithCards(playerList)
        }
    }
}

@Composable
fun GridWithCards(playerList: List<PlayerGoatData>) {
    LazyVerticalGrid(
        columns = Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = spacedBy(8.dp),
        verticalArrangement = spacedBy(8.dp)
    ) { items(playerList) { ItemPlayerCard(it) } }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ItemPlayerCard(player: PlayerGoatData) {
    Card(modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(8.dp))) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .background(brush = Brush.verticalGradient(colors = listOf(Black, Black)))
        ) {
            Image(
                painter = painterResource(player.image),
                contentDescription = null,
                contentScale = Crop,
                alignment = TopCenter,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Black.copy(alpha = 0.7f))
                    .align(BottomCenter)
            ) {
                Text(
                    text = player.name,
                    color = White,
                    fontSize = 16.sp,
                    textAlign = Center,
                    modifier = Modifier.fillMaxWidth().padding(12.dp)
                )
            }
        }
    }
}

data class PlayerGoatData(
    val name: String,
    val image: String
)