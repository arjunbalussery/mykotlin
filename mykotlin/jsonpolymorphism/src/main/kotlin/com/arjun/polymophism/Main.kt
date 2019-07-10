package com.arjun.polymophism

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(array: Array<String>) {
    val textView = TextView()
    with(textView) {
        text = "hello"
        text = "world"
    }
    val more : (String, String) -> Int = { str1, str2 -> (str1 + str2).length }

    invokeLambda("arjun11"){more}

}


fun invokeLambda (name: String, abc: (String, String)->Int) {
    //block: (String)->Int this means we are expecting a lambd which will do some operation on string and return integer
    // example invokeLambda("arjun11"){it.length}
    println(abc.invoke(name, name))
}

interface Listner {
    fun onTextChanged (property:KProperty<*>, oldText: String, newText: String)
}

class PrintingTextChangedListner : Listner {
    override fun onTextChanged(property:KProperty<*>, oldText: String, newText: String)=
        println("property $property Text is changed $oldText -> $newText")
}

class TextView: Listner by PrintingTextChangedListner() {
    var text : String by Delegates.observable("1"){property,old,new->onTextChanged(property, old, new)}
}
