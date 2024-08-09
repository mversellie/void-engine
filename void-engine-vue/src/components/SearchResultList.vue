<template>
  <span class="search-result-span">
      <search-result v-for="searchResult in results" :url="searchResult.url" :title="searchResult.title" :key="searchResult.url"
                     :description="getDescription(searchResult)"></search-result>
  </span>
</template>

<script>
import SearchResult from "./SearchResult.vue"

export default {
  name: "SearchResultList.vue",
  components: {SearchResult},
  props: {
    results: Array
  },
  methods:{
    isEmpty(description){
      return (description === undefined || description === null);
    },
    getDescription(aSearchResult){
      if (this.isEmpty(aSearchResult.description) || aSearchResult.description.length == 0)  {
        if (this.isEmpty(aSearchResult.content)) {
          return "";
        } else {
          return aSearchResult.content.substring(0, 300);
        }
      } else {
        return aSearchResult.description[0];
      }
    }
  }
}
</script>

<style scoped>
.search-result-span {
  min-width: 100%;
}
</style>