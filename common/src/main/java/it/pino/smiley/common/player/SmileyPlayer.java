package it.pino.smiley.common.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface SmileyPlayer<T> {

    @NotNull
    UUID getUniqueId();

    @NotNull
    String getName();

    long getExpiration();

    long getPacketsSent();

    @Nullable
    T getProxyPlayer();

}
