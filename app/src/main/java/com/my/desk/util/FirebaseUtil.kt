package com.my.desk.util

import com.google.firebase.auth.FirebaseAuth

public class FirebaseUtil {
    public fun openFbReference(ref: String) {
        mAuthStateListener = FirebaseAuth.AuthStateListener {

        }
    }

    fun attachListener() {
        mAuth.addAuthStateListener(mAuthStateListener)
    }


    fun authResult(): Boolean {
        if (mAuth.currentUser != null) {
            return true
        } else {
            return false
        }
    }


    fun attachAuthListener() {


    }

    fun detachAuthListener() {
    }

    companion object {
        private const val TAG = "FirebaseUtil"
        private const val USERS = "Users"
        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
        lateinit var mAuthStateListener: FirebaseAuth.AuthStateListener
    }
}
