package it.pino.smiley.common.filter;

import it.pino.smiley.common.player.SmileyPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface SmileyFilterService {

    Map<UUID, SmileyPlayer> getTrackedPlayers();

    Collection<String> getChannelsWhitelist();

    long configMillis();

    void evaluate(@NotNull final UUID uniqueId);

    void increment(@NotNull final UUID uniqueId);

    void alertStaff(@NotNull final SmileyPlayer player);

    void remove(@NotNull final UUID uniqueId);
}
