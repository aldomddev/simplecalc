package br.com.amd.simplecalc.ui.model

import br.com.amd.simplecalc.domain.model.Key
import br.com.amd.simplecalc.domain.model.KeyType

data class KeyVO(
    val label: String,
    val keyType: KeyType = KeyType.Value("")
)

fun KeyVO.toKeyDomain() = Key(label = label, keyType = keyType)