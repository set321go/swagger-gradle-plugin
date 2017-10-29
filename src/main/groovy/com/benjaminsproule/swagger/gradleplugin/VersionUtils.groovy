package com.benjaminsproule.swagger.gradleplugin

import org.gradle.api.GradleException

class VersionUtils {

    def static ensureCompatibleSwaggerSpec() {
        if (useSwaggerSpec11()) {
            throw new GradleException('You may use an old version of swagger which is not supported by swagger-gradle-plugin 2.x\n' +
                'swagger-gradle-plugin 2.x only supports swagger-core 1.3.x')
        }

        if (useSwaggerSpec13()) {
            throw new GradleException('You may use an old version of swagger which is not supported by swagger-gradle-plugin 3.x\n' +
                'swagger-gradle-plugin 3.x only supports swagger spec 2.0')
        }
    }

    private static boolean useSwaggerSpec11() {
        try {
            Class.forName('com.wordnik.swagger.annotations.ApiErrors')
            return true
        } catch (ClassNotFoundException ignored) {
            return false
        }
    }

    private static boolean useSwaggerSpec13() {
        try {
            Class.forName('com.wordnik.swagger.model.ApiListing')
            return true
        } catch (ClassNotFoundException ignored) {
            return false
        }
    }
}
