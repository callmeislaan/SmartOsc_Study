const BASE_URL = "http://localhost:1977/api_v1";

export var ENDPOINT = {
    persons : {
        list : `${BASE_URL}/person/all`
    },
    account : `${BASE_URL}/account`,
    person : `${BASE_URL}/person/`,
    save : `${BASE_URL}/person/save`,
    findByNameAndStatus: `${BASE_URL}/person/find-by-name-and-status`,
    addTask : `${BASE_URL}/person/add-task`,
    getTask : `${BASE_URL}/person/get-task`
}

export var HTTP_METHOD = {
    get : "GET",
    post : "POST"
}