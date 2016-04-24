package fr.icat.bunnyjump.consts;

import com.badlogic.ashley.core.ComponentMapper;
import fr.icat.bunnyjump.components.AccelComponent;
import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.CarrotAttackComponent;
import fr.icat.bunnyjump.components.CarrotComponent;
import fr.icat.bunnyjump.components.CoinComponent;
import fr.icat.bunnyjump.components.DeadEffectComponent;
import fr.icat.bunnyjump.components.MonsterComponent;
import fr.icat.bunnyjump.components.PowerComponent;
import fr.icat.bunnyjump.components.TimerComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.SecureZoneComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TimeLifeComponent;
import fr.icat.bunnyjump.components.collision.BankerCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.CoinCollisionComponent;
import fr.icat.bunnyjump.components.collision.MagicianCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterDefenseCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.CameraComponent;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.PlatformComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.ScoreComponent;
import fr.icat.bunnyjump.components.collision.BunnyAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.JumperCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.components.collision.PowerCollisionComponent;

import fr.icat.bunnyjump.components.TransformComponent;


/**
 * Stockage des componentMappers
 */
public final class Mapper {

    public static ComponentMapper<BunnyComponent> Bunny
            = ComponentMapper.getFor(BunnyComponent.class);

    public static ComponentMapper<TextureComponent> Texture
            = ComponentMapper.getFor(TextureComponent.class);

    public static ComponentMapper<CameraComponent> Camera
            = ComponentMapper.getFor(CameraComponent.class);

    public static ComponentMapper<GravityComponent> Gravity
            = ComponentMapper.getFor(GravityComponent.class);

    public static ComponentMapper<PlatformComponent> Platform
            = ComponentMapper.getFor(PlatformComponent.class);

    public static ComponentMapper<TransformComponent> Transform
            = ComponentMapper.getFor(TransformComponent.class);

    public static ComponentMapper<VelocityComponent> Velocity
            = ComponentMapper.getFor(VelocityComponent.class);

    public static ComponentMapper<LifeComponent> Life
            = ComponentMapper.getFor(LifeComponent.class);

    public static ComponentMapper<MonsterComponent> Monster
            = ComponentMapper.getFor(MonsterComponent.class);

    public static ComponentMapper<ScoreComponent> Score
            = ComponentMapper.getFor(ScoreComponent.class);

    public static ComponentMapper<JumperCollisionComponent> Jumper
            = ComponentMapper.getFor(JumperCollisionComponent.class);

    public static ComponentMapper<PlatformCollisionComponent> PlatformCollision
            = ComponentMapper.getFor(PlatformCollisionComponent.class);

    public static ComponentMapper<TransporterComponent> Transporter
            = ComponentMapper.getFor(TransporterComponent.class);

    public static ComponentMapper<SecureZoneComponent> SecureZone
            = ComponentMapper.getFor(SecureZoneComponent.class);

    public static ComponentMapper<BunnyDefenseCollisionComponent> BunnyDefense
            = ComponentMapper.getFor(BunnyDefenseCollisionComponent.class);

    public static ComponentMapper<BunnyAttackCollisionComponent> BunnyAttack
            = ComponentMapper.getFor(BunnyAttackCollisionComponent.class);

    public static ComponentMapper<MonsterAttackCollisionComponent> MonsterAttack
            = ComponentMapper.getFor(MonsterAttackCollisionComponent.class);

    public static ComponentMapper<MonsterDefenseCollisionComponent> MonsterDefense
            = ComponentMapper.getFor(MonsterDefenseCollisionComponent.class);

    public static ComponentMapper<DeadEffectComponent> DeadEffect
            = ComponentMapper.getFor(DeadEffectComponent.class);

    public static ComponentMapper<TimeLifeComponent> TimeLife
            = ComponentMapper.getFor(TimeLifeComponent.class);

    public static ComponentMapper<TransportableComponent> Transportable
            = ComponentMapper.getFor(TransportableComponent.class);

    public static ComponentMapper<PowerComponent> Power
            = ComponentMapper.getFor(PowerComponent.class);

    public static ComponentMapper<PowerCollisionComponent> PowerCollision
            = ComponentMapper.getFor(PowerCollisionComponent.class);

    public static ComponentMapper<MagicianCollisionComponent> MagicianCollision
            = ComponentMapper.getFor(MagicianCollisionComponent.class);

    public static ComponentMapper<TimerComponent> Timer
            = ComponentMapper.getFor(TimerComponent.class);

    public static ComponentMapper<TSC> TSC
            = ComponentMapper.getFor(TSC.class);

    public static ComponentMapper<BankerCollisionComponent> BankerCollision
            = ComponentMapper.getFor(BankerCollisionComponent.class);

    public static ComponentMapper<CoinCollisionComponent> CoinCollision
            = ComponentMapper.getFor(CoinCollisionComponent.class);

    public static ComponentMapper<CoinComponent> Coin
            = ComponentMapper.getFor(CoinComponent.class);

    public static ComponentMapper<CarrotComponent> Carrot
            = ComponentMapper.getFor(CarrotComponent.class);

    public static ComponentMapper<CarrotAttackComponent> CarrotAttack
            = ComponentMapper.getFor(CarrotAttackComponent.class);

    public static ComponentMapper<CarrotAttackCollisionComponent> CarrotAttackCollision
            = ComponentMapper.getFor(CarrotAttackCollisionComponent.class);

    public static ComponentMapper<CarrotDefenseCollisionComponent> CarrotDefenseCollision
            = ComponentMapper.getFor(CarrotDefenseCollisionComponent.class);

    public static ComponentMapper<AccelComponent> Accel
            = ComponentMapper.getFor(AccelComponent.class);
}
