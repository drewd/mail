package com.dobson.eas.wbxml.compiler.visitor

import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSNode
import com.google.devtools.ksp.visitor.KSEmptyVisitor
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec

class SerializerClassVisitor : KSEmptyVisitor<Unit, TypeSpec>() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit): TypeSpec {
        return TypeSpec.classBuilder(classDeclaration.serializerName())
            .addModifiers(KModifier.INTERNAL)
            .build()
    }

    override fun defaultHandler(node: KSNode, data: Unit): TypeSpec {
        TODO("Not yet implemented")
    }
}