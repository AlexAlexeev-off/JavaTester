package ru.alexxx.user.serializers;

import ru.alexxx.user.model.UserColecion;

public interface UserSerializaer {
    void serialize(UserColecion userColecion, String fileName);
}
