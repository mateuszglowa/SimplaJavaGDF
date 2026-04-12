# SimpleJavaGDF

A small 2D Java game framework and sample endless-runner game built with Swing/AWT.

The game is inspired by a side-scroller style loop: dodge moving blocks, survive as long as possible, and improve your score.

## Project Status

This repository is a learning-oriented project with a complete playable loop:

- Loading state that initializes resources
- Menu state for start/exit
- Play state with running, jumping, ducking, collision, and score
- Game over state with restart flow

## Tech Stack

- Java (desktop)
- Swing/AWT for rendering and input
- Custom game loop targeting roughly 60 FPS (~17 ms/frame)
- Image and WAV assets loaded from classpath (`src/resources`)

## How The Game Works

### State Flow

The game transitions through these states:

1. `LoadState` -> loads images, sounds, and animation frames
2. `MenuState` -> lets player start game or exit
3. `PlayState` -> active gameplay and score counting
4. `GameOverState` -> displays score and returns to menu on key press

### Gameplay

- The player stays at a mostly fixed horizontal position.
- Obstacles move left and recycle after leaving the screen.
- Some obstacles appear high, some low, forcing jump/duck decisions.
- Collision pushes the player backward; once pushed too far, the run ends.
- Score increases over time and obstacle speed ramps up gradually.

## Controls

- `Space`: jump
- `Down Arrow`: duck
- Menu navigation:
	- `Up Arrow` / `Down Arrow`: change selection
	- `Enter` or `Space`: confirm
- `Any key` on game over: return to menu

## Project Structure

```
src/
	com/mglo/animation/           # Animation primitives
	com/mglo/framework/util/      # Input and utility helpers
	com/mglo/game/main/           # Entry point, game panel, resource loading
	com/mglo/game/model/          # Player, obstacle, cloud entities
	com/mglo/game/state/          # State machine and game states
	resources/                    # PNG and WAV assets
```

## Build And Run

### Prerequisites

- JDK 8 recommended

Why JDK 8: the project uses `java.applet.AudioClip` and `Applet.newAudioClip`, which are legacy APIs and may not work on modern JDKs without changes.

### Run From IntelliJ IDEA

1. Open the project root.
2. Ensure `src` is marked as a source root.
3. Run `com.mglo.game.main.GameMain`.

### Run From Terminal (example)

From project root:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out:src com.mglo.game.main.GameMain
```

Notes:

- `src` is included on classpath so `/resources/*` can be loaded.
- On Windows, use `;` instead of `:` in classpath.

## Codebase Analysis

### What Is Good

- Clear separation between states (`State` abstraction).
- Simple, understandable game loop and rendering pipeline.
- Resource loading centralized in one place (`Resources`).
- Basic animation system is reusable for other sprites.

### Current Limitations

- Uses deprecated Applet-based audio API.
- Some unused/legacy imports and debug prints remain.
- Rendering path mixes active rendering and Swing repaint, which can cause redundant drawing.
- No build tool (`Maven`/`Gradle`) or test suite.

### Suggested Next Improvements

1. Replace Applet audio with `javax.sound.sampled.Clip`.
2. Add a build system (preferably Gradle) and a run task.
3. Clean unused imports and debug output.
4. Add basic unit tests for utility and game-logic classes.
5. Introduce a delta-time clamp and optional fixed timestep update.

## Credits

- Based on a tutorial by James Cho: www.jamescho7.com
