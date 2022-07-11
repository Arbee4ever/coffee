package de.arbeeco.coffee.registries;

import de.arbeeco.coffee.Coffee;
import de.arbeeco.coffee.world.worldgen.CoffeeBeansFeature;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.ModificationPhase;

public class CoffeeFeatures {
	public static Feature<RandomPatchFeatureConfig> COFFEE_PATCH = new CoffeeBeansFeature(RandomPatchFeatureConfig.CODEC);
	public static void setupFeatures() {
		Registry.register(Registry.FEATURE, new Identifier(Coffee.MOD_ID, "patch_coffee_beans.json"), COFFEE_PATCH);
		BiomeModifications.create(new Identifier(Coffee.MOD_ID, "patch_coffee_beans.json"))
				.add(ModificationPhase.ADDITIONS,
						(context) -> context.isIn(TagKey.of(Registry.BIOME_KEY, new Identifier(Coffee.MOD_ID, "has_structure/patch_coffee_beans.json"))),
						(context) -> context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Coffee.MOD_ID, "patch_coffee_beans.json"))));
	};
}