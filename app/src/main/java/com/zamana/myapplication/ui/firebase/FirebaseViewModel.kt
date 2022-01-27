package com.zamana.myapplication.ui.firebase

import androidx.lifecycle.ViewModel
import com.zamana.myapplication.reposytory.FirebaseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class FirebaseViewModel(
    private val repository: FirebaseRepository
) : ViewModel() {

    lateinit var toast: (isSuc: Boolean) -> Unit
    var disposable: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    fun login(email: String, pass: String) {
        disposable = repository.login(email, pass)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                toast(true)
            }, {
                toast(false)
            })
    }
}