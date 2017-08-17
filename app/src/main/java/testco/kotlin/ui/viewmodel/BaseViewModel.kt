package testco.kotlin.ui.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.util.Log
import android.widget.Toast
import testco.kotlin.ui.exception.ErrorMessageFactory
import javax.inject.Inject

/**
 * Created by Concaro on 8/17/2017.
 */
abstract class BaseViewModel(var context: Context) : BaseObservable() {

    lateinit @Inject var errorMessageFactory: ErrorMessageFactory

    fun showErrorMessage(e: Throwable) {
        Toast.makeText(context, errorMessageFactory.getErrorMessage(e), Toast.LENGTH_LONG).show()

        Log.d("ErrorMessage", e.printStackTrace().toString())
    }

    abstract fun onActivityCreated()

    abstract fun onActivityResume()

    abstract fun onActivityDestroy()
}