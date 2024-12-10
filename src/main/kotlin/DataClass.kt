package ru.kdk

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class DataClass(
    val name: String,
    val parameters: Array<Int>,
    val blob: ByteArray
) : IWritable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataClass

        if (name != other.name) return false
        if (!parameters.contentEquals(other.parameters)) return false
        if (!blob.contentEquals(other.blob)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + parameters.contentHashCode()
        result = 31 * result + blob.contentHashCode()
        return result
    }

    override fun toByteArray(): ByteArray? {
        return try {
            Json.encodeToString(serializer(),this).encodeToByteArray()
        } catch (ex: Exception) {
            //errorHandler?.invoke(ex)
            null
        }
    }

    companion object: IReadable<DataClass> {
        override fun fromByteArray(byteArray: ByteArray): DataClass? {
            return try {
                Json.decodeFromString<DataClass>(byteArray.decodeToString())
            } catch (ex: Exception) {
                //errorHandler?.invoke(ex)
                null
            }
        }
    }
}