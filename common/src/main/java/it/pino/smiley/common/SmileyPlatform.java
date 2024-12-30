package it.pino.smiley.common;

import it.pino.smiley.common.config.SmileyConfig;
import it.pino.smiley.common.filter.SmileyFilterService;
import org.jetbrains.annotations.NotNull;


import java.util.logging.Logger;

public interface SmileyPlatform {

    void load();

    void unload();

    @NotNull
    SmileyConfig getConfig();

    @NotNull
    SmileyFilterService getFilterService();

    @NotNull
    Logger getLogger();
}
