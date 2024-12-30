package it.pino.smiley.common.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.dvs.versioning.ManualVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SmileyConfig {

    @NotNull
    private final Path path;
    @Nullable
    private YamlDocument config;

    public SmileyConfig(@NotNull final Path path) {
        this.path = path;
    }

    public void loadConfig(@NotNull final Logger logger){
        try {
            var inputStream = Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("settings.yml"), "Missing settings.yml file!");
            var file = new File(path.toFile(), "settings.yml");
            this.config = YamlDocument.create(
                    file,
                    inputStream,
                    GeneralSettings.DEFAULT,
                    LoaderSettings.builder().setAutoUpdate(true).build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings.builder().setVersioning(new BasicVersioning("version")).setOptionSorting(UpdaterSettings.OptionSorting.SORT_BY_DEFAULTS).build());
            this.config.update();
            this.config.save();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load settings file..", e);
        }
    }


    public YamlDocument getConfig(){
        return Objects.requireNonNull(this.config, "Config is not loaded!");
    }
    public String getToken(){
        return this.getConfig().getString("token");
    }

    public boolean logBlockedRequests(){
        return this.getConfig().getBoolean("log-blocked-requests");
    }

    public boolean logAllowedRequests(){
        return this.getConfig().getBoolean("log-allowed-requests");
    }

    public boolean antiDosEnabled(){
        return this.getConfig().getBoolean("anti-dos.enabled");
    }

    public long antiDosMaxRequests(){
        return this.getConfig().getLong("anti-dos.max-requests");
    }

    public long antiDosInterval(){
        return this.getConfig().getLong("anti-dos.every-millis");
    }

    public boolean antiDosKickPlayer(){
        return this.getConfig().getBoolean("anti-dos.kick-player");
    }

    public List<String> channelsWhitelist(){
        return this.getConfig().getStringList("channels-whitelist");
    }

    public String missingToken(){
        return this.getConfig().getString("messages.missing-token");
    }

    public String kickMessage(){
        return this.getConfig().getString("messages.kick");
    }




}
