package testco.kotlin.data.exception

/**
 * Created by Concaro on 8/17/2017.
 * Exceptions: MalformedJsonException, MalformedInputException, MalformedURLException
 */
class DataException : Exception {

    constructor() : super()

    constructor(cause: Throwable) : super(cause)
}