package com.fundox.fundbox.presentation.navGraph

sealed class Routes(val route: String) {
    object AuthScreen : Routes("authScreen")
    object Home : Routes("home")
    object HomeScreen : Routes("homeScreen")
    object DonationList : Routes("donationList")
    object MyDonations : Routes("myDonations")
    object Account : Routes("account")
}