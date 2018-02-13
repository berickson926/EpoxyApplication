package com.example.breterickson.epoxyapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

data class Person(val personId: String = "", val name: String = "")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val people = arrayListOf(Person(1.toString(), "bret"), Person(2.toString(), "bob"))
//        simpleSetup(people)
        moreRobustSetup(people)
    }


    private fun simpleSetup(people: List<Person>) {
        epoxy_list.withModels {

            titleView {
                id("TitleId")
            }

            people.forEach {
                personView {
                    id(it.personId)
                    name(it.name)
                    personId(it.personId)
                }
            }
        }
    }

    private fun moreRobustSetup(peopleList: MutableList<Person>) {
        val controller = object : EpoxyController() {

            var people: List<Person> = emptyList()

            fun addPeeps(people: List<Person>) {
                this.people = people
                requestModelBuild()
            }

            override fun buildModels() {
                titleView {
                    id("Title")
                }

                people.forEach {
                    personView {
                        id(it.personId)
                        name(it.name)
                        personId(it.personId)
                    }
                }
            }
        }
        epoxy_list.setControllerAndBuildModels(controller)

        root_view.setOnClickListener {
            peopleList.add(Person(UUID.randomUUID().toString(), "Loblaw"))
            controller.addPeeps(peopleList)
        }
    }
}

/** Easily add models to an EpoxyRecyclerView, the same way you would in a buildModels method of EpoxyController. */
fun EpoxyRecyclerView.withModels(buildModelsCallback: EpoxyController.() -> Unit) {
    setControllerAndBuildModels(object : EpoxyController() {
        override fun buildModels() {
            buildModelsCallback()
        }
    })
}
