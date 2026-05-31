package org.matrix.android.sdk.api.util

import chat.progressive.app.native.ProgressiveNative
import org.matrix.android.sdk.api.extensions.orFalse

object MimeTypes {
    const val Any: String = "*/*"
    const val OctetStream = "application/octet-stream"
    const val Apk = "application/vnd.android.package-archive"
    const val Images = "image/*"
    const val Png = "image/png"
    const val BadJpg = "image/jpg"
    const val Jpeg = "image/jpeg"
    const val Gif = "image/gif"
    const val Webp = "image/webp"
    const val Ogg = "audio/ogg"
    const val PlainText = "text/plain"

    fun String?.normalizeMimeType(): String? {
        if (this == null) return null
        return ProgressiveNative.nativeNormalizeMimeType(this)
    }

    fun String?.isMimeTypeImage() = this != null && ProgressiveNative.nativeIsMimeTypeImage(this)
    fun String?.isMimeTypeVideo() = this != null && ProgressiveNative.nativeIsMimeTypeVideo(this)
    fun String?.isMimeTypeAudio() = this != null && ProgressiveNative.nativeIsMimeTypeAudio(this)
    fun String?.isMimeTypeApplication() = this?.startsWith("application/").orFalse()
    fun String?.isMimeTypeFile() = this?.startsWith("file/").orFalse()
    fun String?.isMimeTypeText() = this?.startsWith("text/").orFalse()
    fun String?.isMimeTypeAny() = this?.startsWith("*/").orFalse()
}
