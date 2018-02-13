package com.example.breterickson.epoxyapplication


import android.content.Context
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class TitleView(context: Context) : FrameLayout(context) {

    init {
        inflate(context, R.layout.view_header, this)
    }
}
