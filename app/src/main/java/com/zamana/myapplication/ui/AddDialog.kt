package com.zamana.myapplication.ui

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.zamana.myapplication.R
import com.zamana.myapplication.databinding.DialogAddBinding

class AddDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = DialogAddBinding.inflate(layoutInflater)
        return AlertDialog.Builder(requireContext())
            .setView(view.root)
            .setTitle(R.string.dialog_title)
            .setCancelable(true)
            .setPositiveButton(
                R.string.dialog_ok_button
            ) { dialog, _ ->
                view.textFromDialog.text
            }

            .setNeutralButton(R.string.dialog_dont_ok_button) { _, _ ->
            }
            .setMessage(R.string.dialog_message)

            .setNegativeButton(R.string.dialog_close_button) { _, _ ->
            }
            .create()
    }
}