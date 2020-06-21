package app.plantdiary.individualassignment3048q.ui.main

data class Country(var code: String, var name: String) {
//    val code: String = code
//    val name: String = name

    override fun toString(): String{
        //return the name of the country followed by the code separated by a space
        return (name + " " + code)
    }

}