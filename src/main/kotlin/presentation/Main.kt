package presentation

import data.repository.PersonRepositoryImpl
import data.services.PersonGenerator
import domain.mapper.PersonMapper
import domain.repository.PersonRepository
import utils.PdfHandler
import utils.PersonHandler
import java.util.*

fun main() {
    val personRepository = initPersonRepository()
    val pdfHandler = PdfHandler()
    val personHandler = PersonHandler()
    print("Введите количество человек для генерации: ")
    val scan = Scanner(System.`in`)
    var number = scan.nextInt()
    while (number !in 1..30) {
        print("Введите корректное количество человек для генерации (от 1 до 30): ")
        number = scan.nextInt()
    }
    val personList = personHandler.createPersonList(number, personRepository)
    val parsedPersonList = personHandler.parsePersonList(personList)
    pdfHandler.createPdfTable(
        "result.pdf", personRepository.getPersonFields(), parsedPersonList)
    val dir : String = System.getProperty("user.dir");
    print("Файл создан. Путь: $dir")
}

fun initPersonRepository(): PersonRepository {
    val personMapper = PersonMapper()
    val personGenerator = PersonGenerator()
    return PersonRepositoryImpl(personMapper, personGenerator)
}