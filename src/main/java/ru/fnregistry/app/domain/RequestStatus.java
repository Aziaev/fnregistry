package ru.fnregistry.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 60 Запрос не отправлен
 61 Запрос отправлен
 62 Ответ получен
 01 Информация не найдена
 52 Ответ не готов
 83 Некорректный запрос
 99 Системная ошибка
 */
@Entity
@Table(name = "requeststatus")
@Getter
@Setter
public class RequestStatus {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "description")
    private String description;
}
