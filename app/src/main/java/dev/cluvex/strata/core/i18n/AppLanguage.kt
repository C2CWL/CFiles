package dev.cluvex.strata.core.i18n

import androidx.annotation.StringRes
import dev.cluvex.strata.R

enum class AppLanguage(val tag: String, @StringRes val nativeName: Int, val rtl: Boolean = false) {
    SYSTEM("", R.string.language_system),
    ENGLISH("en", R.string.language_native_en),
    CHINESE("zh-CN", R.string.language_native_zh),
    ;

    companion object {
        val choices: List<AppLanguage> = entries.filter { it != SYSTEM }

        fun of(tag: String?): AppLanguage {
            if (tag.isNullOrBlank()) return SYSTEM
            val parts = tag.replace('_', '-').lowercase().split('-')
            return when (parts.first()) {
                "en" -> ENGLISH
                "zh" -> if (parts.drop(1).any { it == "hant" || it == "tw" || it == "hk" || it == "mo" }) SYSTEM else CHINESE
                else -> SYSTEM
            }
        }
    }
}
