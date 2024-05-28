package com.dobson.eas.wbxml.serializer

import com.dobson.eas.wbxml.IWbxmlOutputStream
import com.dobson.eas.wbxml.STR_I
import com.dobson.eas.wbxml.TERM_STR

internal class StringSerializer: Serializer<String> {
    override fun write(output: IWbxmlOutputStream, value: String) {
        output.write(STR_I)
        output.write(value.toByteArray())
        output.write(TERM_STR)
    }
}