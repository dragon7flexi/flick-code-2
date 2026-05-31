package com.example.expe.data

import Cursor
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CursorRepository(private val context: Context) {

    private val rowKey = intPreferencesKey("cursor_row")
    private val colKey = intPreferencesKey("cursor_col")

    val cursorFlow: Flow<Cursor> =
        context.dataStore.data.map { pref ->
            Cursor(
                pref[rowKey] ?: 0,
                pref[colKey] ?: 0
            )
        }

    suspend fun saveCursor(cursor: Cursor) {
        context.dataStore.edit { pref ->
            pref[rowKey] = cursor.row
            pref[colKey] = cursor.col
        }
    }
}