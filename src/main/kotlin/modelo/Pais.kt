package modelo

class Pais(
    val nombre: String,
    val paisesLimitrofes : HashMap<String, Pais> = HashMap()
)