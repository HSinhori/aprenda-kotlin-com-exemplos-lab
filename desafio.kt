enum class Nivel { TECNICO, GRADUADO, MESTRADO, DOUTORADO }

class Usuario(val nome: String, val formacao: String, val nivel: String)

val inscritos = mutableListOf<Usuario>()

fun matricular(usuario: Usuario) {
    inscritos.add(usuario)
    println("${usuario.nome.capitalize()} matriculado com sucesso no curso ${usuario.formacao} (${usuario.nivel})!")
}

fun listarInscritos() {
    println("Nomes dos inscritos:")
    for (usuario in inscritos) {
        println("${usuario.nome.capitalize()}")
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) 

val conteudoList = mutableListOf<ConteudoEducacional>()

fun registrarConteudo(conteudo: ConteudoEducacional) {
    conteudoList.add(conteudo)
    println("Conteudo registrado com sucesso!")
}

fun listarConteudo() {
    println("Conteúdos encontrados na plataforma:")
    for(cont in conteudoList){
        println("Título do conteúdo: ${cont.nome} - Tempo de duração ${cont.duracao} horas.")
    }
}

//data class Formacao(val nome: List<Usuario>, val nivel: Nivel, var conteudos: List<ConteudoEducacional>)

fun main() {

    var choose: String

    do {
        println("")
        println(" ------------------------------------- ")
        println("| 1 - Adicionar Usuário               |")
        println("| 2 - Adicionar Conteúdo Educacional  |")
        println("| 3 - Listar Inscritos                |")
        println("| 4 - Listar Conteúdos Educacionais   |")
        println("| 0 - Fechar                          |")
        println(" ------------------------------------- ")
        
        choose = readLine().toString()

        when (choose) {
            "1" -> {
                newUser()
            }
            "2" -> {
                newEdContent()
            }
            "3" -> {
                listarInscritos()
            }
            "4" -> {
                listarConteudo()
            }
            "0" -> println("Fechando...")
            else -> println("Opção inválida! Por favor, escolha novamente.")
        }
    } while (choose != "0")
}

fun newUser() {

    val conteudoEdSize = conteudoList.size

    if(conteudoEdSize > 0) {
        println("Digite o nome do inscrito")
        val nomeDoInscrito = readLine().toString()
        println("")

        println("Agora selecione o curso")
        for((index, conteudo) in conteudoList.withIndex()){
            println("$index - ${conteudo.nome}")
        }
        val curso = readLine().toString().toInt()
        val cursoSelecionado = conteudoList[curso].nome
        println("")

        println("Agora selecione o nível de formação")
        val nivelList = Nivel.values()
        for((index, i) in nivelList.withIndex()){
            println("$index - $i")
        }
        val nivel = readLine().toString().toInt()
        val nivelEscolhido = Nivel.values()[nivel].toString()

        val usuario = Usuario(nomeDoInscrito, cursoSelecionado, nivelEscolhido)
        matricular(usuario)
    }else{
        println("Nenhum conteúdo educacional encontrado!")
    }
}

fun newEdContent() {
    println("Digite o título do conteudo.")
    val contName: String = readLine().toString()
    println("Agora digite o tempo de duração em horas.")
    val contDuracao: Int = readLine().toString().toInt()

    val conteudoEducacional = ConteudoEducacional(contName, contDuracao)
    registrarConteudo(conteudoEducacional)

}
