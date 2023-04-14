class PersonRepositoryImpl реализует interface PersonRepository
override fun generatePerson() - генерация данных
override fun getPersonFields() - получение шапки таблицы

class PersonGenerator генерирует все необходимые данные
Отчества и улицы подтягиваются из middle_name.yml и streets.yml

class PersonMapper реализует interface Mapper<Data, Domain>
Отвечает за конвертацию

font.ttf
Добавленный шрифт

class PersonHandler отвечает за создание упорядоченного списка из сгенерированных данных людей

class PdfHandler отвечает за работу с pdf-файлом: создание самого файла, таблицы и ячеек
 
