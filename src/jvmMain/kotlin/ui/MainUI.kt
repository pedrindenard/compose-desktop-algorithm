package ui

import algorithm.BubbleSort
import algorithm.MergeSort
import algorithm.QuickSort
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import models.ClickListener
import models.Data
import models.Sort
import utils.File
import kotlin.system.measureTimeMillis

class MainUI {

    @Composable
    fun create(scope: CoroutineScope) {
        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val loading = LoadingUI()
                val table = TableUI()
                val menu = MenuUI()

                table.create()

                menu.create(scope)
                menu.setListener(scope, loading, table)

                loading.create()
            }
        }
    }

    private fun MenuUI.setListener(scope: CoroutineScope, loading: LoadingUI, table: TableUI) {
        setClickListener(object : ClickListener {
            override fun runBubbleSort() {
                scope.launch(Dispatchers.IO) {
                    table.bubbleSortValues = loading.execute(Sort.BUBBLE_SORT)
                }
            }

            override fun runQuickSort() {
                scope.launch(Dispatchers.IO) {
                    table.quickSortValues = loading.execute(Sort.QUICK_SORT)
                }
            }

            override fun runMergeSort() {
                scope.launch(Dispatchers.IO) {
                    table.mergeSortValues = loading.execute(Sort.MERGE_SORT)
                }
            }
        })
    }

    private suspend fun LoadingUI.execute(sort: Sort): ArrayList<Float> {
        val values = arrayListOf<Float>()

        isLoading = true

        Data.values().forEach { ordinal ->

            val measureTimeMillis = withContext(Dispatchers.Default) {

                measureTimeMillis {
                    when (sort) {
                        Sort.BUBBLE_SORT -> BubbleSort.start(File.getFileAsset(ordinal))
                        Sort.QUICK_SORT -> QuickSort.start(File.getFileAsset(ordinal))
                        Sort.MERGE_SORT -> MergeSort.start(File.getFileAsset(ordinal))
                    }
                }

            }

            val resultInSeconds = measureTimeMillis.toFloat() / 1000F
            values.add(resultInSeconds)
        }

        isLoading = false

        return values
    }

}