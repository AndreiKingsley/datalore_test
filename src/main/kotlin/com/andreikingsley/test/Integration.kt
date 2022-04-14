package com.andreikingsley.test

import kotlinx.html.*
import kotlinx.html.html
import kotlinx.html.stream.createHTML
import org.jetbrains.kotlinx.jupyter.api.HTML
import org.jetbrains.kotlinx.jupyter.api.annotations.JupyterLibrary
import org.jetbrains.kotlinx.jupyter.api.libraries.*

@JupyterLibrary
internal class Integration : JupyterIntegration() {

    override fun Builder.onLoaded() {
        render<A> { it.field }
        render<AHTML> { HTML(it.toHTML(), isolated = true) }
    }

}

private fun AHTML.toHTML(): String {
    return createHTML().html {
        head {
            meta {
                charset = "utf-8"
            }
            title("HELLO")
        }
        body {
            div {
                text(this@toHTML.field)
            }
        }
    }
}
