/*
 * Copyright 2026-2026 Progressive Chat
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Progressive
 * Please see LICENSE files in the repository root for full details.
 */

package chat.progressive.app.features

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface ProgressiveOverrides {
    val forceDialPad: Flow<Boolean>
    val forceLoginFallback: Flow<Boolean>
    val forceHomeserverCapabilities: Flow<HomeserverCapabilitiesOverride>?
}

data class HomeserverCapabilitiesOverride(
        val canChangeDisplayName: Boolean?,
        val canChangeAvatar: Boolean?
)

class DefaultProgressiveOverrides @Inject constructor() : ProgressiveOverrides {
    override val forceDialPad = flowOf(false)
    override val forceLoginFallback = flowOf(false)
    override val forceHomeserverCapabilities: Flow<HomeserverCapabilitiesOverride>? = null
}
