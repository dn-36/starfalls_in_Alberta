package org.example.project


import kotlinx.cinterop.*
import platform.Contacts.*
import platform.Foundation.NSError
import platform.Foundation.NSLog


class IOSContactProvider : ContactProvider {
    override fun getAllContacts(): List<Contact> {
        val contactList = mutableListOf<Contact>()
        val contactStore = CNContactStore()

        // Проверка статуса доступа к контактам
        val authorizationStatus = CNContactStore.authorizationStatusForEntityType(CNEntityType.CNEntityTypeContacts)

        if (authorizationStatus == CNAuthorizationStatusNotDetermined) {
            // Если статус не определён, запрашиваем разрешение
            contactStore.requestAccessForEntityType(CNEntityType.CNEntityTypeContacts) { granted, error ->
                if (granted) {
                    // Если разрешение предоставлено, запрашиваем контакты
                    fetchContacts(contactStore, contactList)
                } else {
                    NSLog("Access to contacts was denied.")
                }
            }
        } else if (authorizationStatus == CNAuthorizationStatusAuthorized) {
            // Если разрешение уже есть, запрашиваем контакты
            fetchContacts(contactStore, contactList)
        } else {
            NSLog("Access to contacts is restricted or denied.")
        }

        return contactList
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun fetchContacts(contactStore: CNContactStore, contactList: MutableList<Contact>) {
        val keysToFetch = listOf(
            CNContactFormatter.descriptorForRequiredKeysForStyle(CNContactFormatterStyle.CNContactFormatterStyleFullName),
            CNContactPhoneNumbersKey
        )

        val fetchRequest = CNContactFetchRequest(keysToFetch)

        memScoped {
            val errorPtr = alloc<ObjCObjectVar<NSError?>>()

            val success = contactStore.enumerateContactsWithFetchRequest(fetchRequest, errorPtr.ptr) { cnContact, _ ->
                cnContact?.let {
                    val name = CNContactFormatter.stringFromContact(it,
                        CNContactFormatterStyle.CNContactFormatterStyleFullName
                    ) ?: "No Name"

                    // Получение номеров телефона без использования приведения через value
                    val phoneNumbers = it.phoneNumbers.mapNotNull { labeledValue ->
                        (labeledValue as? CNLabeledValue)?.let { labeled ->
                            labeled.value as? CNPhoneNumber
                        }?.stringValue
                    }

                    if (phoneNumbers.isNotEmpty()) {
                        val contact = Contact(
                            id = it.identifier,
                            name = name,
                            phoneNumber = phoneNumbers.joinToString(", ")
                        )
                        contactList.add(contact)
                    }
                }
            }

            val error = errorPtr.value
            if (error != null) {
                NSLog("Error fetching contacts: ${error.localizedDescription}")
            } else if (!success) {
                NSLog("Failed to enumerate contacts for an unknown reason")
            }
        }
    }
}