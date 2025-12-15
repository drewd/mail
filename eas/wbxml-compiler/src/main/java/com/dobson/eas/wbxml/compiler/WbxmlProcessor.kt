package com.dobson.eas.wbxml.compiler

import com.dobson.eas.wbxml.annotation.Tag
import com.dobson.eas.wbxml.compiler.visitor.TagVisitor
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration

internal class WbxmlProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(Tag::class.qualifiedName!!)
            .filterIsInstance<KSClassDeclaration>()

        symbols.forEach {
            it.accept(
                TagVisitor(
                    codeGenerator = codeGenerator
                ), Unit
            )
        }

        return emptyList()
    }
}