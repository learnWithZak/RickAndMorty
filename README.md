### RickAndMorty application

## Overview

This application uses the Rick and Morty API. It retrieves all characters, locations and episodes of the sitcom.
When the user clicks on a character, the application shows the details of the chosen character.
A bottom navigation bar was added to switch between characters, locations and episodes views.

## Architecture

This application uses MVVM architecture with a single remote repository, no need to have a cache for data that was retrieved.
Koin was used to inject needed objects.
Jetpack compose was used to give the UI the flexibility that kotlin afford (a second solution could be made by using a single Activity that hosts 3 fragments, and a recyclerview with the adapter, but it will have more boilerplate to handle).

## Demo



https://user-images.githubusercontent.com/111642558/226315427-a0825c59-9abf-4abf-a557-7f7335df0677.mp4

