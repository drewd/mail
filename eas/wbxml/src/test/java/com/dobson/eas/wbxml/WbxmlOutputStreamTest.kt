package com.dobson.eas.wbxml

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.verify

import org.junit.Rule
import org.junit.Test
import java.io.OutputStream

internal class WbxmlOutputStreamTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK(relaxed = true)
    lateinit var mockOutputStream: OutputStream

    @InjectMockKs
    lateinit var wbxmlOutputStream: WbxmlOutputStream

    @Test
    fun write() {
        wbxmlOutputStream.write(5)
        verify { mockOutputStream.write(5) }
    }
}