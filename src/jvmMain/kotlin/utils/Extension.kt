package utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Extension {

    fun CoroutineScope.runScope(block: suspend () -> Unit) = launch(Dispatchers.IO) {
        block.invoke()
    }
}