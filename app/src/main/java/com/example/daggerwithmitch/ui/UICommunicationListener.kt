package com.example.daggerwithmitch.ui

interface UICommunicationListener {
    fun onUIMessageReceived(uiMessage: UIMessage)
}