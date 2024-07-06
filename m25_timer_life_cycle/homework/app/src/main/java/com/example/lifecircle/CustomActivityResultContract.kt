package com.example.lifecircle

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.content.IntentCompat


class CustomActivityResultContract : ActivityResultContract<Boolean, PersonInfo?>() {

    companion object {
        const val CHECKBOX_STATUS = "CHECKBOX_STATUS"
        const val PERSON_INFO = "PERSON_INFO"

    }

    override fun createIntent(context: Context, input: Boolean): Intent {
        return Intent(context, MainActivity2::class.java).apply {
            putExtra(CHECKBOX_STATUS, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): PersonInfo? {
        return if (resultCode == Activity.RESULT_OK && intent != null)
            IntentCompat.getParcelableExtra(intent, PERSON_INFO, PersonInfo::class.java)
        else null
    }


}
