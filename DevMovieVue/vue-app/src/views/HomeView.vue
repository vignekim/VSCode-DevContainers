<template>
  <main class="home">

    <div class="feature-card">
      <a :href="'/movie/' + main.imdbID">
        <img :src="main.Poster" :alt="main.Title + ' Poster'" class="featured-img" />
        <div class="detail">
          <h3>{{ main.Title }}</h3>
          <p>{{ main.Plot }} </p>
        </div>
      </a>
    </div>

    <form @submit.prevent="searchMovies" class="search-box">
      <input type="text" placeholder="영화 제목을 입력하세요." v-model="search"/>
      <input type="submit" value="검색" />
    </form>

    <MovieView :movies="movies" />

  </main>
</template>

<script>
import env from '@/env.js'
import axios from 'axios'
import MovieView from '@/components/MovieView.vue'
export default {
  name: 'HomeView',
  components: {
    MovieView
  },
  data() {
    return {
      search: '',
      movies: [],
      main: env.main
    }
  },
  methods: {
    searchMovies() {
      //console.log(this.search)
      if(this.search != '') {
        const params = {params: {apikey: env.apikey, s: this.search}}
        axios.get('https://www.omdbapi.com/', params)
        .then(res => {
          //console.log(res)
          this.movies = res.data.Search
          this.search = ''
        })
        .catch(err => console.log(err))
      }
    }
  }
}
</script>

<style lang="scss">
.home {
  .feature-card {
    position: relative;

    .featured-img {
      display: block;
      width: 100%;
      height: 300px;
      object-fit: cover;

      position: relative;
      z-index: 0;
    }

    .detail {
      position: absolute;
      left: 0;
      right: 0;
      bottom: 0;
      background-color: rgba(0, 0, 0, 0.6);
      padding: 16px;
      z-index: 1;

      h3 {
        color:#FFF;
        margin-bottom: 16px;
      }

      p {
        color: #FFF;
      }
    }
  }

  .search-box {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 16px;

    input {
      display: block;
      appearance: none;
      border: none;
      outline: none;
      background: none;

      &[type="text"] {
        width: 100%;
        color: #FFF;
        background-color: #496583;
        font-size: 20px;
        padding: 10px 16px;
        border-radius: 8px;
        margin-bottom: 15px;
        transition: 0.4s;

        &::placeholder {
          color: #f3f3f3;
        }

        &:focus {
          box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.2);
        }
      }

      &[type="submit"] {
        width: 100%;
        max-width: 300px;
        background-color: #42B883;
        padding: 16px;
        border-radius: 8px;
        color: #FFF;
        font-size: 20px;
        text-transform: uppercase;
        transition: 0.4s;
        cursor: pointer;

        &:active {
          background-color: #3B8070;
        }
      }
    }
  }
}
</style>