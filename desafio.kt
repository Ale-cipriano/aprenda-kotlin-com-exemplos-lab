/* // [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
} */

// Define os níveis possíveis das formações
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Representa um usuário
data class Usuario(val nome: String)

// Representa um conteúdo educacional (módulo ou aula)
data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60 // duração padrão em minutos
)

// Representa uma formação composta por vários conteúdos
data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>() // lista mutável de usuários

    // Função para matricular um usuário
    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("✅ ${usuario.nome} foi matriculado na formação '$nome' (${nivel.name}).")
        } else {
            println("⚠️ ${usuario.nome} já está matriculado na formação '$nome'.")
        }
    }

    // Mostra detalhes da formação
    fun exibirInformacoes() {
        println("\n📘 Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach {
            println(" - ${it.nome} (${it.duracao} min)")
        }
        println("Total de inscritos: ${inscritos.size}")
    }
}

// Função principal para simular cenários de teste
fun main() {
    // Criar conteúdos
    val introKotlin = ConteudoEducacional("Introdução ao Kotlin", 80)
    val pooKotlin = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 120)
    val avancadoKotlin = ConteudoEducacional("Kotlin Avançado e Boas Práticas", 100)

    // Criar formações
    val formacaoKotlin = Formacao(
        "Formação Desenvolvedor Kotlin",
        Nivel.INTERMEDIARIO,
        listOf(introKotlin, pooKotlin, avancadoKotlin)
    )

    val formacaoAndroid = Formacao(
        "Formação Android com Kotlin",
        Nivel.DIFICIL,
        listOf(
            ConteudoEducacional("Fundamentos do Android", 90),
            ConteudoEducacional("Arquitetura MVVM", 100)
        )
    )

    // Criar usuários
    val usuario1 = Usuario("Alessandro")
    val usuario2 = Usuario("Joana")
    val usuario3 = Usuario("Giselli")

    // Matricular usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // tentativa duplicada
    formacaoAndroid.matricular(usuario3)

    // Exibir detalhes
    formacaoKotlin.exibirInformacoes()
    formacaoAndroid.exibirInformacoes()
}
