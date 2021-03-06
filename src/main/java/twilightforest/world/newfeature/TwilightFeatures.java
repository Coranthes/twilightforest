package twilightforest.world.newfeature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunkplacer.AbstractTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import twilightforest.TwilightForestMod;
import twilightforest.block.BlockTFFirefly;
import twilightforest.block.TFBlocks;

public final class TwilightFeatures {
    public static final FoliagePlacerType<LeafSpheroidFoliagePlacer> FOLIAGE_SPHEROID = registerFoliage(TwilightForestMod.prefix("spheroid_foliage_placer"), LeafSpheroidFoliagePlacer.CODEC);
    public static final TrunkPlacerType<BranchingTrunkPlacer> TRUNK_BRANCHING = registerTrunk(TwilightForestMod.prefix("branching_trunk_placer"), BranchingTrunkPlacer.CODEC);
    public static final TrunkPlacerType<TrunkRiser> TRUNK_RISER = registerTrunk(TwilightForestMod.prefix("trunk_mover_upper"), TrunkRiser.CODEC);
    public static final TreeDecoratorType<TrunkSideDecorator> TRUNKSIDE_DECORATOR = registerTreeFeature(TwilightForestMod.prefix("trunkside_decorator"), TrunkSideDecorator.CODEC);
    public static final TreeDecoratorType<TreeRootsDecorator> TREE_ROOTS = registerTreeFeature(TwilightForestMod.prefix("tree_roots"), TreeRootsDecorator.CODEC);

    public static final class BlockStates {
        //Blockstates
        public static final BlockState WATER = net.minecraft.block.Blocks.WATER.getDefaultState();
        public static final BlockState LAVA = net.minecraft.block.Blocks.LAVA.getDefaultState();
        public static final BlockState SPRUCE_LOG = net.minecraft.block.Blocks.SPRUCE_LOG.getDefaultState();
        public static final BlockState SPRUCE_WOOD = net.minecraft.block.Blocks.SPRUCE_WOOD.getDefaultState();
        public static final BlockState SPRUCE_LEAVES = net.minecraft.block.Blocks.SPRUCE_LEAVES.getDefaultState();
        public static final BlockState OAK_LOG = TFBlocks.oak_log.get().getDefaultState();
        public static final BlockState OAK_WOOD = TFBlocks.oak_wood.get().getDefaultState();
        public static final BlockState OAK_LEAVES = TFBlocks.oak_leaves.get().getDefaultState();
        public static final BlockState CANOPY_LOG = TFBlocks.canopy_log.get().getDefaultState();
        public static final BlockState CANOPY_WOOD = TFBlocks.canopy_wood.get().getDefaultState();
        public static final BlockState CANOPY_LEAVES = TFBlocks.canopy_leaves.get().getDefaultState();
        public static final BlockState MANGROVE_LOG = TFBlocks.mangrove_log.get().getDefaultState();
        public static final BlockState MANGROVE_WOOD = TFBlocks.mangrove_wood.get().getDefaultState();
        public static final BlockState MANGROVE_LEAVES = TFBlocks.mangrove_leaves.get().getDefaultState();
        public static final BlockState DARKWOOD_LOG = TFBlocks.dark_log.get().getDefaultState();
        public static final BlockState DARKWOOD_WOOD = TFBlocks.dark_wood.get().getDefaultState();
        public static final BlockState DARKWOOD_LEAVES = TFBlocks.dark_leaves.get().getDefaultState();
        public static final BlockState TIME_LOG = TFBlocks.time_log.get().getDefaultState();
        public static final BlockState TIME_WOOD = TFBlocks.time_wood.get().getDefaultState();
        public static final BlockState TIME_LEAVES = TFBlocks.time_leaves.get().getDefaultState();
        public static final BlockState TRANSFORM_LOG = TFBlocks.transformation_log.get().getDefaultState();
        public static final BlockState TRANSFORM_WOOD = TFBlocks.transformation_wood.get().getDefaultState();
        public static final BlockState TRANSFORM_LEAVES = TFBlocks.transformation_leaves.get().getDefaultState();
        public static final BlockState MINING_LOG = TFBlocks.mining_log.get().getDefaultState();
        public static final BlockState MINING_WOOD = TFBlocks.mining_wood.get().getDefaultState();
        public static final BlockState MINING_LEAVES = TFBlocks.mining_leaves.get().getDefaultState();
        public static final BlockState SORT_LOG = TFBlocks.sorting_log.get().getDefaultState();
        public static final BlockState SORT_WOOD = TFBlocks.sorting_wood.get().getDefaultState();
        public static final BlockState SORT_LEAVES = TFBlocks.sorting_leaves.get().getDefaultState();
        public static final BlockState RAINBOW_LEAVES = TFBlocks.rainboak_leaves.get().getDefaultState();
        public static final BlockState ROOTS = TFBlocks.root.get().getDefaultState();
        public static final BlockState GRASS = net.minecraft.block.Blocks.GRASS.getDefaultState();
        public static final BlockState FERN = net.minecraft.block.Blocks.FERN.getDefaultState();
        public static final BlockState MAYAPPLE = TFBlocks.mayapple.get().getDefaultState();
        public static final BlockState FIDDLEHEAD = TFBlocks.fiddlehead.get().getDefaultState();
        public static final BlockState MUSHGLOOM = TFBlocks.mushgloom.get().getDefaultState();
        public static final BlockState DEAD_BUSH = net.minecraft.block.Blocks.DEAD_BUSH.getDefaultState();
        public static final BlockState FOREST_GRASS = net.minecraft.block.Blocks.GRASS.getDefaultState();
        public static final BlockState FIRE_JET = TFBlocks.fire_jet.get().getDefaultState();
        public static final BlockState SMOKER = TFBlocks.smoker.get().getDefaultState();
    }


    public static final class Decorators {
        public static final TreeRootsDecorator LIVING_ROOTS = new TreeRootsDecorator(3, 1, 5, (new WeightedBlockStateProvider())
                .addWeightedBlockstate(BlockStates.ROOTS, 4)
                .addWeightedBlockstate(TFBlocks.liveroot_block.get().getDefaultState(), 1));

        public static final TrunkSideDecorator FIREFLY = new TrunkSideDecorator(1, 1.0f, new SimpleBlockStateProvider(TFBlocks.firefly.get().getDefaultState().with(BlockTFFirefly.FACING, Direction.NORTH)));
    }

    public static final class TreeConfigurations {
        public static final BaseTreeFeatureConfig TWILIGHT_OAK = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.OAK_LOG),
                new SimpleBlockStateProvider(BlockStates.OAK_LEAVES),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                new StraightTrunkPlacer(4, 2, 0),
                new TwoLayerFeature(1, 0, 1)
        )
                .func_236703_a_(ImmutableList.of(Decorators.LIVING_ROOTS))
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig CANOPY_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.CANOPY_LOG),
                new SimpleBlockStateProvider(BlockStates.CANOPY_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, -0.25f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 9),
                new TwoLayerFeature(1, 0, 1)
        )
                .func_236703_a_(ImmutableList.of(Decorators.FIREFLY, Decorators.LIVING_ROOTS))
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig MANGROVE_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.MANGROVE_LOG),
                new SimpleBlockStateProvider(BlockStates.MANGROVE_LEAVES),
                new LeafSpheroidFoliagePlacer(2.5f, 1.5f, FeatureSpread.func_242252_a(0), 2, 0, -0.25f),
                new TrunkRiser(5, new BranchingTrunkPlacer(6, 4, 0, 1, 2, 6, 7)),
                new TwoLayerFeature(1, 0, 1)
        )
                .func_236703_a_(ImmutableList.of(
                        Decorators.FIREFLY,
                        new TreeRootsDecorator(3, 1, 12, new SimpleBlockStateProvider(BlockStates.MANGROVE_WOOD), (new WeightedBlockStateProvider())
                                .addWeightedBlockstate(BlockStates.ROOTS, 4)
                                .addWeightedBlockstate(TFBlocks.liveroot_block.get().getDefaultState(), 1))
                        )
                )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig DARKWOOD_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.DARKWOOD_LOG),
                new SimpleBlockStateProvider(BlockStates.DARKWOOD_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 2.25f, FeatureSpread.func_242252_a(0), 1, 0, 0.45f),
                new BranchingTrunkPlacer(6, 5, 0, 4, 1, 6, 10),
                new TwoLayerFeature(1, 0, 1)
        )
                .func_236703_a_(ImmutableList.of(Decorators.LIVING_ROOTS))
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig TIME_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.TIME_LOG),
                new SimpleBlockStateProvider(BlockStates.TIME_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig TRANSFORM_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.TRANSFORM_LOG),
                new SimpleBlockStateProvider(BlockStates.TRANSFORM_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig MINING_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.MINING_LOG),
                new SimpleBlockStateProvider(BlockStates.MINING_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig SORT_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.SORT_LOG),
                new SimpleBlockStateProvider(BlockStates.SORT_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig HOLLOW_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.OAK_LOG),
                new SimpleBlockStateProvider(BlockStates.OAK_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig WINTER_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.SPRUCE_LOG),
                new SimpleBlockStateProvider(BlockStates.SPRUCE_LEAVES),
                new LeafSpheroidFoliagePlacer(4.5f, 1.5f, FeatureSpread.func_242252_a(0), 1, 0, 0f),
                new BranchingTrunkPlacer(20, 5, 5, 3, 1, 10, 16),
                new TwoLayerFeature(1, 0, 1)
        )
                .setIgnoreVines()
                .build();

        public static final BaseTreeFeatureConfig RAINBOAK_TREE = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(BlockStates.OAK_LOG),
                new SimpleBlockStateProvider(BlockStates.RAINBOW_LEAVES),
                new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                new StraightTrunkPlacer(4, 2, 0),
                new TwoLayerFeature(1, 0, 1)
        )
                .func_236703_a_(ImmutableList.of(Decorators.LIVING_ROOTS))
                .setIgnoreVines()
                .build();

        public static final BlockClusterFeatureConfig MUSHGLOOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockStates.MUSHGLOOM), new SimpleBlockPlacer())).tries(32).build();
    }

    public static final class ConfiguredFeatures {
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ? extends Feature<?>> TWILIGHT_OAK = registerFeature(TwilightForestMod.prefix("twilight_oak"), Feature.field_236291_c_.withConfiguration(TreeConfigurations.TWILIGHT_OAK));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ? extends Feature<?>> CANOPY_TREE = registerFeature(TwilightForestMod.prefix("canopy_tree"), Feature.field_236291_c_.withConfiguration(TreeConfigurations.CANOPY_TREE));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ? extends Feature<?>> MANGROVE_TREE = registerFeature(TwilightForestMod.prefix("mangrove_tree"), Feature.field_236291_c_.withConfiguration(TreeConfigurations.MANGROVE_TREE));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ? extends Feature<?>> DARKWOOD_TREE = registerFeature(TwilightForestMod.prefix("darkwood_tree"), Feature.field_236291_c_.withConfiguration(TreeConfigurations.DARKWOOD_TREE));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ? extends Feature<?>> RAINBOAK_TREE = registerFeature(TwilightForestMod.prefix("rainbow_oak"), Feature.field_236291_c_.withConfiguration(TreeConfigurations.RAINBOAK_TREE));

        public static final ConfiguredFeature<?, ?> DEFAULT_TWILIGHT_TREES = registerFeature(TwilightForestMod.prefix("twilight_trees"),
                Feature.RANDOM_SELECTOR
                        .withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(TWILIGHT_OAK.withChance(0.23f), CANOPY_TREE.withChance(0.23f), MANGROVE_TREE.withChance(0.23f), DARKWOOD_TREE.withChance(0.23f)), RAINBOAK_TREE))
                        .withPlacement(Features.Placements.field_244001_l)
                        //.withPlacement(Placement.field_242902_f.configure(new AtSurfaceWithExtraConfig(0, 0.1f, 1)))
        );
    }

    private static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(ResourceLocation name, Codec<P> codec) {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPE, name, new FoliagePlacerType<>(codec));
    }

    private static <P extends AbstractTrunkPlacer> TrunkPlacerType<P> registerTrunk(ResourceLocation name, Codec<P> codec) {
        // TRUNK_REPLACER is wrong, it only places, not replacing
        return Registry.register(Registry.TRUNK_REPLACER, name, new TrunkPlacerType<>(codec));
    }

    private static <P extends TreeDecorator> TreeDecoratorType<P> registerTreeFeature(ResourceLocation name, Codec<P> codec) {
        // TRUNK_REPLACER is wrong, it only places, not replacing
        return Registry.register(Registry.TREE_DECORATOR_TYPE, name, new TreeDecoratorType<>(codec));
    }

    protected static <FC extends IFeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> registerFeature(ResourceLocation rl, ConfiguredFeature<FC, F> feature) {
        return Registry.register(WorldGenRegistries.field_243653_e, rl, feature);
    }
}
