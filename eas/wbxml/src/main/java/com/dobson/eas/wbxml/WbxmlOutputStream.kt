package com.dobson.eas.wbxml

import java.io.IOException
import java.io.OutputStream

internal class WbxmlOutputStream(private val out: OutputStream) : OutputStream() {
    private var currentNamespace: Namespace = Namespace.AirSync

    @Throws(IOException::class)
    fun open(namespace: Namespace, token: Int, block: (WbxmlOutputStream.() -> Unit)? = null) {
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