import {shallowMount} from '@vue/test-utils'
import SearchResultComponent from "@/components/SearchResult";

describe("testing search result component", () => {

    var searchData = {
        "title": "a Title",
        "url": "aplace.here",
        "description": "the description"
    };

    var mountOptions = {
        propsData: searchData
    }

    it('makes outer div with class result', async () => {
        // The render method returns a collection of utilities to query your component.
        var renderedComponent = shallowMount(SearchResultComponent, mountOptions)

        expect(renderedComponent.html()).toContain("search-result")
    });

    it('makes title block', async () => {
        // The render method returns a collection of utilities to query your component.
        var renderedComponent = shallowMount(SearchResultComponent, mountOptions)
        var renderedTitle = renderedComponent.find(".result-title");
        var renderedTitleText = renderedTitle.element.textContent

        expect(renderedTitleText).toContain("a Title")
    });

    it('makes title block url', async () => {
        // The render method returns a collection of utilities to query your component.
        var renderedComponent = shallowMount(SearchResultComponent, mountOptions)
        var renderedTitleurl = renderedComponent.find(".result-title a");
        var actualurl = renderedTitleurl.element.attributes.getNamedItem("href").value

        expect(actualurl).toContain("aplace.here")
    });

    it('makes description section', async () => {
        // The render method returns a collection of utilities to query your component.
        var renderedComponent = shallowMount(SearchResultComponent, mountOptions)
        var renderedDesciption = renderedComponent.find(".result-desc");
        var descriptionText = renderedDesciption.element.textContent;
        expect(descriptionText).toContain("the description")
    });
})