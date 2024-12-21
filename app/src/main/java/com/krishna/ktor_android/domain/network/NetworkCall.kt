package com.krishna.ktor_android.domain.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

fun createHttpClient(): HttpClient {


    return HttpClient(CIO)
}