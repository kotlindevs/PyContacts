package com.piyush.pycontacts

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform