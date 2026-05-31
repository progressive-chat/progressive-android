/*
 * Copyright 2021-2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package chat.progressive.app.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import chat.progressive.app.features.DefaultProgressiveFeatures
import chat.progressive.app.features.DefaultProgressiveOverrides
import chat.progressive.app.features.ProgressiveFeatures
import chat.progressive.app.features.ProgressiveOverrides

@InstallIn(SingletonComponent::class)
@Module
interface FeaturesModule {

    @Binds
    fun bindFeatures(defaultFeatures: DefaultProgressiveFeatures): ProgressiveFeatures

    @Binds
    fun bindOverrides(defaultOverrides: DefaultProgressiveOverrides): ProgressiveOverrides

    companion object {
        @Provides
        @NamedGlobalScope
        fun providesGlobalScope(): CoroutineScope = CoroutineScope(SupervisorJob())
    }
}
