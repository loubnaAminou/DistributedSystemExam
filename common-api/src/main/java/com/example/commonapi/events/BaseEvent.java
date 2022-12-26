package com.example.commonapi.events;

import lombok.Getter;

public abstract class BaseEvent<TypeID> {
    @Getter private TypeID id;

    public BaseEvent(TypeID id) {
        this.id = id;
    }

}
