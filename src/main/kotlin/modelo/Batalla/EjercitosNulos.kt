package modelo.Batalla

class EjercitosNulos : Ejercitos() {
    override fun disputarDominioDe(unPais: Pais, otrosEjercitos: Ejercitos): Ejercitos {
        otrosEjercitos.avisarOcupacionExitosa(unPais)
        return otrosEjercitos
    }
}