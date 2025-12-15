package com.dobson.eas.wbxml.compiler

import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

internal class WbxmlProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment) =
        WbxmlProcessor(
            codeGenerator = environment.codeGenerator,
            logger = environment.logger,
        )
}