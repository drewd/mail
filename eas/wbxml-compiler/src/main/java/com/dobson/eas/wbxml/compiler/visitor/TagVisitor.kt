package com.dobson.eas.wbxml.compiler.visitor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ksp.writeTo

class TagVisitor(
    private val codeGenerator: CodeGenerator,
    private val serializerClassVisitor: SerializerClassVisitor = SerializerClassVisitor()
) : KSVisitorVoid() {
    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        FileSpec.builder(
            classDeclaration.packageName.asString(),
            classDeclaration.serializerName(),
        )
            .addType(classDeclaration.accept(serializerClassVisitor, Unit))
            .build()
            .writeTo(
                codeGenerator,
                Dependencies(
                    false,
                    classDeclaration.containingFile!!,
                )
            )
    }


}
