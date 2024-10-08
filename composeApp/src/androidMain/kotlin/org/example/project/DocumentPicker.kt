package org.example.project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/*class AndroidFileProvider(private val pickFileLauncher: ActivityResultLauncher<String>) : FileProvider {

    private var filePickedContinuation: (Uri?) -> Unit = {}

    override suspend fun pickFile(): FileData {
        return suspendCancellableCoroutine { continuation ->
            filePickedContinuation = { uri ->
                if (uri != null) {
                    val name = getFileName(uri)
                    val mimeType = getMimeType(uri)

                    val fileData = FileData(
                        uri = uri.toString(),
                        name = name ?: "Unknown",
                        mimeType = mimeType ?: "application/octet-stream"
                    )
                    continuation.resume(fileData)
                } else {
                    continuation.resumeWithException(IllegalStateException("No file selected"))
                }
            }
            selectFile()
        }
    }

    // Обработчик результата выбора файла
    fun handleFilePickResult(uri: Uri?) {
        filePickedContinuation(uri)
    }

    // Запуск процесса выбора файла
    private fun selectFile() {
     /*   pickFileLauncher.launch("*/*") // Тип файлов: любой
    }

    // Получение имени файла через ContentResolver
    private fun getFileName(uri: Uri): String? {
        var name: String? = null
        val cursor = (pickFileLauncher as Activity).contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (index >= 0) {
                    name = it.getString(index)
                }
            }
        }
        return name
    }

    // Получение MIME-типа файла
    private fun getMimeType(uri: Uri): String? {
        return (pickFileLauncher as Activity).contentResolver.getType(uri)
    }
}
       */