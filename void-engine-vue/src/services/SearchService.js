import axios from "axios";

export default {
    callSearch: function (query) {
        const parameters = new URLSearchParams()
        parameters.set("query",query)
        const restAddress =  `${window.location.protocol}//${window.location.host}/api?${parameters.toString()}`
        return axios.get(restAddress)
    }
}