package chat.progressive.app.pcore

/**
 * The single Kotlin seam to the native progressive-core. Every function is a
 * suspend call dispatched on the core's own thread; nothing else in the app
 * talks to pcore directly (see docs/PCORE_PORT_PLAN.md).
 */
object PcoreBridge {
    init { System.loadLibrary("pcore_jni") }

    /** Phase 1 exit check. */
    external fun ping(): String

    // Phase 2+ stubs — implemented incrementally per plan phase.
    // external suspend fun login(homeserver: String, user: String, pass: String): String
    // external fun sync(token: String, since: String?): ByteArray
}
