package org.example.project.presentation.black

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.multiplatform.webview.setting.WebSettings
import com.multiplatform.webview.web.WebContent
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewState
import com.multiplatform.webview.web.rememberWebViewNavigator
import org.example.project.ServiceLocator
import org.example.project.logic_cloaca.StaticVariables

object ScreenBlack: Screen {

    @Composable()
    override fun Content(){
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            //ServiceLocator.webView.showWebView("https://qazantip.site/")
            val navigator = rememberWebViewNavigator()

            WebView(modifier = Modifier.fillMaxSize(),
                navigator = navigator,
                state = WebViewState(webContent =  WebContent.Url(StaticVariables.urlFinal)),

            ){
                ServiceLocator.webView.configureWebSettings()
            }
            StaticVariables.goBack = {navigator.navigateBack()}
            }

        }
    }
