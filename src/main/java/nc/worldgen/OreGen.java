package nc.worldgen;
 
import java.util.Random;

import nc.Config;
import nc.block.NCBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class OreGen implements IWorldGenerator {
	
	WorldGenMinable copper;
	WorldGenMinable tin;
	WorldGenMinable lead;
	WorldGenMinable silver;
	WorldGenMinable uranium;
	WorldGenMinable thorium;
	WorldGenMinable lithium;
	WorldGenMinable boron;
	WorldGenMinable magnesium;
	WorldGenMinable plutonium;
	WorldGenMinable liquidHelium;
    
    public OreGen() {
		copper = new WorldGenMinable(NCBlocks.blockOre, 0, Config.oreSizeCopper, Blocks.stone);
		tin = new WorldGenMinable(NCBlocks.blockOre, 1, Config.oreSizeTin, Blocks.stone);
		lead = new WorldGenMinable(NCBlocks.blockOre, 2, Config.oreSizeLead, Blocks.stone);
		silver = new WorldGenMinable(NCBlocks.blockOre, 3, Config.oreSizeSilver, Blocks.stone);
		uranium = new WorldGenMinable(NCBlocks.blockOre, 4, Config.oreSizeUranium, Blocks.stone);
		thorium = new WorldGenMinable(NCBlocks.blockOre, 5, Config.oreSizeThorium, Blocks.stone);
		lithium = new WorldGenMinable(NCBlocks.blockOre, 7, Config.oreSizeLithium, Blocks.stone);
		boron = new WorldGenMinable(NCBlocks.blockOre, 8, Config.oreSizeBoron, Blocks.stone);
		magnesium = new WorldGenMinable(NCBlocks.blockOre, 9, Config.oreSizeMagnesium, Blocks.stone);
        plutonium = new WorldGenMinable(NCBlocks.blockOre, 6, Config.oreSizePlutonium, Blocks.netherrack);
        liquidHelium = new WorldGenMinable(NCBlocks.blockHelium, 0, 8, Blocks.end_stone);
    }
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.isHellWorld) generateNether(random, chunkX * 16, chunkZ * 16, world);
        else if (world.provider.dimensionId == 1) generateEnd(random, chunkX * 16, chunkZ * 16, world);
        else if (world.provider.terrainType != WorldType.FLAT) generateSurface(random, chunkX * 16, chunkZ * 16, world);
    }
 
	void generateSurface(Random random, int xChunk, int zChunk, World world) {
		int xPos, yPos, zPos;
        if (Config.oreGenCopper)
        { for (int i = 0; i < Config.oreRarityCopper; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightCopper); zPos = zChunk + random.nextInt(16);
                copper.generate(world, random, xPos, yPos, zPos); } }

        if (Config.oreGenTin)
        { for (int i = 0; i < Config.oreRarityTin; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightTin); zPos = zChunk + random.nextInt(16);
                tin.generate(world, random, xPos, yPos, zPos); } }

        if (Config.oreGenLead)
        { for (int i = 0; i < Config.oreRarityLead; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightLead); zPos = zChunk + random.nextInt(16);
                lead.generate(world, random, xPos, yPos, zPos); } }

        if (Config.oreGenSilver)
        { for (int i = 0; i < Config.oreRaritySilver; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightSilver); zPos = zChunk + random.nextInt(16);
                silver.generate(world, random, xPos, yPos, zPos); } }

        if (Config.oreGenUranium)
        { for (int i = 0; i < Config.oreRarityUranium; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightUranium); zPos = zChunk + random.nextInt(16);
                uranium.generate(world, random, xPos, yPos, zPos); } }

        if (Config.oreGenThorium)
        { for (int i = 0; i < Config.oreRarityThorium; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightThorium); zPos = zChunk + random.nextInt(16);
                thorium.generate(world, random, xPos, yPos, zPos); } }
        
        if (Config.oreGenLithium)
        { for (int i = 0; i < Config.oreRarityLithium; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightLithium); zPos = zChunk + random.nextInt(16);
                lithium.generate(world, random, xPos, yPos, zPos); } }
        
        if (Config.oreGenBoron)
        { for (int i = 0; i < Config.oreRarityBoron; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightBoron); zPos = zChunk + random.nextInt(16);
                boron.generate(world, random, xPos, yPos, zPos); } }
        
        if (Config.oreGenMagnesium)
        { for (int i = 0; i < Config.oreRarityMagnesium; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightMagnesium); zPos = zChunk + random.nextInt(16);
                magnesium.generate(world, random, xPos, yPos, zPos); } }
	}
    
    void generateNether(Random random, int xChunk, int zChunk, World world) {
        int xPos, yPos, zPos;
        if (Config.oreGenPlutonium)
        { for (int i = 0; i < Config.oreRarityPlutonium; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(Config.oreMaxHeightPlutonium); zPos = zChunk + random.nextInt(16);
                plutonium.generate(world, random, xPos, yPos, zPos); } }
    }
    
    void generateEnd(Random random, int xChunk, int zChunk, World world) {
        int xPos, yPos, zPos;
        if (Config.liquidHeliumLakeGen > 0)
        { for (int i = 0; i < Config.liquidHeliumLakeGen; i++) { xPos = xChunk + random.nextInt(16); yPos = random.nextInt(128); zPos = zChunk + random.nextInt(16);
        		liquidHelium.generate(world, random, xPos, yPos, zPos); } }
    }
 
    /**
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
     * 
     * @param The Block to spawn
     * @param The World to spawn in
     * @param A Random object for retrieving random positions within the world to spawn the Block
     * @param An int for passing the X-Coordinate for the Generation method
     * @param An int for passing the Z-Coordinate for the Generation method
     * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param An int for setting the maximum size of a vein
     * @param An int for the Number of chances available for the Block to spawn per-chunk
     * @param An int for the minimum Y-Coordinate height at which this block may spawn
     * @param An int for the maximum Y-Coordinate height at which this block may spawn
     **/
    
    public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
        assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
        assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
        assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
 
        int diffBtwnMinMaxY = maxY - minY;
        for (int x = 0; x < chancesToSpawn; x++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }
}