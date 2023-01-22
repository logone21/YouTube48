package com.example.youtube.data.remote.remote.model

import android.text.style.LeadingMarginSpan


data class PlayList(
    val items: ArrayList<Item>,
    val kind: String?,
    )
data class ContentDetails(
    val itemCount: Int
)
data class Default(
    val height: Int,
    val url: String,
    val width: Int
)
data class High(
    val height: Int,
    val url: String,
    val width: Int
)
data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)
data class Localized(
    val description: String,
    val title: String
)
data class Maxres(
    val height: Int,
    val url: String,
    val width: Int
)
data class Medium(
    val height: Int,
    val url: String,
    val width: Int
)
data class PageInfo(
    val resultsPerPage: Int,
    val totalResults: Int
)
data class PlayLists(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)
data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val localized: Localized,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)
data class Thumbnails(
    val default: Default,
    val high: High,
    val maxres: Maxres,
    val medium: Medium,
    val standard: LeadingMarginSpan.Standard
)

