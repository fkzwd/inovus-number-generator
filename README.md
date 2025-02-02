### Тестовое задание "Гаишник"

Разработать REST-сервис, выдающий [автомобильные номера](https://ru.wikipedia.org/wiki/%D0%A0%D0%B5%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%86%D0%B8%D0%BE%D0%BD%D0%BD%D1%8B%D0%B5_%D0%B7%D0%BD%D0%B0%D0%BA%D0%B8_%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BF%D0%BE%D1%80%D1%82%D0%BD%D1%8B%D1%85_%D1%81%D1%80%D0%B5%D0%B4%D1%81%D1%82%D0%B2_%D0%B2_%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D0%B8).

### Общие требования

1. Приложение должно быть реализовано на Java 8 или выше с использованием [Java Servlet API](https://docs.oracle.com/javaee/7/tutorial/servlets.htm). 
Допускается использование любого фреймворка/платформы/библиотеки работающего поверх Java Servlet API.
1. Приложение должно запускаться на сервере приложений [Tomcat](https://tomcat.apache.org/) 8 или выше.
1. Для описания сборки приложения использовать любую из современных систем 
автоматической сборки: [gradle](https://gradle.org/), [maven](https://maven.apache.org/) и др.
1. Выполненное задание необходимо отправить на wannajavajob@i-novus.ru.
1. Ориентировочный срок выполнения - 1 день.
1. Для решения задания рекомендуется использовать [spring boot](https://projects.spring.io/spring-boot/).

### Требования к API

Контекст приложения: `/number`

REST-сервис должен реализовывать два GET-метода: `random` и `next`

Ответ должен быть в формате plain text.

Правильные примеры вызовов:

> Запрос: `GET http://localhost:8080/number/random`\
> Ответ: `C399BA 116 RUS`

> Запрос: `GET http://localhost:8080/number/next`\
> Ответ: `C400BA 116 RUS`

### Описание задачи

Методы `random` и `next` должны генерировать и выводить строку формата `A111AA 116 RUS`,

где `A` - любой символ из списка `[А, Е, Т, О, Р, Н, У, К, Х, С, В, М]`, `1` - любая цифра, `116 RUS` - константа.

Необходимо реализовать два алгоритма генерации номера:
1. *Рандомный* - выдается произвольный номер, соответствующий формату при вызове метода `random`. При этом номер не должен совпадать с любым ранее выданным.
1. *Последовательный* - номера выдаются последовательно от меньшего к большему при вызове метода `next`. Сначала производится итерация цифровых символов, и только после этого итерация буквенных. Как предыдущий номер нужно использовать номер, выданный во время предыдущего вызова алгоритма. Номер не должен совпадать с любым ранее выданным.
Для определения порядка буквенных символов следует использовать русский алфавит.

### Примеры
Пример рандомный: C399BA 116 RUS

Пример последовательный 1: после номера C399BA 116 RUS должен идти номер C400BA 116 RUS

Пример последовательный 2: после номера C999BA 116 RUS должен идти номер C000BB 116 RUS

### Критерии оценки
Оцениваться будет всё, начиная от codestyle, заканчивая скоростью работы приложения и выбранным способом решения.
Например, плюсом будет наличие юнит-тестов и правильное использование ООП.
Приветствуются свои оригинальные решения, не приветствуется копипаста с чужих готовых проектов.