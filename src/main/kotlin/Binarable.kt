package ru.kdk

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
/*
open class Binarable<T> : IWritable {
    override fun toByteArray(): ByteArray? {
        return try {
            Json.encodeToString(serializer(),this).encodeToByteArray()
        } catch (ex: Exception) {
            //errorHandler?.invoke(ex)
            null
        }
    }

    companion object: IReadable {
        override fun fromByteArray(byteArray: ByteArray): T? {
            return try {
                Json.decodeFromString<DataClass>(byteArray.decodeToString())
            } catch (ex: Exception) {
                //errorHandler?.invoke(ex)
                null
            }
        }
    }
}
 */