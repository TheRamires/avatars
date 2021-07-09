package ru.axas.avatars.handlers

import javax.inject.Inject

class HandleOnceTester @Inject constructor() {
    private var lastMessage: String = ""

    fun itWasNotHandled(message: String): Boolean {
        return if (lastMessage != message) {
            lastMessage=message
            true
        } else false
    }
    fun clear(){
        lastMessage=""
    }
}

open class HandleOnce<out T>(private val content: T) {

    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}