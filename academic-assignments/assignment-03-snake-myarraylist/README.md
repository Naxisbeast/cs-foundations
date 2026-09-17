# Assignment 03: Text-Based Snake With MyArrayList

## Topic / Concept Focus

This learning exercise focused on using a custom array list structure in a small text-based game.

## Task Summary

The task involved building a text-based Snake game on a 10x10 grid. The snake body segments were stored using `MyArrayList`. The game included WASD movement, food placement, scoring, collision checks, self-collision checks, a restart option, and boundary wrapping.

## Data Structures Or Algorithms Used

- Custom array list
- Grid representation
- Sequential movement updates
- Collision detection
- Simple game loop logic

## What I Learned

- How a list can store changing game state.
- How movement affects multiple body segments.
- Why collision checks need careful edge-case handling.
- How small games can help practise data structures in a practical way.

## How I Would Improve It Now

- Split the game into smaller classes such as `Snake`, `GameBoard`, and `Food`.
- Make the movement and collision logic easier to test.
- Improve input handling.
- Add clearer comments around the body update logic.
