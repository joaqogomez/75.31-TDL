package modelo.Excepciones

class MovimientoDeEjercitoError(var textoError : String) : RuntimeException(textoError)