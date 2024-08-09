<template>
  <b-row>
    <b-col xs="12" md="1"></b-col>
    <b-col xs="12" md="10">
    <div class="search-result">
      <h4 class="result-title"><a v-bind:href="url">{{ title }}</a></h4>
      <hr class="result-title-content-border"/>
      <p class="result-desc">{{description }}</p>
    </div>
    </b-col>
    <b-col xs="12" md="1"></b-col>
  </b-row>
</template>

<script>
export default {
  name: "SearchResult.vue",
  props: {
    url: String,
    title: String,
    description: String
  }
}
</script>

<style scoped>
.result-title {
  text-align: left !important;
}

.result-desc {
  text-align: left !important;
}
</style>