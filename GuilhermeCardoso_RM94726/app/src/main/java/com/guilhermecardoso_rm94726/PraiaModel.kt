package com.guilhermecardoso_rm94726

class PraiaModel (
    val nomePraia: String,
    val cidade: String,
    val estado: String,
    val onRemove: (PraiaModel) -> Unit
)
