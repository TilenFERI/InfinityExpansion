package io.github.mooy1.infinityexpansion;

import java.io.File;
import java.io.InputStream;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.mockbukkit.mockbukkit.MockBukkit;
import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;

class TestInfinityExpansion {

    @BeforeAll
    public static void load() {
        MockBukkit.mock();
        MockBukkit.load(Slimefun.class);
    }

    @AfterAll
    public static void unload() {
        MockBukkit.unmock();
    }

    @Test
    void testLoad() throws Exception {
        File dataFolder = MockBukkit.getMock().getPluginManager()
                .createTemporaryDirectory("InfinityExpansion-test");
        File pluginFile = MockBukkit.getMock().getPluginManager()
                .createTemporaryPluginFile("InfinityExpansion-test");

        try (InputStream pluginYml = TestInfinityExpansion.class.getClassLoader()
                .getResourceAsStream("plugin.yml")) {
            if (pluginYml == null) {
                throw new IllegalStateException("plugin.yml was not found on the test classpath");
            }

            PluginDescriptionFile description = new PluginDescriptionFile(pluginYml);

            MockBukkit.load(
                    InfinityExpansion.class,
                    new JavaPluginLoader(MockBukkit.getMock()),
                    description,
                    dataFolder,
                    pluginFile,
                    "Mooy1",
                    "InfinityExpansion",
                    "master",
                    "auto-update"
            );
        }
    }

}
