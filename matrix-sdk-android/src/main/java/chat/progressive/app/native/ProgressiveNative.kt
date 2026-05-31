package chat.progressive.app.native

import timber.log.Timber

/**
 * JNI bridge to progressive_native C++ library.
 * Minimal copy for the matrix-sdk-android module.
 */
object ProgressiveNative {
    private var isLoaded = false
    fun ensureLoaded() {
        if (!isLoaded) {
            try {
                System.loadLibrary("progressive_native")
                isLoaded = true
            } catch (e: UnsatisfiedLinkError) {
                Timber.e(e, "Failed to load progressive_native in SDK module")
            }
        }
    }

    init { ensureLoaded() }

    // Matrix identifier validation
    @JvmStatic external fun nativeIsUserId(input: String): Boolean
    @JvmStatic external fun nativeIsRoomId(input: String): Boolean
    @JvmStatic external fun nativeIsRoomAlias(input: String): Boolean
    @JvmStatic external fun nativeIsEventId(input: String): Boolean
    @JvmStatic external fun nativeIsGroupId(input: String): Boolean
    @JvmStatic external fun nativeExtractServerNameFromId(mxid: String): String
    @JvmStatic external fun nativeExtractUserNameFromId(mxid: String): String
    @JvmStatic external fun nativeIsValidOrderString(order: String): Boolean
    @JvmStatic external fun nativeIsMxcUrl(url: String): Boolean
    @JvmStatic external fun nativeCandidateAliasFromRoomName(roomName: String, domain: String): String

    // Error classification
    @JvmStatic external fun nativeClassifyError(errorCode: String, httpCode: Int, errorMessage: String, isNetwork: Boolean, isUnknownHost: Boolean): String
    @JvmStatic external fun nativeGetErrorDescription(code: String): String
    @JvmStatic external fun nativeIsRateLimitError(errorJson: String): Boolean
    @JvmStatic external fun nativeIsSoftLogout(errorJson: String): Boolean
    @JvmStatic external fun nativeNeedsConsent(errorJson: String): Boolean
    @JvmStatic external fun nativeGetRetryAfterMs(errorJson: String): Long
    @JvmStatic external fun nativeGetAllErrorCodes(): String
    @JvmStatic external fun nativeIsPasswordError(errorCode: String): Boolean

    // Base58
    @JvmStatic external fun nativeBase58Encode(data: ByteArray): String
    @JvmStatic external fun nativeBase58Decode(input: String): ByteArray

    // Text utilities
    @JvmStatic external fun nativeExtractUsefulTextFromReply(repliedBody: String): String
    @JvmStatic external fun nativeFormatSpoilerTextFromHtml(html: String): String
    @JvmStatic external fun nativeCanonicalizeJson(json: String): String
}
