package ru.loca_games.novel_games.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EntityNotFoundException  extends javax.persistence.EntityNotFoundException {
    private Object id;
    private String serviceName;
}
