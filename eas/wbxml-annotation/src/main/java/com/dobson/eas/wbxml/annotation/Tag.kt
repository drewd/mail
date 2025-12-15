package com.dobson.eas.wbxml.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FIELD)
annotation class Tag(
    val namespace: Namespace,
    val token: Int,
)