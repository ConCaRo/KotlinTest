package testco.kotlin.ui.exception

import testco.kotlin.data.exception.DataException
import testco.kotlin.data.exception.DatabaseException
import testco.kotlin.data.exception.NetworkException
import testco.kotlin.data.exception.OthersException
import javax.inject.Inject

/**
 * Created by Concaro on 8/17/2017.
 */
class ErrorMessageFactory @Inject constructor() {

    fun getErrorMessage(e: Throwable): String {
        var errorMessage = ""
        if (e is NetworkException) {
            errorMessage = "NetworkException " + e.message
        } else if (e is DataException) {
            errorMessage = "DataException " + e.message
        } else if (e is DatabaseException) {
            errorMessage = "DatabaseException " + e.message
        } else if (e is OthersException) {
            errorMessage = "OthersException " + e.message
        }
        return errorMessage
    }
}