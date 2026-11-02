package io.github.mooy1.infinityexpansion;

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
    void testLoad() {
        MockBukkit.load(InfinityExpansion.class, "Mooy1", "InfinityExpansion", "master", "auto-update");
    }

}
