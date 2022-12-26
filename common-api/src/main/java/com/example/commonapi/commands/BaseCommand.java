package com.example.commonapi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<TypeID> {
    @TargetAggregateIdentifier
    @Getter public TypeID id;

    public BaseCommand(TypeID id) {
        this.id = id;
    }

}
