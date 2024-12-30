package it.pino.smiley.common.listener;

public interface SmileyListener<T> {

    void register(T event);

    void unregister(T event);
}
