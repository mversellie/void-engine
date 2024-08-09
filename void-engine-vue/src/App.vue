<template>
  <div id="app">
  <SearchResultPage></SearchResultPage>
  </div>
</template>

<script>
import SearchResultPage from "./components/SearchResultPage"
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

export default {
  name: 'App',
  components: {
    SearchResultPage
  }
}
</script>

<style lang="scss">
@import 'assets/styles/custom-bootstrap.scss';
@import 'assets/styles/app.scss';

@import '~bootstrap/scss/bootstrap.scss';
@import '~bootstrap-vue/src/index.scss';


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /*margin-top: 60px;*/
}
</style>
