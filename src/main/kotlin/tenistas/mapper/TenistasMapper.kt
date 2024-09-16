package tenistas.mapper


import database.Tenistas_Entity
import org.lighthousegames.logging.logging
import tenistas.dto.TenistaDto
import tenistas.models.Tenista
import java.time.LocalDate
import java.time.LocalDateTime

val logger = logging()
fun Tenistas_Entity.toTenista(): Tenista {
    logger.debug { "Mapeando Tenistas_Entity a Tenista" }
    return Tenista(
        id = this.id,
        nombre = this.nombre,
        pais = this.pais,
        altura = this.altura.toInt(),
        peso = this.peso.toInt(),
        puntos = this.puntos.toInt(),
        mano = this.mano,
        fecha_nacimiento = LocalDate.parse(this.fecha_nacimiento),
        createdAt = LocalDateTime.parse(this.created_at),
        updatedAt = LocalDateTime.parse(this.upadated_at)
    )
}

fun Tenista.toTenistas_Entity(): Tenistas_Entity {
    logger.debug { "Mapeando Tenista a Tenistas_Entity" }
    return Tenistas_Entity(
        id = this.id,
        nombre = this.nombre,
        pais = this.pais,
        altura = this.altura.toLong(),
        peso = this.peso.toLong(),
        puntos = this.puntos.toLong(),
        mano = this.mano,
        fecha_nacimiento = this.fecha_nacimiento.toString(),
        created_at = this.createdAt.toString(),
        upadated_at = this.updatedAt.toString()
    )
}

fun TenistaDto.toTenista(): Tenista {
    logger.debug { "Mapeando TenistaDto a Tenista" }
    return Tenista(
        id = this.id.toLongOrNull()?: 0,
        nombre = this.nombre,
        pais = this.pais,
        altura = this.altura.toInt(),
        peso = this.peso.toInt(),
        puntos = this.puntos.toInt(),
        mano = this.mano,
        fecha_nacimiento = LocalDate.parse(this.fecha_nacimiento),
        createdAt = LocalDateTime.parse(this.created_at),
        updatedAt = LocalDateTime.parse(this.updated_at)
    )
}

fun Tenista.toTenistaDto(): TenistaDto {
    logger.debug { "Mapeando Tenista a TenistaDto" }
    return TenistaDto(
        id = this.id.toString(),
        nombre = this.nombre,
        pais = this.pais,
        altura = this.altura.toString(),
        peso = this.peso.toString(),
        puntos = this.puntos.toString(),
        mano = this.mano,
        fecha_nacimiento = this.fecha_nacimiento.toString(),
        created_at = this.createdAt.toString(),
        updated_at = this.updatedAt.toString()
    )
}