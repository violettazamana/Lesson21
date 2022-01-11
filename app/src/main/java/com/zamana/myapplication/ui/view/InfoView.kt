package com.zamana.myapplication.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.zamana.myapplication.R
import com.zamana.myapplication.databinding.ViewInfoBinding

class InfoView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    lateinit var binding: ViewInfoBinding

    var onClickInfo: (() -> Unit)? = null

    init {
        binding = ViewInfoBinding.inflate(
            LayoutInflater.from(context), this
        )
        attrs?.let { setAttributes(it) }
        binding.info.setOnClickListener {
            onClickInfo?.invoke()
        }
    }

    private fun setAttributes(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.InfoView, 0, 0)
        try {
            binding.title.text = ta.getString(R.styleable.InfoView_title)
            binding.info.text = ta.getString(R.styleable.InfoView_buttonTitle)
            binding.message.text = ta.getString(
                R.styleable.InfoView_message
            )
        } finally {
            ta.recycle()
        }
    }
}