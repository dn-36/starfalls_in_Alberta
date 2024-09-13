package org.example.project.core

interface KeyValueStorage {
    suspend fun saveString(key: String, value: String)
    suspend fun getString(key: String): String?
}

