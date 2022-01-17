package com.zamana.myapplication.ui.mvp

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenterTag
import com.zamana.myapplication.databinding.ActivityListMvpBinding

class ListMvpActivity : MvpActivity(), ListMvpViewState {

    @InjectPresenter
    lateinit var presenter: ListMvpPresenter

    @ProvidePresenterTag(presenterClass = ListMvpPresenter::class, type = PresenterType.GLOBAL)
    fun providemPresenter() = ListMvpPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.showToastButton.setOnClickListener {
            presenter?.login()
        }
    }

    override fun showToast() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
    }
}