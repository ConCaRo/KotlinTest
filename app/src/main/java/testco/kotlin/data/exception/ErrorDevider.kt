package testco.kotlin.data.exception

import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import java.net.MalformedURLException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.nio.charset.MalformedInputException

/**
 * Created by Concaro on 8/17/2017.
 */
class ErrorDevider {

    companion object {

        fun devide(t: Throwable): Throwable {
            if (t is MalformedJsonException || t is MalformedInputException
                    || t is MalformedURLException || t is NumberFormatException
                    || t is JsonSyntaxException) {
                return DataException(t)
            } else if (t is SocketException || t is SocketTimeoutException) {
                return NetworkException(t)
            }
            return OthersException(t)
        }
    }
}