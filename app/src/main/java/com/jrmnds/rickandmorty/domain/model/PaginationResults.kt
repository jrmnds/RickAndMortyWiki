package com.jrmnds.rickandmorty.domain.model

data class PaginationResults(
    val info: PaginationInfo?,
    val results: List<Character>?
)