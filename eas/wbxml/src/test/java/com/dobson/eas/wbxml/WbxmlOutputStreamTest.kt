package com.dobson.eas.wbxml

import io.mockk.Ordering
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

    @MockK(relaxed = true)
    lateinit var mockBlock: WbxmlOutputStream.() -> Unit

    @InjectMockKs
    lateinit var wbxmlOutputStream: WbxmlOutputStream

    @Test
    fun `open writes token then block then closes`() {
        wbxmlOutputStream.open(Namespace.AirSync, 5555, mockBlock)
        verify(ordering = Ordering.SEQUENCE) {
            mockOutputStream.write(5555 or WITH_CONTENT)
            mockBlock(wbxmlOutputStream)
            mockOutputStream.write(END)
        }
    }

    @Test
    fun `open writes token then closes`() {
        wbxmlOutputStream.open(Namespace.AirSync, 5555)
        verify(ordering = Ordering.SEQUENCE) {
            mockOutputStream.write(5555)
            mockOutputStream.write(END)
        }
    }

    @Test
    fun `open switch page`() {
        wbxmlOutputStream.open(Namespace.Contacts, 5555, mockBlock)
        verify(ordering = Ordering.SEQUENCE) {
            mockOutputStream.write(SWITCH_PAGE)
            mockOutputStream.write(Namespace.Contacts.page)
            mockOutputStream.write(5555 or WITH_CONTENT)
            mockOutputStream.write(END)
        }
    }

    @Test
    fun write() {
        wbxmlOutputStream.write(5)
        verify { mockOutputStream.write(5) }
    }
}