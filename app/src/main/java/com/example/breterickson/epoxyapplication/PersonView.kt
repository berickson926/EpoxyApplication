package com.example.breterickson.epoxyapplication


import android.content.Context
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import kotlinx.android.synthetic.main.view_person.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class PersonView(context: Context) : FrameLayout(context) {

    @TextProp
    fun setName(name: CharSequence) {
        this.name.text = name
    }

    @ModelProp
    fun setPersonId(personId: CharSequence) {
        this.person_id.text = personId
    }

    init {
        inflate(context, R.layout.view_person, this)
    }
}
