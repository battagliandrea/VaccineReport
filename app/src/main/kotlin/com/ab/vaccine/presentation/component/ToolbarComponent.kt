package com.ab.vaccine.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ab.vaccine.databinding.ComponentToolbarBinding

class ToolbarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ComponentToolbarBinding
        .inflate(LayoutInflater.from(context), this)

    val toolbar
        get() = binding.toolbar
}
