package com.kirchhoff.composeexamples.bottomnavigation

import com.kirchhoff.composeexamples.R

sealed class BottomNavigationBarItem(
    val route: String,
    val icon: Int,
    val title: String
) {
    object Home : BottomNavigationBarItem("home", R.drawable.ic_home, "Home")
    object Music : BottomNavigationBarItem("music", R.drawable.ic_music, "Music")
    object Movies : BottomNavigationBarItem("movies", R.drawable.ic_movie, "Movies")
    object Books : BottomNavigationBarItem("books", R.drawable.ic_book, "Books")
    object Profile : BottomNavigationBarItem("profile", R.drawable.ic_profile, "Profile")
}