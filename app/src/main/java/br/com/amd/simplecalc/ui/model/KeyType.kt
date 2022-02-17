package br.com.amd.simplecalc.ui.model

sealed class KeyType {
    data class Value(val value: String) : KeyType()
    data class Operation(val operation: KeyOperation) : KeyType()
}