
fun main(args: Array<String>) {

    val parser = Parser()
    val constructor = Constructor()

    val paises = constructor.construirPaises(parser.getPaises())
    println(paises["Argentina"]?.paisesLimitrofes)
}