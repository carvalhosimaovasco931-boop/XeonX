
package com.xenonx.core

enum class CoreState {
    STOPPED,
    INITIALIZING,
    RUNNING,
    PAUSED,
    ERROR
}

class CoreEngine {

    var state: CoreState = CoreState.STOPPED
        private set

    fun initialize(): Boolean {
        if (state != CoreState.STOPPED) return false

        state = CoreState.INITIALIZING

        return try {
            // Inicialização dos subsistemas
            state = CoreState.RUNNING
            true
        } catch (e: Exception) {
            state = CoreState.ERROR
            false
        }
    }

    fun pause() {
        if (state == CoreState.RUNNING) {
            state = CoreState.PAUSED
        }
    }

    fun resume() {
        if (state == CoreState.PAUSED) {
            state = CoreState.RUNNING
        }
    }

    fun shutdown() {
        state = CoreState.STOPPED
    }
}
