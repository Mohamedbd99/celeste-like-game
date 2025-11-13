# celeste-like-game

2D platformer (Celeste-like) for Design Patterns project.

## High-level rules applied

- Favor composition over inheritance
- Small, single-responsibility classes
- Clear separation of concerns:
  - Core game loop / state machine
  - Gameplay (player, enemies, combat)
  - World/levels (Composite-friendly)
  - Input layer (separate from gameplay)
  - Infrastructure (logging, config)
- Ready for State, Decorator, Composite, and extra patterns.

## Build

```bash
mvn clean package
```

