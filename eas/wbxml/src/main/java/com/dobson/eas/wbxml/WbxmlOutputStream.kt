package com.dobson.eas.wbxml

import java.io.IOException
import java.io.OutputStream

internal class WbxmlOutputStream(private val out: OutputStream) : OutputStream() {
    @Throws(IOException::class)
    override fun write(b: Int) {
        out.write(b)
    }
}