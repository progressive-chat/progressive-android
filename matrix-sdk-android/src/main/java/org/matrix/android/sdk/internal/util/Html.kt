package org.matrix.android.sdk.internal.util

import chat.progressive.app.native.ProgressiveNative

internal fun String.unescapeHtml(): String = ProgressiveNative.nativeUnescapeHtml(this)
