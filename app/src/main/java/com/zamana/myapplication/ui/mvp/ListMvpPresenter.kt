package com.zamana.myapplication.ui.mvp

import com.arellomobile.mvp.MvpPresenter

class ListMvpPresenter : MvpPresenter<ListMvpViewState>() {

    fun login() {
        // send data to server
        viewState.showToast()
    }
}