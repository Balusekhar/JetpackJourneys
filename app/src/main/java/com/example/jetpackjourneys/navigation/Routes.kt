package com.example.jetpackjourneys.navigation

sealed class Routes(val route:String) {

        object Login:Routes("login")
        object Signup:Routes("signup")

        object BlogList:Routes("blog_list")
        object AddBlog:Routes("add_blog")
        object FavouriteBlogs:Routes("favourite_blogs")
        object AboutSection:Routes("about_section")

        object AuthGraph:Routes("auth_graph")
        object HomeGraph:Routes("home_graph")

}