# TODO: Theme switch in the main screen overflow menu

## Idea

On the main screen, pressing the three-dot (overflow) menu should, by default, offer an option to switch the theme.

This is a convenience improvement: users currently have to navigate into Settings to change the appearance (light / dark / system). Surfacing a quick theme toggle directly in the main screen overflow menu would make it reachable in a single tap.

## Proposed behavior

- Open the main screen (room list / home).
- Tap the three-dot menu in the top app bar.
- The first / default item is **Change theme** (cycles light → dark → system, or opens a small picker).
- The rest of the existing overflow items remain below it.

## Open questions

- Should it cycle themes or open a picker?
- Where exactly in the menu order should it sit (top, or grouped with other display options)?
- Should the choice persist and respect the existing theme storage?

## Status

- [ ] Idea captured, not yet implemented.
- [ ] Confirm desired interaction (cycle vs picker).
- [ ] Implement in the main screen overflow menu.
- [ ] Add UI test.
