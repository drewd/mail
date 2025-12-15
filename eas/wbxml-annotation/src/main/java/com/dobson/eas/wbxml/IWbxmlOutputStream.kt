package com.dobson.eas.wbxml

import java.io.IOException

interface IWbxmlOutputStream {
    @Throws(IOException::class)
    fun open(namespace: com.dobson.eas.wbxml.annotation.Namespace, token: Int, block: (IWbxmlOutputStream.() -> Unit)? = null)

    @Throws(IOException::class)
    fun write(b: Int)

    @Throws(IOException::class)
    fun write(value: ByteArray)
}