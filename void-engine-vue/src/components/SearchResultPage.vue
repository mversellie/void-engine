<template>
  <div id="search-result-page">
    <b-container fluid="md">
      <b-row class="text-center">
        <b-col col md="2" sm="12" lg="1"></b-col>
        <b-col col md="8" sm="12" lg="10">
          <b-row class="text-center">
            <b-col col sm=12 md="1">
            </b-col>
            <b-col col sm=12 md="10">
              <h1 class="title">VOID ENGINE</h1>
              <div class="search-bar">
                <b-button-toolbar aria-label="Toolbar with button groups and input groups">
                  <b-button-group size="sm" class="mr-1" v-on:click="search">
                    <b-button class="search-button">Search</b-button>
                  </b-button-group>
                  <b-input-group class="search-outer-bar">
                    <b-form-input v-model="searchQuery" v-on:keyup.enter="search"
                                  class="text-right search-field"></b-form-input>
                  </b-input-group>
                  <a target="_blank" rel="noopener noreferrer" href="https://github.com/mversellie/void-engine-vue"> <img alt="" :src="gitHubImage" width="30px" height="30px"/></a>
                </b-button-toolbar>
              </div>
            </b-col>
            <b-col col sm=12 md="1">
            </b-col>
          </b-row>
          <search-result-statistics :numberOfResults="this.searchCount" />
          <b-row class="search-result-list">
            <search-result-list :results="this.results"/>
          </b-row>
        </b-col>
        <b-col col sm=12 md="2" lg="1">
        </b-col>
      </b-row>

    </b-container>

  </div>
</template>

<script>

import gitImage from "../assets/GitHub-Mark-Light.png"
import SearchResultList from "./SearchResultList.vue";
import SearchService from "@/services/SearchService.js";
import SearchResultStatistics from "@/components/SearchResultStatistics";

export default {

  name: "SearchResultPage.vue",
  components: {SearchResultStatistics, SearchResultList},
  data: function () {
    return {
      "searchQuery": "",
      "results": [],
      "searchCount":-1,
      "gitHubImage":gitImage
    }
  },
  methods: {
    search() {
      if (this.searchQuery != null && this.searchQuery.trim() != "") {
        SearchService.callSearch(this.searchQuery)
            .then(response => {
              console.log(response.data);
              this.searchCount = response.data.resultsCount;
              this.results = response.data.results;
            });
      }
    }
  }
}
</script>

<style scoped>
#search-result-page {
  width: 100%;
}

</style>