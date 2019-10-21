# Game of Life

This is an example implementation of Conway's Game of Life in Java.
The primary focus of the implementation is cleanliness, not performance.
It serves as a lose guideline for Nelkinda Coderetreat facilitators.

## Rules of Conway's Game of Life
> The universe of the _Game of Life_ is an infinite, two-dimensional orthogonal grid of square cells.
> Each cell is in one of two possible states:
> * Alive aka populated
> * Dead aka unpopulated
> 
> Every cell interacts with its eight neighbors.
>The neighbors are the cells that are horizontally, vertically, or diagonally adjacent.
> At each step in time, the following transitions occur:
> 1. Underpopulation: Any live cell with fewer than 2 live neighbors dies.
> 1. Survival: Any live cell with 2 or 3 live neighbors survives on to the next generation.
> 1. Overpopulation Any live cell with more than 3 live neighbors dies.
> 1. Reproduction (birth): Any dead cell with exactly 3 live neighbors becomes a live cell.
— [Conway's Game of Life - Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

## Activities (aka Constraints)
This implementation of Game of Life implements the following activities:
* Test-Driven Development.
* Immutable objects only.
  Only pure functions.
* No variable reassignments (except for the Parser).
* Started: No naked primitives, not followed through yet.
* Short functions only.
  Most functions are one line only.
  Exception: Some constructors are 2 lines, the Parser is big.

## References
- [Coderetreat](https://www.coderetreat.org/)
- [Conway's Game of Life - Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
