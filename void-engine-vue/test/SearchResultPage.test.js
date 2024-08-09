import {shallowMount} from '@vue/test-utils'
import SearchResultPage from "@/components/SearchResultPage";
import SearchResultList from "@/components/SearchResultList";

describe("testing search result list component", () => {

    it('makes outer div with id search-result-page', async () => {
        var renderedComponent = shallowMount(SearchResultPage);
        var actualhtml = renderedComponent.find("#search-result-page");

        expect(actualhtml.exists()).toBeTruthy();
    });

    it('search-result-list', async () => {
        var renderedComponent = shallowMount(SearchResultPage);
        var actualComponent = renderedComponent.find(SearchResultList);

        expect(actualComponent.exists()).toBeTruthy();
    });




})