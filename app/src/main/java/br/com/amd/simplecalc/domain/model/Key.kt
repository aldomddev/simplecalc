package br.com.amd.simplecalc.domain.model

data class Key(
    val label: String,
    val keyType: KeyType = KeyType.Value("")
)
