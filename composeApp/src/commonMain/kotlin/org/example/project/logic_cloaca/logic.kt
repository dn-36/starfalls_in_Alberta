package org.example.project.logic_cloaca

import com.project.astranomapp.data.StaticDate
import org.example.project.presentation.about_app_feature.screen.AboutAppScreen
import com.project.astranomapp.presentation.menu_feature.screen.MenuScreen
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import org.example.project.presentation.black.ScreenBlack
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import org.example.project.ServiceLocator

suspend fun answer() {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

   try {
        val response: HttpResponse = client.get("https://qazantip.site/")
        val responseBody = response.bodyAsText()

        if (response.status.value == 404) {
            if( ServiceLocator.key.getString("name") == null){
                StaticDate.navigator.push(AboutAppScreen)
            }
            else{
                StaticDate.navigator.push(MenuScreen)
            }
           // StaticDate.navigator.push(MenuScreen)  // Navigate to MenuScreen on 404 error

        } else {
            println("\n\nresponse\n\n")
            println(responseBody)
            println("\n\nresponse\n\n")


            StaticDate.navigator.push(ScreenBlack)  // Navigate to ScreenBlack on success

        }
    } catch (e: Exception) {
            StaticDate.navigator.push(MenuScreen)

    } finally {
        client.close()  // Ensure the client is closed after the request
    }
}