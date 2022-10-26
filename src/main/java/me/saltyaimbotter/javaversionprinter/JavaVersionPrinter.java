package me.saltyaimbotter.javaversionprinter;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.stream.Collectors;

public final class JavaVersionPrinter extends JavaPlugin {

    @Override
    public void onEnable() {
        final Runtime.Version version = Runtime.version();

        final List<CharSequence> versionNumbers = version.version().stream().map(number -> number + ".").collect(Collectors.toList());
        final Optional<Integer> build = version.build();
        final Optional<String> optionalInfo = version.optional();
        final Optional<String> preReleaseInfo = version.pre();

        String buildStr = build.map(String::valueOf).orElse("N/A");
        String optionalStr = optionalInfo.map(String::valueOf).orElse("N/A");
        String preReleaseInfoStr = preReleaseInfo.map(String::valueOf).orElse("N/A");

        final Properties properties = System.getProperties();
        final String vendor = properties.getProperty("java.vendor");

        this.getLogger().log(Level.INFO, "Main Version: " + String.join("", versionNumbers));
        this.getLogger().log(Level.INFO, "Build number: " + buildStr);
        this.getLogger().log(Level.INFO, "Optional: " + optionalStr);
        this.getLogger().log(Level.INFO, "Pre Release Info: " + preReleaseInfoStr);
        this.getLogger().log(Level.INFO, "Vendor: " + vendor);


    }
}
