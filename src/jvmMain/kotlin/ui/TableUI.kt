package ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.Data

class TableUI {

    var bubbleSortValues by mutableStateOf(listOf(0F, 0F, 0F, 0F, 0F, 0F, 1728.348F))
    var quickSortValues by mutableStateOf(listOf(0F, 0F, 0F, 0F, 0F, 0F, 0F))
    var mergeSortValues by mutableStateOf(listOf(0F, 0F, 0F, 0F, 0F, 0F, 0F))

    @Composable
    fun create() {
        Column(
            modifier = Modifier.fillMaxWidth().padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TableHeader()

            AlgorithmRow(algorithm = "Bubble Sort", results = bubbleSortValues)
            AlgorithmRow(algorithm = "Quick Sort", results = quickSortValues)
            AlgorithmRow(algorithm = "Merge Sort", results = mergeSortValues)
        }
    }

    @Composable
    fun TableHeader() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Algorithm",
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1F)
            )

            repeat(times = Data.values().size) { value ->
                Text(
                    text = Data.values()[value].value.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1F).wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }

    @Composable
    fun AlgorithmRow(algorithm: String, results: List<Float>) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(algorithm, fontSize = 14.sp, modifier = Modifier.weight(1F))

            results.forEach { value ->
                Text(
                    text = value.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1F)
                        .padding(PaddingValues(horizontal = 4.dp))
                        .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(4.dp))
                        .padding(8.dp)
                )
            }
        }
    }

}