package com.jrmnds.rickandmorty.domain.model

data class PaginationInfo(
    val count: Int,
    val page: Int,
    val next: String,
    val prev: String
)
