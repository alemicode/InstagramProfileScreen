package com.alemicode.ui_toolkit.util

sealed interface TextType {
    data class TypeBody(val text: String) : TextType
    data class TypeBold(val text: String) : TextType
}