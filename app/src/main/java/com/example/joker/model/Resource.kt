package com.example.joker.model

import androidx.annotation.Nullable


class Resource<T> private constructor(val status: Status,  val data: T, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, @Nullable data: T?): Resource<T?> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T?): Resource<T?> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> loading(): Resource<T?> {
            return loading(null)
        }

        fun <T> error(message: String?): Resource<T?> {
            return error(message, null)
        }
    }

}
