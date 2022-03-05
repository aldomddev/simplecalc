package br.com.amd.simplecalc.domain

interface CalcProcessor {
    fun processKey(key: String): String
}