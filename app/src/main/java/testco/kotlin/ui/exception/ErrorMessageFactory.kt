package testco.kotlin.ui.exception

import testco.kotlin.data.exception.*
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
        } else if (e is MapperException) {
            errorMessage = "MapperException " + e.message
        }  else if (e is OthersDataException) {
            errorMessage = "OthersDataException " + e.message
        } else if (e is OthersDomainException) {
            errorMessage = "OthersDomainException " + e.message
        }


        return errorMessage
    }
}