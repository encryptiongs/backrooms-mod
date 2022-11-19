package com.kpabr.backrooms.world.biome;


import com.kpabr.backrooms.init.BackroomsLevels;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import com.kpabr.backrooms.util.BiomeList;


public class Level1BiomeSource extends BaseBiomeSource {
    public static final Codec<Level1BiomeSource> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.createRegistryCodec(Registry.BIOME_KEY).forGetter((biomeSource) ->
                    biomeSource.BIOME_REGISTRY), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) ->
                    biomeSource.seed)).apply(instance, instance.stable(Level1BiomeSource::new)));

    public Level1BiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(biomeRegistry, seed, new BiomeList()
                .addEntry(BackroomsLevels.WAREHOUSE_BIOME, 0.2)
                .addEntry(BackroomsLevels.PARKING_GARAGE_BIOME, 0.4)
                .addEntry(BackroomsLevels.CEMENT_WALLS_BIOME, 2)
        );
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new Level0BiomeSource(BIOME_REGISTRY, seed);
    }
}

