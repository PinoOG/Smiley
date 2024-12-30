package it.pino.smiley.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SmileyPlugin {

    @Nullable
    private final SmileyVelocity plugin;
    @NotNull
    private final ProxyServer server;
    @NotNull
    private final Logger logger;

    @Inject
    public SmileyPlugin(@NotNull final ProxyServer proxyServer,
                        @NotNull final Logger logger,
                        @DataDirectory Path dataDirectory){
        this.server = proxyServer;
        this.logger = logger;
        this.plugin = new SmileyVelocity(proxyServer, logger, dataDirectory);
    }

    @Subscribe
    public void onEnable(@NotNull final ProxyInitializeEvent event){
        if(this.plugin != null){
            try{
                this.plugin.load();
            } catch (Exception e) {
                this.logger.log(Level.SEVERE, "An error occurred while loading the plugin", e);
            }

        }
    }

    @Subscribe
    public void onDisable(@NotNull final ProxyShutdownEvent event){
        if(this.plugin != null){
            this.plugin.unload();
        }
    }
}
