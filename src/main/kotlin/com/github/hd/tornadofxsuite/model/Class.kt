package com.github.hd.tornadofxsuite.model

import com.google.gson.JsonObject
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*

/*data class ClassBreakDown(val className: String,
                          val classAccessLevel: String? = "public",
                          val classFields: ArrayList<Property>,
                          val classDependencies: ArrayList<DependencyInjection>,
                          val classMethods: ArrayList<Function>)

data class Property(val name: String,
                    val accessLevel: String,
                    val type: String,
                    val value: Any)

data class DependencyInjection(val name: String,
                    val accessLevel: String,
                    val dependency: String)

data class Function(val methodName: String,
                     val methodAccess: String = "public",
                     val methodParams: ArrayList<Parameters>,
                     val returnsType: String = "void")

data class Parameters(val paramName: String,
                      val paramType: String)*/

data class BareBreakDown(val className: String,
                         val classProperties: ArrayList<ClassProperties>,
                         val classMethods: ArrayList<String>)

data class ClassProperties(val propertyName: String,
                           val propertyType: String)

// TODO implement an infinite tree structure to hold View structures

enum class MVC {
    ItemViewModel, ViewModel, Controller, View
}

enum class COMPONENTS {
    BORDERPANE, LISTVIEW, TABLEVIEW, VBOX, HBOX,
    DATAGRID, IMAGEVIEW
}

enum class INPUTS {
    Form, TextField, DateField, Button, Action,
    RadioButton, ToggleButton, ComboButton, Checkbox,
    Item, Paginator, PasswordField
}

class TornadoFXInputs(viewClass: String, inputs: ArrayList<String>) {
    val viewClassProperty = SimpleStringProperty(this, "", viewClass)
    var viewClass by viewClassProperty

    val inputsProperty = SimpleObjectProperty(this, "", inputs)
    var inputs by inputsProperty
}

class TornadoFXInputsModel: ItemViewModel<TornadoFXInputs>() {
    val ownerName = bind(TornadoFXInputs::viewClassProperty)
    val catName = bind(TornadoFXInputs::inputsProperty)
}

class TornadoFXInputsScope:  Scope() {
    val model = TornadoFXInputsModel()
}





