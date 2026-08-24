/*
 * Copyright 2026-2026 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package chat.progressive.app.features.spaces.leave

import chat.progressive.app.core.platform.ProgressiveViewModelAction

sealed class SpaceLeaveAdvanceViewAction : ProgressiveViewModelAction {
    data class ToggleSelection(val roomId: String) : SpaceLeaveAdvanceViewAction()
    data class UpdateFilter(val filter: String) : SpaceLeaveAdvanceViewAction()
    data class SetFilteringEnabled(val isEnabled: Boolean) : SpaceLeaveAdvanceViewAction()
    object DoLeave : SpaceLeaveAdvanceViewAction()
    object ClearError : SpaceLeaveAdvanceViewAction()
    object SelectAll : SpaceLeaveAdvanceViewAction()
    object SelectNone : SpaceLeaveAdvanceViewAction()
}
