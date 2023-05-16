package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import models.ClickListener
import utils.Extension.runScope

class MenuUI {

    private lateinit var menuClickListener: ClickListener

    @Composable
    fun create(scope: CoroutineScope) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(text = "Bubble Sort") {
                scope.runScope {
                    menuClickListener.runBubbleSort()
                }
            }
            Button(text = "Quick Sort") {
                scope.runScope {
                    menuClickListener.runQuickSort()
                }
            }
            Button(text = "Merge Sort") {
                scope.runScope {
                    menuClickListener.runMergeSort()
                }
            }
        }
    }

    @Composable
    private fun Button(text: String, onClick: () -> Unit) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    PaddingValues(
                        horizontal = 32.dp,
                        vertical = 16.dp
                    )
                ),
            onClick = {
                onClick()
            }
        ) {
            Text(
                text = text
            )
        }
    }

    fun setClickListener(listener: ClickListener) {
        menuClickListener = listener
    }
}