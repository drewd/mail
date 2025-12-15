plugins {
    alias(libs.plugins.jetbrainsKotlinJvm)
    alias(libs.plugins.ksp)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(libs.symbol.processing.api)
    implementation(project(":eas:wbxml-annotation"))
    implementation(libs.kotlinpoet.ksp)
    testImplementation(libs.mockk)
    kspTest(project(":eas:wbxml-compiler"))
    testImplementation(libs.junit)
}
