package br.com.amd.simplecalc.domain.calc_processor

interface CalcProcessor {
    fun processKey(key: String): String
}