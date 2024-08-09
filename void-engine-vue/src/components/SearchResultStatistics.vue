<template>
  <b-row>
    <b-col xs="12" md="1"></b-col>
    <b-col xs="12" md="10">
      <div class="search-stats" v-if="numberOfResults >= 0">
        <p>Results Found: {{numberOfResults}}</p>
        <hr class="result-title-content-border"/>
      </div>
    </b-col>
    <b-col xs="12" md="1"></b-col>
  </b-row>
</template>

<script>
export default {
  name: "SearchResultStatistics.vue",
  props: {
    numberOfResults : Number
  }
}
</script>

<style scoped>

</style>