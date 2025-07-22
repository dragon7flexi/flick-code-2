package com.example.expe.logic

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

class ClipboardService(private val context: Context) {
    fun copy(lines: List<String>) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val text = lines.joinToString(separator = "\n")
        val clip = ClipData.newPlainText("code", text)
        clipboard.setPrimaryClip(clip)
    }

    fun getLines(): List<String>? {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = clipboard.primaryClip ?: return null

        val joined = clip.getItemAt(0).coerceToText(context).toString()
        return joined.split('\n')
    }
}