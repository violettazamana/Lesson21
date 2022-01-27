package com.zamana.myapplication.reposytory

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class FirebaseRepository {

    private var auth = FirebaseAuth.getInstance()

    fun login(email: String, pass: String): Observable<FirebaseUser> {
        return BehaviorSubject.create<FirebaseUser>().apply {
            auth.signInWithEmailAndPassword(
                email, pass
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.let { onNext(it) }
                    onComplete()
                } else {
                    onError(Exception(task.exception))
                }
            }
        }.subscribeOn(Schedulers.io())
    }
}