package org.example.project

import platform.UIKit.UIDocumentPickerMode
import platform.UIKit.UIDocumentPickerViewController
import platform.UIKit.UIViewController
import platform.Foundation.NSArray
import platform.UIKit.*

class IOSFileProvider(private val viewController: UIViewController):FileProvider {

    override suspend fun requestPermissionAndOpenFile() {
        // В iOS не требуется запрашивать разрешение на доступ к документам
        openFilePicker()
    }

    private fun openFilePicker() {
        // Список типов документов (например, все типы файлов или только определённые форматы)
        val documentTypes = listOf("public.data") // Указываем MIME-тип для файлов

        // Создаём документ-пикер с правильным mode
        val documentPicker = UIDocumentPickerViewController(
            documentTypes = documentTypes as List<String>,
            inMode = UIDocumentPickerMode.UIDocumentPickerModeImport // Правильный mode для импорта файлов
        )

        // Отображаем контроллер для выбора файлов
        viewController.presentViewController(documentPicker, animated = true, completion = null)
    }
}