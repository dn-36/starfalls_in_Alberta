package org.example.project

import org.example.project.core.KeyValueStorage
import org.example.project.core.PhotoSender
import org.example.project.core.WebViewProvider

object ServiceLocator {
    lateinit var photoSender: PhotoSender
    lateinit var key: KeyValueStorage
    lateinit var webView: WebViewProvider
}