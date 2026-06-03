package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

public class FireflyLeavesBlock extends UntintedParticleLeavesBlock {

    public FireflyLeavesBlock(float leafParticleChance, ParticleOptions leafParticle, Properties properties) {
        super(leafParticleChance, leafParticle, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (random.nextInt(30) == 0 &&
                (Boolean)level.environmentAttributes().getValue(EnvironmentAttributes.FIREFLY_BUSH_SOUNDS, pos) &&
                level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos) <= pos.getY()) {

            level.playLocalSound(pos, SoundEvents.FIREFLY_BUSH_IDLE, SoundSource.AMBIENT, 1.0F, 1.0F, false);
        }

        if (level.getMaxLocalRawBrightness(pos) <= 13 && random.nextDouble() <= 0.7) {
            double fireflyX = (double)pos.getX() + random.nextDouble() * 10.0D - 5.0D;
            double fireflyY = (double)pos.getY() + random.nextDouble() * 5.0D;
            double fireflyZ = (double)pos.getZ() + random.nextDouble() * 10.0D - 5.0D;

            level.addParticle(ParticleTypes.FIREFLY, fireflyX, fireflyY, fireflyZ, 0.0D, 0.0D, 0.0D);
        }
    }
}