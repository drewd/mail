package com.dobson.eas.wbxml.serializer

import com.dobson.eas.wbxml.IWbxmlOutputStream
import com.dobson.eas.wbxml.STR_I
import com.dobson.eas.wbxml.TERM_STR
import io.mockk.Ordering
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

internal class StringSerializerTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    @RelaxedMockK
    lateinit var mockIWbxmlOutputStream: IWbxmlOutputStream

    @InjectMockKs
    lateinit var serializer: StringSerializer

    @Test
    fun write() {
        serializer.write(mockIWbxmlOutputStream, "test")
        verify(ordering = Ordering.SEQUENCE) {
            mockIWbxmlOutputStream.write(STR_I)
            mockIWbxmlOutputStream.write("test".toByteArray())
            mockIWbxmlOutputStream.write(TERM_STR)
        }
    }
}