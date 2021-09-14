package dev.ujon.kotlinspringbootjpaquerydsl.common.config

object StatusCode {
    // 200
    const val SUCCESS: Int = 2000

    // 400
    const val BAD_REQUEST: Int = 4000
    const val EMAIL_IS_NOT_EXIST = 4001
    const val UNSUPPORTED_MEDIA_TYPE: Int = 4150

    // 500
    const val UNKNOWN: Int = 9999
}