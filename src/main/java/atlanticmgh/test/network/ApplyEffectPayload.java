package atlanticmgh.test.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ApplyEffectPayload(String effect) implements CustomPayload {
    public static final Id<ApplyEffectPayload> ID = new Id<>(Identifier.of("test", "apply_effect"));
    public static final PacketCodec<RegistryByteBuf, ApplyEffectPayload> CODEC =
            PacketCodec.of((value, buf) -> buf.writeString(value.effect()),
                    buf -> new ApplyEffectPayload(buf.readString()));

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
