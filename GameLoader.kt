
package com.xenonx.core

import java.io.File

data class GameInfo(
    val name: String,
    val file: File,
    val format: String
)

class GameLoader {

    fun inspect(file: File): GameInfo? {
        if (!file.exists() || !file.isFile) return null

        return GameInfo(
            name = file.nameWithoutExtension,
            file = file,
            format = file.extension.uppercase()
        )
    }
}
