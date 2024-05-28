package com.dobson.eas.wbxml.serializer

import com.dobson.eas.wbxml.IWbxmlOutputStream

interface Serializer<T> {
    fun write(output: IWbxmlOutputStream, value: T)
}