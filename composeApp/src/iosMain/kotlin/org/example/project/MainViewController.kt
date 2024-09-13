package org.example.project

import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.window.ComposeUIViewController
import com.project.astranomapp.data.StaticDate

fun MainViewController() = ComposeUIViewController {

    val viewController = LocalUIViewController.current
    ServiceLocator.photoSender = IosPhotoSender()
    ServiceLocator.key = KeyValueStorageImpl()
    ServiceLocator.webView = WebSettingsManager()

    App()
}