package com.dobson.eas.wbxml.compiler.visitor

import com.google.devtools.ksp.symbol.KSClassDeclaration

fun KSClassDeclaration.serializerName() = "${simpleName.asString()}Serializer"