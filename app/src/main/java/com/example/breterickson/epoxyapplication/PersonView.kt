package com.example.breterickson.epoxyapplication


import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.view_person.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class PersonView : FrameLayout {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @TextProp
    fun setName(name: CharSequence) {
        this.name.text = name
    }

    @TextProp
    fun setPersonId(personId: CharSequence) {
        this.person_id.text = personId
    }

    private fun init() {
        inflate(context, R.layout.view_person, this)
    }
}
