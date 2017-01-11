package ru.fnregistry.app.service.currentuser;

import ru.fnregistry.app.domain.CurrentUser;

public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
