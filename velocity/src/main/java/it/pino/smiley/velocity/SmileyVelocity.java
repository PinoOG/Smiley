package it.pino.smiley.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import it.pino.smiley.common.SmileyPlatform;
import it.pino.smiley.common.config.SmileyConfig;
import it.pino.smiley.common.filter.SmileyFilterService;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.logging.Logger;

public final class SmileyVelocity implements SmileyPlatform {

    @NotNull
    private final ProxyServer proxyServer;
    @NotNull
    private final Logger logger;
    @NotNull
    private final SmileyConfig config;

    public SmileyVelocity(@NotNull final ProxyServer proxyServer,
                          @NotNull final Logger logger,
                          @NotNull final Path dataDirectory) {
        this.proxyServer = proxyServer;
        this.logger = logger;
        this.config = new SmileyConfig(dataDirectory);
    }

    @Override
    public void load() {
        logger.info("Loading Smiley config..");
        this.config.loadConfig(logger);
        this.config.channelsWhitelist().forEach(logger::info);
    }

    @Override
    public void unload() {
    }

    @Override
    public @NotNull SmileyConfig getConfig() {
        return this.config;
    }

    @Override
    public @NotNull SmileyFilterService getFilterService() {
        return null;
    }

    @Override
    public @NotNull Logger getLogger() {
        return this.logger;
    }

    public @NotNull ProxyServer getProxyServer() {
        return proxyServer;
    }
}
