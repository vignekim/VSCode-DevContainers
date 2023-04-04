<template>
  <main class="movie-detail">

    <div v-if="show == 1">
      <h2>{{ movie.Title }}<span>{{ movie.Type }}</span></h2>
      <p>{{ movie.Year }}</p>
      <p>{{ movie.Country }}</p>
      <img :src="(movie.Poster == 'N/A') ? Poster : movie.Poster" :alt="movie.Title + ' Poster'" class="featured-img" />
      <p>{{ (movie.Plot == 'N/A') ? Plot : movie.Plot }}</p>
    </div>

    <div class="text-center" v-if="show == 2">
      <h2>선택한 내용이 없습니다.</h2>
      <p>다시 검색하세요.</p>
    </div>

  </main>
</template>

<script>
import env from '@/env.js'
import axios from 'axios'
export default {
  name: 'MovieDetail',
  data() {
    return {
      show: 0,
      movie: {},
      Poster: 'https://via.placeholder.com/150/000000/000000?Text=',
      Plot: '설명이 없습니다.'
    }
  },
  created() {
    this.searchMovie()
  },
  methods: {
    searchMovie() {
      //console.log(this.$route.params.imdbID)
      if(this.$route.params.imdbID != '') {
        const params = {params: {apikey: env.apikey, i: this.$route.params.imdbID, plot: 'full'}}
        axios.get('https://www.omdbapi.com/', params)
          .then(res => {
            //console.log(res)
            if(res.data.Response == 'True') {
              this.movie = res.data
              this.show = 1
            } else {
              this.show = 2
              this.movie = {}
            }
          })
          .catch(err => console.log(err))
      }
    }
  }
}
</script>

<style lang="scss">
.movie-detail {
  padding: 16px;

  h2 {
    color: #FFF;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 16px;
  }

  span {
    margin: 0 16px;
    padding: 10px;
    border-radius: 10px;
    background-color: #42B883;
    color: #FFF;
    font-size: 18px;
  }

  .featured-img {
    display: block;
    max-width: 200px;
    margin-bottom: 16px;
  }

  p {
    color: #FFF;
    font-size: 18px;
    line-height: 1.4;
  }

  .text-center {
    text-align: center;
  }
}
</style>