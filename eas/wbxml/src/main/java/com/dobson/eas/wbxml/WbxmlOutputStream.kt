package com.dobson.eas.wbxml

import java.io.IOException
import java.io.OutputStream

interface IWbxmlOutputStream {
    @Throws(IOException::class)
    fun open(namespace: Namespace, token: Int, block: (IWbxmlOutputStream.() -> Unit)? = null)

    @Throws(IOException::class)
    fun write(b: Int)

    @Throws(IOException::class)
    fun write(value: ByteArray)
}

internal class WbxmlOutputStream(private val out: OutputStream) : OutputStream(),
    IWbxmlOutputStream {
    private var currentNamespace: Namespace = Namespace.AirSync

    @Throws(IOException::class)
    override fun open(namespace: Namespace, token: Int, block: (IWbxmlOutputStream.() -> Unit)?) {
        if (currentNamespace != namespace) {
            write(SWITCH_PAGE)
            write(namespace.page)
            currentNamespace = namespace
        }
        write(if (block == null) token else token or WITH_CONTENT)
        block?.invoke(this)
        write(END)
    }

    @Throws(IOException::class)
    override fun write(b: Int) {
        out.write(b)
    }
}