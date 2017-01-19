# fnregistry

SOAP микросервис для ведения реестра пользователей с возможностью получения информации через обращение к внешнему сервису.
Возможности: добавление пользователей, отправка запросов информации из веб-сервиса ФНС России - "Предоставление сведений об ИНН физического лица на основании данных о ФИО и дате рождения".

#Что использовано:
Java: Spring Boot/Data/Security + Lombok
Web: Thymeleaf + MaterializeCSS + JQuer
WS: SOAP, JAXB
Database: PostgreSQL
Soft: IntelliJ Idea, SmartGit, Github, Advanced REST client

#Что сделано:
Прием, отправка запросов, отображения статуса запросов, обнуление запросов. Управление запросами.
Регистрация, авторизация и CRUD пользователей.
Подключение к базе данных PostgreSQL через

#Что не реализовано:
Не реализовано использование AngularJS.

#Данные:
Тестовый пользователь: aziaev@gmail.com Zaq12wsx

#Ссылки:
Ссылка на проект: https://github.com/Aziaev/fnregistry
Ссылка на war: https://github.com/Aziaev/fnregistry/target app-1.0-SNAPSHOT.war
Ссылка на бекап базы: https://github.com/Aziaev/fnregistry fnregistryDB.backup

#Структура сайта:
http://localhost:8080/welcome - страница приветствия
http://localhost:8080/sign-in - авторизация (использовать креденшалсы тестового пользователя)
http://localhost:8080/sign-up - регистрация в системе
http://localhost:8080/users - реестр пользователей

#Как использовать
регистрация / авторизация / список пользователей - CRUD пользователей, CRUD запросов
