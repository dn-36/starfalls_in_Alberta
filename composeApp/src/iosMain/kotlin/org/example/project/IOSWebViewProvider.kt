package org.example.project

import kotlinx.cinterop.ExperimentalForeignApi
import org.example.project.core.WebViewProvider
import platform.CoreGraphics.CGRectMake
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.UIKit.UIViewController
import platform.WebKit.WKNavigation
import platform.WebKit.WKNavigationDelegateProtocol
import platform.WebKit.WKWebView
import platform.WebKit.WKWebViewConfiguration
import platform.WebKit.javaScriptEnabled
import platform.darwin.NSObject

 class WebSettingsManager:WebViewProvider {
    override fun configureWebSettings() {
        // Here you would configure your iOS-specific settings
        val webView = WKWebView()
        webView.configuration.preferences.javaScriptEnabled = true
        webView.configuration.preferences.javaScriptCanOpenWindowsAutomatically = true
        webView.configuration.preferences.fraudulentWebsiteWarningEnabled = false
        webView.configuration.preferences.siteSpecificQuirksModeEnabled = true
    }
}