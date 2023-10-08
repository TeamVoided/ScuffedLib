package org.teamvoided.scuffedlib.sign.block

import net.minecraft.block.sign.WallHangingSignBlock
import net.minecraft.util.Identifier
import net.minecraft.block.sign.SignType

class VoidWallHangingSignBlock(override val texture: Identifier, settings: Settings, woodType: SignType) :
    WallHangingSignBlock(settings.solid(), woodType), VoidSign

