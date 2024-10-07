package org.example.project

import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts




 fun initializeContactProvider() {
    class AndroidContactProvider : ContactProvider {
        override fun getAllContacts(): List<Contact> {
            val contactList = mutableMapOf<String, Contact>()  // Используем Map для уникальных контактов
            val contentResolver = MainActivity.context.contentResolver
            val cursor = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID,  // Используем CONTACT_ID для уникальности
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null,
                null,
                null
            )

            cursor?.use {
                val contactIdIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
                val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                while (cursor.moveToNext()) {
                    val contactId = cursor.getString(contactIdIndex)
                    val name = cursor.getString(nameIndex)
                    val number = cursor.getString(numberIndex)

                    // Проверяем, существует ли уже контакт с таким же ID
                    if (contactList.containsKey(contactId)) {
                        // Если существует, обновляем его (например, добавляем новый номер)
                        val existingContact = contactList[contactId]
                        existingContact?.let {
                            // Добавляем новый номер (можно здесь реализовать логику объединения)
                            it.phoneNumber = "${it.phoneNumber}, $number"  // Пример объединения номеров
                        }
                    } else {
                        // Если контакта нет, добавляем новый
                        contactList[contactId] = Contact(contactId, name, number)
                    }
                }
            }

            return contactList.values.toList()  // Преобразуем Map в List
        }
    }

    ServiceLocator.contacts = AndroidContactProvider()
}

