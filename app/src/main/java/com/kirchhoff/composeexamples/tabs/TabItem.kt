package com.kirchhoff.composeexamples.tabs

import androidx.compose.runtime.Composable
import com.kirchhoff.composeexamples.R
import com.kirchhoff.composeexamples.tabs.screens.BooksScreen
import com.kirchhoff.composeexamples.tabs.screens.MoviesScreen
import com.kirchhoff.composeexamples.tabs.screens.MusicScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val icon: Int,
    val title: String,
    val screen: ComposableFun
) {
    object Music : TabItem(R.drawable.ic_music, "Music", { MusicScreen() })
    object Movies : TabItem(R.drawable.ic_movie, "Movies", { MoviesScreen() })
    object Books : TabItem(R.drawable.ic_book, "Books", { BooksScreen() })
}