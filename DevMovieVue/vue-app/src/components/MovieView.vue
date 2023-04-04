<template>
  <div class="movies-list">

    <div class="movie" v-for="movie in movies" :key="movie.imdbID">
      <a :href="'/movie/' + movie.imdbID" class="movie-link">
        <div class="product-image">
          <img :src="(movie.Poster == 'N/A') ? Poster : movie.Poster" :alt="movie.Title + ' Poster'"/>
          <div class="type">{{ movie.Type }}</div>
        </div>
        <div class="detail">
          <p class="year">{{ movie.Year }}</p>
          <h3>{{ movie.Title }}</h3>
        </div>
      </a>
    </div>

  </div>
</template>

<script>
export default {
  name: 'MovieView',
  props: {
    movies: []
  },
  data() {
    return {
      Poster: 'https://via.placeholder.com/150/000000/000000?Text='
    }
  }
}
</script>

<style lang="scss">
.movies-list {
  display: flex;
  flex-wrap: wrap;
  margin: 0px 8px;

  .movie {
    max-width: 50%;
    flex: 1 1 50%;
    padding: 16px 8px;

    .movie-link {
      display: flex;
      flex-direction: column;
      height: 100%;

      .product-image {
        position: relative;
        display: block;

        img {
          display: block;
          width: 100%;
          height: 275px;
          object-fit: cover;
        }

        .type {
          position: absolute;
          padding: 8px 16px;
          background-color: #42B883;
          color: #FFF;
          bottom: 16px;
          left: 0px;
          text-transform: capitalize;
        }
      }

      .detail {
        background-color: #496583;
        padding: 16px 8px;
        flex: 1 1 100%;
        border-radius: 0px 0px 8px 8px;

        .year {
          color: #AAA;
          font-size: 14px;
        }

        h3 {
          color: #FFF;
          font-weight: 600;
          font-size: 18px;
        }
      }
    }
  }
}
</style>