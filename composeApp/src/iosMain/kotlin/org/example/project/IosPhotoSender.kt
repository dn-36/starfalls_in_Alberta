package org.example.project

import org.example.project.core.PhotoSender
import platform.Foundation.NSURL
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication

class IosPhotoSender: PhotoSender {

        override fun sendPhoto(photoPath: String) {
            val url = NSURL.fileURLWithPath(photoPath)
            val activityViewController = UIActivityViewController(activityItems = listOf(url), applicationActivities = null)

            val controller = UIApplication.sharedApplication.keyWindow?.rootViewController
            controller?.presentViewController(activityViewController, animated = true, completion = null)
        }
}