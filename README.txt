# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API] (http://docs.themoviedb.apiary.io/#).

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic] (https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading.
- [ ] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

<img src="https://submissions.us-east-1.linodeobjects.com/android_university_kotlin/UM7xCSYa.gif" width=250><br>

### Notes
Creating the basic features of the app was easy as I just had to follow the instructions, but once I had to start create the extra features from the stretch stories, things got harder for sure. I think one of the most difficult thing was trying to figure things out using Kotlin because this is a brand new language, and I didn't have any android development experience beforehand, but it was definitely cool to see how things were put together and it was very awarding when the app finally worked the way you wanted it to (although it might not the best way to do it?).

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids