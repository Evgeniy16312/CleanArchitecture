package com.example.cleanarchitecture.presentation.main

interface MainEvent

class SaveEvent(val text: String) : MainEvent

class LoadEvent : MainEvent