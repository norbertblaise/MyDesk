package com.my.desk.util

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.my.desk.domain.model.User

public class FirebaseUtil {
    val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    public fun openFbReference(ref: String) {
        mAuthStateListener = FirebaseAuth.AuthStateListener {

        }
    }

    public fun createFirebaseUser(user: User, password: String) {
        val email = user.email
        if (mAuth.currentUser == null) {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = mAuth.uid.toString()

                        user.userId = userId

                        Log.d(TAG, "createFirebaseUser: success")

                        mFirestore.collection(USERS).document(userId).set(user)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    //go to home
                                }
                            }
                    } else {
                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                        Toast.makeText(, "Authentication failed.",
//                            Toast.LENGTH_SHORT).show()
//                       / updateUI(null)
                    }
                }
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
