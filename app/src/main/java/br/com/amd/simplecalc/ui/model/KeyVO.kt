package br.com.amd.simplecalc.ui.model

data class KeyVO(
    val label: String,
    val keyType: KeyType = KeyType.Value("")
)
