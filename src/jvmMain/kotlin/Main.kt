// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.MainUI

fun main() = application { showWindow() }

@Composable
fun ApplicationScope.showWindow() {
    Window(onCloseRequest = ::exitApplication, title = "Algorithm platform") {
        val scope = rememberCoroutineScope()
        MainUI().create(scope)
    }
}