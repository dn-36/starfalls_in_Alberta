package org.example.project

import com.russhwolf.settings.Settings
import org.example.project.core.KeyValueStorage
import platform.Foundation.NSUserDefaults

 class KeyValueStorageImpl : KeyValueStorage {

    private val userDefaults = NSUserDefaults.standardUserDefaults

    override suspend fun saveString(key: String, value: String) {
        userDefaults.setObject(value, forKey = key)
    }

    override suspend fun getString(key: String): String? {
        return userDefaults.stringForKey(key)
    }
}