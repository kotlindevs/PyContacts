package com.piyush.pycontacts

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PyContacts",
    ) {
        App()
    }
}