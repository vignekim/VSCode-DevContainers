<template>
  <div>
    <HeadView />
    <router-view />
  </div>
</template>

<script>
import HeadView from '@/components/HeadView.vue'
export default {
  name: 'App',
  components: {
    HeadView
  }
}
</script>

<style lang="scss">

</style>