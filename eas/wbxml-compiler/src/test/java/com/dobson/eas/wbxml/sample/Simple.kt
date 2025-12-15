package com.dobson.eas.wbxml.sample

import com.dobson.eas.wbxml.annotation.Namespace
import com.dobson.eas.wbxml.annotation.Tag
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit4.MockKRule
import org.junit.Rule
import org.junit.Test

@Tag(Namespace.AirSync, 456)
data class Simple(
    @Tag(Namespace.AirSync, 789)
    val first: String
)


class SimpleTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @InjectMockKs
    lateinit var serializer: SimpleSerializer

}