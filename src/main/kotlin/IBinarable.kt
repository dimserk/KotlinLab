package ru.kdk

interface IReadable<T> {
    fun fromByteArray(byteArray: ByteArray): T?
}

interface IWritable {
    fun toByteArray(): ByteArray?
}