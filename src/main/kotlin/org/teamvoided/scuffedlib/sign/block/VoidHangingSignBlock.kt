package org.teamvoided.scuffedlib.sign.block

import net.minecraft.block.sign.CeilingHangingSignBlock
import net.minecraft.util.Identifier
import net.minecraft.block.sign.SignType

class VoidHangingSignBlock(override val texture: Identifier, settings: Settings, woodType: SignType) :
    CeilingHangingSignBlock(settings.solid(), woodType), VoidSign

