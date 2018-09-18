package com.github.hd.tornadofxsuite

import com.github.hd.tornadofxsuite.view.MainView
import mu.KLogging
import org.junit.Test
import org.testfx.api.FxAssert.verifyThat
import org.testfx.matcher.control.LabeledMatchers.hasText

// Attempted PBT with UI
class TornadoFXSuite: TornadoFxTest() {
    companion object: KLogging()
    @Test
    fun test() {
        showViewWithParams<MainView>(mapOf("string" to "string"))

        verifyThat(".button", hasText("Upload your project directory."))
    }

    // TODO - first PBT test will be replaceViews
}